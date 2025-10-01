package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import model.bean.SinhVien;

public class SinhVienDAO {
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

	public boolean xoaSinhVien(int id) {
		String sql = String.format("delete from SinhVien where IDSV=%s;", id);
		return xuLy(sql);

	}

	public boolean suaSinhVien(SinhVien obj) {

		int id = obj.getId();
		String maSinhVien = obj.getMaSinhVien();
		String hoTen = obj.getHoTen();
		int idTruongHoc = obj.getIdTruongHoc();
		String lop = obj.getLop();
		int gioiTinh = obj.getGioiTinh();
		Date ngaySinh = obj.getNgaySinh();
		String soCMND = obj.getSoCMND();
		String sdt = obj.getSdt();
		SimpleDateFormat sp = new SimpleDateFormat("MM/dd/yyyy");
		String sql = String.format(
				"UPDATE SinhVien SET MaSV = '%s',HoTen = N'%s',IDTH =%s,Lop = '%s',GioiTinh = %s,NgaySinh = '%s',SoCMND = '%s',SDT = '%s' WHERE IDSV = '%s'",
				maSinhVien, hoTen, idTruongHoc, lop, gioiTinh, sp.format(ngaySinh), soCMND, sdt, id);
		return xuLy(sql);
	}

	public boolean themSinhVien(SinhVien obj) {
		String maSinhVien = obj.getMaSinhVien();
		String hoTen = obj.getHoTen();
		int idTruongHoc = obj.getIdTruongHoc();
		String lop = obj.getLop();
		int gioiTinh = obj.getGioiTinh();
		Date ngaySinh = obj.getNgaySinh();
		String soCMND = obj.getSoCMND();
		String sdt = obj.getSdt();
		SimpleDateFormat sp = new SimpleDateFormat("MM/dd/yyyy");
		String sql = String.format("INSERT INTO SinhVien VALUES ('%s', N'%s', %s,'%s', %s, '%s','%s','%s');",
				maSinhVien, hoTen, idTruongHoc, lop, gioiTinh, sp.format(ngaySinh), soCMND, sdt);
		return xuLy(sql);
	}

	public SinhVien laySinhVien(int id) {
		String sql = String.format("select * from SinhVien where IDSV=%s;", id);
		SinhVien sinhVien = null;
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			if (rs.next()) {
				sinhVien = new SinhVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getDate(7), rs.getString(8), rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return sinhVien;

	}

	public ArrayList<SinhVien> layHetSinhVien() {
		ArrayList<SinhVien> sinhViens = new ArrayList<>();
		String sql = "select * from SinhVien";
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				sinhViens.add(new SinhVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getString(5), rs.getInt(6), rs.getDate(7), rs.getString(8), rs.getString(9)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return sinhViens;
	}

	public Hashtable<Integer, SinhVien> layHetSinhVien2() {
		Hashtable<Integer, SinhVien> sinhViens = new Hashtable<>();
		String sql = "select * from SinhVien";
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				sinhViens.put(rs.getInt(1), new SinhVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getString(5), rs.getInt(6), rs.getDate(7), rs.getString(8), rs.getString(9)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return sinhViens;
	}

	public ArrayList<SinhVien> layHetSinhVienChuaThuePhong() {
		SimpleDateFormat sp = new SimpleDateFormat("MM/dd/yyyy");
		Date d = new Date();
		ArrayList<SinhVien> sinhViens = new ArrayList<>();
		String sql = String.format(
				"select * from SinhVien where IDSV not in ( select IDSV from HopDong where NgayKetThuc>'%s');",
				sp.format(d));
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				sinhViens.add(new SinhVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getString(5), rs.getInt(6), rs.getDate(7), rs.getString(8), rs.getString(9)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return sinhViens;
	}

	public ArrayList<SinhVien> layHetSinhVienDangThuePhong() {
		SimpleDateFormat sp = new SimpleDateFormat("MM/dd/yyyy");
		Date d = new Date();
		ArrayList<SinhVien> sinhViens = new ArrayList<>();
		String sql = String.format(
				"select * from SinhVien where IDSV in ( select IDSV from HopDong where NgayKetThuc>='%s');",
				sp.format(d));
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				sinhViens.add(new SinhVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getString(5), rs.getInt(6), rs.getDate(7), rs.getString(8), rs.getString(9)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return sinhViens;
	}

	public void dongKetNoi() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SinhVienDAO sv = new SinhVienDAO();
		// SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
		// try {
		// sv.suaSinhVien(new SinhVien(18, "hehe", "gggg", 4, "ergerg", 0,
		// sp.parse("22/01/1006"), "123asd", "123"));
		// sv.themSinhVien(new SinhVien(18, "hehe222", "ggghluhug", 4, "ergerlg", 0,
		// sp.parse("22/01/1006"),
		// "123asluid", "12ul7453"));
		//
		// } catch (ParseException e) {
		// e.printStackTrace();
		// }
		// sv.xoaSinhVien(21);
		ArrayList<SinhVien> v = sv.layHetSinhVienChuaThuePhong();
		for (SinhVien sinhVien : v) {
			System.out.println(sinhVien);
		}
	}

}
