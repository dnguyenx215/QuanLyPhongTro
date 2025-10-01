package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

import model.bean.TruongHoc;

public class TruongHocDAO {
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

	public boolean xoaTruongHoc(int id) {
		String sql = String.format("delete TruongHoc where IDTH=%s;", id);
		return xuLy(sql);
	}

	public boolean suaTruongHoc(TruongHoc obj) {
		int id = obj.getId();
		String tenTruong = obj.getTenTruong();
		String diaChi = obj.getDiaChi();
		String sql = String.format("UPDATE TruongHoc SET TenTruong = N'%s', DiaChi = N'%s' WHERE IDTH =%s;", tenTruong,
				diaChi, id);
		return xuLy(sql);
	}

	public boolean themTruongHoc(TruongHoc obj) {
		String tenTruong = obj.getTenTruong();
		String diaChi = obj.getDiaChi();
		String sql = String.format("insert into TruongHoc values(N'%s',N'%s');", tenTruong, diaChi);
		return xuLy(sql);
	}

	public TruongHoc layTruongHoc(int id) {
		String sql = String.format("select * from TruongHoc where IDTH=%s;", id);
		TruongHoc truongHoc = null;
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			if (rs.next()) {
				truongHoc = new TruongHoc(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return truongHoc;
	}

	public ArrayList<TruongHoc> layHetTruongHoc() {
		ArrayList<TruongHoc> truongHocs = new ArrayList<>();
		String sql = "select * from TruongHoc";
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				truongHocs.add(new TruongHoc(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return truongHocs;
	}

	public Hashtable<Integer, TruongHoc> layHetTruongHoc2() {
		Hashtable<Integer, TruongHoc> truongHocs = new Hashtable<>();
		String sql = "select * from TruongHoc";
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				truongHocs.put(rs.getInt(1), new TruongHoc(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return truongHocs;
	}

	public void dongKetNoi() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TruongHocDAO th = new TruongHocDAO();
		ArrayList<TruongHoc> thh = th.layHetTruongHoc();
		for (TruongHoc truongHoc : thh) {
			System.out.println(truongHoc);
		}
	}

}
