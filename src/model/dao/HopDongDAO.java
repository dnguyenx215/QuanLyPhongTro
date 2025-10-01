package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import model.bean.HopDong;
import model.bean.Phong;
import model.bean.SinhVien;

public class HopDongDAO {
	private Connection conn;

	public void moKetNoi() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QuanLyPhongTro", "sa",
					"123456");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean xuLy(String sql) {
		try {
			moKetNoi();
			conn.createStatement().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return false;

	}

	public boolean xoaHopDong(int id) {
		String sql = "DELETE FROM dbo.HopDong WHERE IDHD =" + id;

		return xuLy(sql);
	}

	public boolean suaHopDong(HopDong obj) {
		int id = obj.getId();
		int idSinhVien = obj.getIdSinhVien();
		int idPhong = obj.getIdPhong();
		Date ngayTao = obj.getNgayTao();
		Date ngayBatDau = obj.getNgayBatDau();
		Date ngayKetThuc = obj.getNgayKetThuc();
		SimpleDateFormat sp = new SimpleDateFormat("MM/dd/yyyy");
		PhongDAO phongDAO = new PhongDAO();
		SinhVienDAO sinhVienDAO = new SinhVienDAO();
		SinhVien sinhVien = sinhVienDAO.laySinhVien(idSinhVien);
		Phong phongMoi = phongDAO.layPhong(idPhong);
		// Phong phongCu = phongDAO.layPhong(layHopDong(id).getIdPhong());
		String sql = String.format(
				"UPDATE dbo.HopDong SET IDSV=%s,IDP=%s,NgayTao='%s',NgayBatDau='%s',NgayKetThuc='%s' WHERE IDHD=%s;",
				idSinhVien, idPhong, sp.format(ngayTao), sp.format(ngayBatDau), sp.format(ngayKetThuc), id);

		// if (phongCu.getId() == phongMoi.getId())
		// return xuLy(sql);
		if (ngayBatDau.after(ngayKetThuc)) {
			return false;
		}

		if (phongMoi.getSoNguoiHienTai() >= phongMoi.getSoNguoiToiDa()) {
			return false;
		}
		// nếu phòng mới
		if (phongMoi.getSoNguoiHienTai() > 0) {
			ArrayList<Phong> dsPhong = phongDAO.layHetPhongTheoGioiTinh(sinhVien.getGioiTinh());
			boolean dungGioiTinh = true;
			for (Phong phong2 : dsPhong) {
				if (idPhong == phong2.getId()) {
					dungGioiTinh = false;
				}
			}
			if (dungGioiTinh) {
				return false;
			}
		}
		return xuLy(sql);
	}

	public boolean themHopDong(HopDong obj) {
		SimpleDateFormat sp = new SimpleDateFormat("MM/dd/yyyy");
		int idSinhVien = obj.getIdSinhVien();
		int idPhong = obj.getIdPhong();
		Date ngayTao = obj.getNgayTao();
		Date ngayBatDau = obj.getNgayBatDau();
		Date ngayKetThuc = obj.getNgayKetThuc();
		String sql = String.format("INSERT INTO HopDong VALUES (%s,%s,'%s','%s','%s');", idSinhVien, idPhong,
				sp.format(ngayTao), sp.format(ngayBatDau), sp.format(ngayKetThuc));
		if (kiemTraNgayKetThuc(ngayBatDau, idSinhVien))
			return false;
		PhongDAO phongDAO = new PhongDAO();
		Phong phong = phongDAO.layPhong(idPhong);
		if (kiemTraHopDongCuaSinhVien(idSinhVien) || ngayBatDau.after(ngayKetThuc)
				|| phong.getSoNguoiHienTai() >= phong.getSoNguoiToiDa()) {
			return false;
		}

		SinhVienDAO sinhVienDAO = new SinhVienDAO();
		SinhVien sv = sinhVienDAO.laySinhVien(idSinhVien);
		ArrayList<Phong> dsPhongs = phongDAO.layHetPhongTheoGioiTinh(sv.getGioiTinh());
		for (Phong p : dsPhongs) {
			if (p.getId() == idPhong) {
				return xuLy(sql);
			}
		}
		dsPhongs = phongDAO.layHetPhongTrong();
		for (Phong p : dsPhongs) {
			if (p.getId() == idPhong) {
				return xuLy(sql);
			}
		}
		return false;
	}

	public boolean kiemTraNgayKetThuc(Date d, int idSV) {
		String sql = String.format("select top(1) NgayKetThuc from HopDong where idsv=%s order by NgayKetThuc desc",
				idSV);
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			if (rs.next()) {
				Date d2 = rs.getDate(1);
				if (d.before(d2))
					return true;
				else {
					return false;
				}
			} else {
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return true;
	}

	public HopDong layHopDong(int id) {
		HopDong hopDong = null;
		String sql = String.format("select * from HopDong where IDHD=%s;", id);
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			if (rs.next()) {
				hopDong = new HopDong(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getDate(5),
						rs.getDate(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}

		return hopDong;
	}

	public boolean kiemTraHopDongCuaSinhVien(int idSV) {
		String sql = String.format("select * from HopDong where NgayKetThuc>GETDATE() and IDSV=%s;", idSV);
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return false;
	}

	public ArrayList<HopDong> layHetHopDong() {
		ArrayList<HopDong> hopDongs = new ArrayList<>();
		String sql = "select * from HopDong ORDER BY NgayKetThuc DESC;";
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				hopDongs.add(new HopDong(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDate(4), rs.getDate(5),
						rs.getDate(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return hopDongs;
	}

	public Hashtable<String, Integer> laySoLuong() {
		Hashtable<String, Integer> dsHopDongTheoThang = new Hashtable<>();
		moKetNoi();
		String sql = "SELECT TOP ( 12 )\r\n" + "        COUNT(*) soLuong ,\r\n" + "        YEAR(NgayTao) nam ,\r\n"
				+ "        MONTH(NgayTao) thang\r\n" + "FROM    HopDong\r\n" + "GROUP BY YEAR(NgayTao) ,\r\n"
				+ "        MONTH(NgayTao)\r\n" + "ORDER BY nam DESC ,\r\n" + "        thang DESC";
		try {
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				dsHopDongTheoThang.put(rs.getString("nam") + "-" + rs.getString("thang"), rs.getInt("soLuong"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return dsHopDongTheoThang;
	}

	public void dongKetNoi() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		HopDongDAO s = new HopDongDAO();
		// SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
		// try {
		// HopDong hd = new HopDong(16, 14, 4, sp.parse("22/01/2019"),
		// sp.parse("22/01/2019"), sp.parse("22/01/2019"));
		// s.suaHopDong(hd);
		// } catch (ParseException e) {
		// e.printStackTrace();
		// }
		// ArrayList<HopDong> h = s.layHetHopDong();
		// for (HopDong hopDong : h) {
		// System.out.println(hopDong);
		// }
		System.out.println(s.kiemTraHopDongCuaSinhVien(6));
	}
}
