package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import model.bean.NhanVien;

public class NhanVienDAO {
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

	public boolean xoaNhanVien(int id) {
		String sql = String.format("delete from NhanVien where IDNV=%s;", id);

		return xuLy(sql);
	}

	public boolean suaNhanVien(NhanVien obj) {

		int id = obj.getId();
		String hoTen = obj.getHoTen();
		String diaChi = obj.getDiaChi();
		String sdt = obj.getSdt();
		int gioiTinh = obj.getGioiTinh();
		Date ngaySinh = obj.getNgaySinh();
		String chucVu = obj.getChucVu();
		SimpleDateFormat sp = new SimpleDateFormat("MM/dd/yyyy");
		String sql = String.format(
				"UPDATE NhanVien SET HoTen = N'%s' ,DiaChi = N'%s' ,SDT = '%s' ,GioiTinh = %s ,NgaySinh = '%s' ,ChucVu = N'%s' WHERE IDNV=%s;",
				hoTen, diaChi, sdt, gioiTinh, sp.format(ngaySinh), chucVu, id);

		return xuLy(sql);
	}

	public boolean themNhanVien(NhanVien obj) {
		String hoTen = obj.getHoTen();
		String diaChi = obj.getDiaChi();
		String sdt = obj.getSdt();
		int gioiTinh = obj.getGioiTinh();
		Date ngaySinh = obj.getNgaySinh();
		String chucVu = obj.getChucVu();
		SimpleDateFormat sp = new SimpleDateFormat("MM/dd/yyyy");
		String sql = String.format("INSERT INTO NhanVien VALUES (N'%s', N'%s', '%s', %s, '%s', N'%s')", hoTen, diaChi,
				sdt, gioiTinh, sp.format(ngaySinh), chucVu);
		return xuLy(sql);
	}

	public NhanVien layNhanVien(int id) {
		String sql = String.format("select * from NhanVien where IDNV=%s;", id);
		NhanVien nhanVien = null;
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			if (rs.next()) {
				nhanVien = new NhanVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getDate(6), rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return nhanVien;
	}

	public ArrayList<NhanVien> layHetNhanVien() {
		ArrayList<NhanVien> nhanViens = new ArrayList<>();
		String sql = "select * from NhanVien";
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				nhanViens.add(new NhanVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getInt(5), rs.getDate(6), rs.getString(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return nhanViens;
	}

	public Hashtable<Integer, NhanVien> layHetNhanVien2() {
		Hashtable<Integer, NhanVien> nhanViens = new Hashtable<>();
		String sql = "select * from NhanVien";
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				nhanViens.put(rs.getInt(1), (new NhanVien(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getString(7))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return nhanViens;
	}

	public void dongKetNoi() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		NhanVienDAO n = new NhanVienDAO();
		ArrayList<NhanVien> v = n.layHetNhanVien();
		for (NhanVien nhanVien : v) {
			System.out.println(nhanVien);
		}
	}

}
