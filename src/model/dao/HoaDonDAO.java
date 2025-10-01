package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.bean.HoaDon;
import model.bean.Phong;

public class HoaDonDAO {
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

	public boolean xoaHoaDon(int id) {
		String sql = "DELETE FROM dbo.HoaDon WHERE IDHDon=" + id;
		return xuLy(sql);

	}

	public boolean suaHoaDon(HoaDon obj) {
		int id = obj.getId();
		int idPhong = obj.getIdPhong();
		Date ngayLap = obj.getNgayLap();
		Date thangLap = obj.getThangLap();
		int chiSoCu = obj.getChiSoCu();
		int chiSoMoi = obj.getChiSoMoi();
		PhongDAO phongDAO = new PhongDAO();
		Phong phong = phongDAO.layPhong(idPhong);
		if (phong.getSoNguoiHienTai() <= 0)
			return false;
		int tienDien = 1500 * (chiSoMoi - chiSoCu);
		int tienNuoc = 15000 * phong.getSoNguoiHienTai();
		int tongTien = tienNuoc + tienDien;
		SimpleDateFormat sp = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat sp2 = new SimpleDateFormat("01/MM/yyyy");
		String sql = String.format(
				"UPDATE dbo.HoaDon SET IDP=%s,NgayLap='%s',Thang='%s',ChiSoCu=%s,ChiSoMoi=%s,TienDien=%s,TienNuoc=%s,TongTien=%s WHERE IDHDon=%s;",
				idPhong, sp.format(ngayLap), sp2.format(thangLap), chiSoCu, chiSoMoi, tienDien, tienNuoc, tongTien, id);
		System.out.println(sql);
		return xuLy(sql);
	}

	public boolean themHoaDon(HoaDon obj) {
		SimpleDateFormat sp = new SimpleDateFormat("MM/dd/yyyy");
		int idPhong = obj.getIdPhong();
		PhongDAO phongDAO = new PhongDAO();

		Phong phong = phongDAO.layPhong(idPhong);
		if (phong.getSoNguoiHienTai() <= 0)
			return false;
		Date ngayLap = obj.getNgayLap();
		Date thangLap = obj.getThangLap();
		int chiSoCu = obj.getChiSoCu();
		int chiSoMoi = obj.getChiSoMoi();
		if (chiSoCu < 0 || chiSoCu > chiSoMoi)
			return false;
		int tienDien = 1500 * (chiSoMoi - chiSoCu);
		int tienNuoc = 15000 * phong.getSoNguoiHienTai();
		int tongTien = tienNuoc + tienDien;
		String sql = String.format("INSERT INTO HoaDon VALUES (%s,'%s','%s',%s,%s,%s,%s,%s);", idPhong,
				sp.format(ngayLap), sp.format(thangLap), chiSoCu, chiSoMoi, tienDien, tienNuoc, tongTien);
		return xuLy(sql);
	}

	public HoaDon layHoaDon(int id) {
		String sql = String.format("select * from HoaDon where IDHDon=%s;", id);
		HoaDon hoaDon = null;
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			if (rs.next()) {
				hoaDon = new HoaDon(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getDate(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return hoaDon;

	}

	public ArrayList<HoaDon> layHetHoaDon() {
		ArrayList<HoaDon> hoaDons = new ArrayList<>();
		String sql = "select * from HoaDon ORDER BY NgayLap DESC;";
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				hoaDons.add(new HoaDon(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getDate(4), rs.getInt(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return hoaDons;
	}

	public void dongKetNoi() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		HoaDonDAO h = new HoaDonDAO();
		SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
		// SimpleDateFormat sp2 = new SimpleDateFormat("MM/yyyy");
		try {
			HoaDon hh = new HoaDon(17, 5, sp.parse("25/05/2005"), sp.parse("02/09/2005"), 111, 222, 333, 444, 555);
			System.out.println(hh.toString());
			System.out.println(h.suaHoaDon(hh));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// ArrayList<HoaDon> kk = h.layHetHoaDon();
		// for (HoaDon hoaDon : kk) {
		// System.out.println(hoaDon.getNgayLap2() + " " + hoaDon.getNgayLap());
		// }
		// h.xoaHoaDon(10);
		// System.out.println("222222222224442222222222");
		// kk = h.layHetHoaDon();
		// for (HoaDon hoaDon : kk) {
		// System.out.println(hoaDon);
		// }

		// try {
		// h.moKetNoi();
		// h.conn.createStatement().executeUpdate("truncate table HoaDon");
		// for (HoaDon hoaDon : kk) {
		// h.themMoi(hoaDon);
		// }
		// } catch (SQLException e) {
		// e.printStackTrace();
		// } finally {
		// h.dongKetNoi();
		// }
		// ArrayList<HoaDon> kk2 = h.layDanhSach();
		// for (HoaDon hoaDon : kk2) {
		// System.out.println(hoaDon);
		// }

	}
}
