package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import model.bean.Phong;

public class PhongDAO {
	private Connection conn = null;

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

	public boolean xoaPhong(int id) {
		String sql = String.format("delete from Phong where IDP=%s;", id);
		return xuLy(sql);

	}

	public void capNhatNguoiTrongPhong() {
		SimpleDateFormat sp = new SimpleDateFormat("MM/dd/yyyy");
		ArrayList<Phong> phong = layHetPhong();
		ResultSet rs = null;
		String sql;
		Date d = new Date();

		try {
			for (Phong phong2 : phong) {
				moKetNoi();
				sql = String.format("select count(IDP) from HopDong where NgayKetThuc>'%s'group by IDP having IDP=%s;",
						sp.format(d), phong2.getId());
				rs = conn.createStatement().executeQuery(sql);
				int j = 0;
				if (rs.next()) {
					j = rs.getInt(1);
				}
				phong2.setSoNguoiHienTai(j);
				suaPhong(phong2);
			}
			System.out.println("Đã cập nhật số người trong mỗi phòng xong!");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
	}

	public boolean suaPhong(Phong obj) {
		int id = obj.getId();
		int idKhuNha = obj.getIdKhuNha();
		String tenPhong = obj.getTenPhong();
//		int soNguoiHienTai = obj.getSoNguoiHienTai();
		int soNguoiToiDa = obj.getSoNguoiToiDa();
		Phong obj2 = layPhong(id);
		if (!obj.getTenPhong().equals(obj2.getTenPhong()) || obj.getIdKhuNha() != obj2.getIdKhuNha()) {
			String check = String.format("select * from Phong where tenphong='%s' and idkn=%s", tenPhong, idKhuNha);
			try {
				moKetNoi();
				ResultSet rs = conn.createStatement().executeQuery(check);
				if (rs.next())
					return false;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				dongKetNoi();
			}
		}
		if (obj2.getSoNguoiHienTai() > obj.getSoNguoiToiDa())
			return false;
		String sql = String.format("UPDATE Phong SET  TenPhong = '%s',IDKN = %s ,SoNguoiToiDa = %s WHERE IDP=%s;",
				tenPhong, idKhuNha, soNguoiToiDa, id);
		return xuLy(sql);
	}

	public boolean themPhong(Phong obj) {
		int idKhuNha = obj.getIdKhuNha();
		String tenPhong = obj.getTenPhong();
		int soNguoiToiDa = obj.getSoNguoiToiDa();
		String check = String.format("select * from Phong where tenphong='%s' and idkn=%s", tenPhong, idKhuNha);
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(check);
			if (rs.next())
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		String sql = String.format("INSERT INTO Phong VALUES (%s,'%s', 0,%s);", idKhuNha, tenPhong, soNguoiToiDa);
		return xuLy(sql);
	}

	public Phong layPhong(int id) {
		Phong phong = null;
		String sql = String.format("select * from Phong  where IDP=%s;", id);
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			if (rs.next()) {
				phong = new Phong(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return phong;

	}

	public ArrayList<Phong> layHetPhongTheoGioiTinh(int gioiTinh) {
		ArrayList<Phong> phongs = new ArrayList<>();
		String sql = String.format(
				"    SELECT  * FROM    dbo.Phong  WHERE   IDP IN ( SELECT IDP  FROM   dbo.HopDong  WHERE  IDSV IN ( SELECT    IDSV  FROM      dbo.SinhVien WHERE     GioiTinh = %s )AND NgayKetThuc>GETDATE() );",
				gioiTinh);
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				phongs.add(new Phong(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return phongs;
	}

	public ArrayList<Phong> layHetPhongTrong() {
		ArrayList<Phong> phongs = new ArrayList<>();
		String sql = "SELECT * FROM dbo.Phong WHERE SoNguoiHienTai=0;";
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				phongs.add(new Phong(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return phongs;
	}

	public ArrayList<Phong> layHetPhong() {
		ArrayList<Phong> phongs = new ArrayList<>();
		String sql = "select * from Phong";
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				phongs.add(new Phong(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return phongs;
	}

	public Hashtable<Integer, Phong> layHetPhong2() {
		Hashtable<Integer, Phong> phongs = new Hashtable<>();
		String sql = "select * from Phong";
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				phongs.put(rs.getInt(1),
						new Phong(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return phongs;
	}

	public void dongKetNoi() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Phong> layHetPhongDangThue() {
		ArrayList<Phong> phongs = new ArrayList<>();
		String sql = "SELECT * FROM dbo.Phong WHERE SoNguoiHienTai>0;";
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				phongs.add(new Phong(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return phongs;
	}

	public static void main(String[] args) {
		PhongDAO p = new PhongDAO();
		p.capNhatNguoiTrongPhong();
		ArrayList<Phong> g = p.layHetPhong();
//		for (Phong phong : g) {
//			System.out.println(phong);
//		}
		System.out.println("---------------------------");
		g = p.layHetPhongTheoGioiTinh(0);
		for (Phong phong : g) {
			System.out.println(phong);
		}
	}

}
