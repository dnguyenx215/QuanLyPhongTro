package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import model.bean.KhuNha;

public class KhuNhaDAO {
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

	public boolean xoaKhuNha(int id) {
		String sql = String.format("delete from KhuNha where IDKN=%s", id);

		return xuLy(sql);

	}

	public boolean suaKhuNha(KhuNha obj) {
		int id = obj.getId();
		String khuNha = obj.getKhuNha();
		int idNhanVien = obj.getIdNhanVien();
		String sql = String.format("UPDATE KhuNha SET  KhuNha.KhuNha ='%s', IDNV =%s WHERE IDKN=%s", khuNha, idNhanVien,
				id);
		return xuLy(sql);
	}

	public boolean themKhuNha(KhuNha obj) {

		String khuNha = obj.getKhuNha();
		int idNhanVien = obj.getIdNhanVien();
		String sql = String.format("INSERT INTO KhuNha VALUES (N'%s',%s)", khuNha, idNhanVien);

		return xuLy(sql);
	}

	public ArrayList<KhuNha> layHetKhuConPhong(int gioiTinh) {
		ArrayList<KhuNha> khuNhas = new ArrayList<>();
		Date d = new Date();
		SimpleDateFormat sp = new SimpleDateFormat("MM/dd/yyyy");
		String sql = String.format(
				"select * from KhuNha where IDKN in (select distinct IDKN from Phong where SoNguoiHienTai=0 or IDP in (	select distinct IDP from HopDong  where NgayKetThuc>'%s'and IDSV in ( select IDSV from SinhVien where GioiTinh =%s 	) ))",
				sp.format(d), gioiTinh);
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				khuNhas.add(new KhuNha(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return khuNhas;

	}

	public KhuNha layKhuNha(int id) {
		KhuNha khuNha = null;
		String sql = String.format("select * from KhuNha where IDKN=%s;", id);
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			if (rs.next()) {
				khuNha = new KhuNha(rs.getInt(1), rs.getString(2), rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return khuNha;
	}

	public ArrayList<KhuNha> layHetKhuNha() {
		ArrayList<KhuNha> khuNhas = new ArrayList<>();
		String sql = "select * from KhuNha";
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				khuNhas.add(new KhuNha(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return khuNhas;
	}

	public Hashtable<Integer, KhuNha> layHetKhuNha2() {
		Hashtable<Integer, KhuNha> khuNhas = new Hashtable<>();
		String sql = "select * from KhuNha";
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				khuNhas.put(rs.getInt(1), new KhuNha(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return khuNhas;
	}

	public void dongKetNoi() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		KhuNhaDAO s = new KhuNhaDAO();
		KhuNha knn = new KhuNha(13, "Khu AAmmmm552", 4);
		s.xoaKhuNha(17);
		// s.themKhuNha(knn);
		s.suaKhuNha(knn);
		ArrayList<KhuNha> h = s.layHetKhuConPhong(0);
		h = s.layHetKhuNha();
		for (KhuNha hopDong : h) {
			System.out.println(hopDong);
		}
	}
}
