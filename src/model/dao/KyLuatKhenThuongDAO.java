package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.bean.KyLuatKhenThuong;

public class KyLuatKhenThuongDAO {
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

	public boolean xoaKyLuatKhenThuong(int id) {
		String sql = String.format("delete from KyLuatKhenThuong where IDKL =%s", id);

		return xuLy(sql);

	}

	public boolean suaKyLuatKhenThuong(KyLuatKhenThuong obj) {
		int id = obj.getId();
		int idSinhVien = obj.getIdSinhVien();
		String nguyenNhan = obj.getNguyenNhan();
		Date ngayThang = obj.getNgayThang();
		String hinhPhat = obj.getHinhPhat();
		SimpleDateFormat sp = new SimpleDateFormat("MM/dd/yyyy");
		String sql = String.format(
				"update KyLuatKhenThuong set IDSV=%s,NguyenNhan=N'%s',NgayThang='%s',HinhPhat=N'%s' where IDKL=%s;",
				idSinhVien, nguyenNhan, sp.format(ngayThang), hinhPhat, id);

		return xuLy(sql);
	}

	public boolean themKyLuatKhenThuong(KyLuatKhenThuong obj) {
		SimpleDateFormat sp = new SimpleDateFormat("MM/dd/yyyy");

		int idSinhVien = obj.getIdSinhVien();
		String nguyenNhan = obj.getNguyenNhan();
		Date ngayThang = obj.getNgayThang();
		String hinhPhat = obj.getHinhPhat();

		String sql = String.format("INSERT INTO KyLuatKhenThuong VALUES (%s,N'%s','%s',N'%s');", idSinhVien, nguyenNhan,
				sp.format(ngayThang), hinhPhat);

		return xuLy(sql);
	}

	public KyLuatKhenThuong layKyLuatKhenThuong(int id) {
		KyLuatKhenThuong kyLuatKhenThuong = null;
		String sql = String.format("select * from KyLuatKhenThuong where IDKL=%s;", id);
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			if (rs.next()) {
				kyLuatKhenThuong = new KyLuatKhenThuong(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4),
						rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return kyLuatKhenThuong;

	}

	public ArrayList<KyLuatKhenThuong> layHetKyLuatKhenThuong() {
		ArrayList<KyLuatKhenThuong> kyLuatKhenThuongs = new ArrayList<>();
		String sql = "select * from KyLuatKhenThuong";
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				kyLuatKhenThuongs.add(new KyLuatKhenThuong(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4),
						rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return kyLuatKhenThuongs;
	}

	public void dongKetNoi() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		KyLuatKhenThuongDAO k = new KyLuatKhenThuongDAO();
		SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
		try {
			KyLuatKhenThuong kll = new KyLuatKhenThuong(5, 6, "hehe", sp.parse("08/22/2018"), "hihihi");
			// k.themKyLuatKhenThuong(kll);
			k.suaKyLuatKhenThuong(kll);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		ArrayList<KyLuatKhenThuong> khenThuongs = k.layHetKyLuatKhenThuong();
		for (KyLuatKhenThuong kyLuatKhenThuong : khenThuongs) {
			System.out.println(kyLuatKhenThuong);
		}
	}
}
