package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.bean.LienHe;

public class LienHeDAO {
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

	public boolean xoaLienHe(int id) {
		String sql = String.format("delete from LienHe where idlh =%s;", id);

		return xuLy(sql);
	}

	public boolean themLienHe(LienHe obj) {
		String hoTen = obj.getHoTen();
		String email = obj.getEmail();
		String chuDe = obj.getChuDe();
		String noiDung = obj.getNoiDung();
		Date ngayGui = obj.getNgayGui();
		SimpleDateFormat sp = new SimpleDateFormat("MM/dd/yyyy");
		String sql = String.format("INSERT INTO LienHe VALUES (N'%s', '%s',N'%s', N'%s', '%s')", hoTen, email, chuDe,
				noiDung, sp.format(ngayGui));

		return xuLy(sql);
	}

	public LienHe layLienHe(int id) {
		LienHe lienHe = null;
		String sql = String.format("select * from LienHe where IDLH=%s;", id);
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			if (rs.next()) {
				lienHe = new LienHe(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDate(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return lienHe;
	}

	public ArrayList<LienHe> layHetLienHe() {
		ArrayList<LienHe> lienHes = new ArrayList<>();
		String sql = "SELECT * FROM dbo.LienHe ORDER BY NgayGui DESC";
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				lienHes.add(new LienHe(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getDate(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return lienHes;
	}

	public void dongKetNoi() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		LienHeDAO l = new LienHeDAO();
		SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
		try {
			LienHe lhh = new LienHe(0, "admin ga", "@gmail.com", "chu de ", "noi dung", sp.parse("22/12/2017"));
			l.themLienHe(lhh);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		;
		ArrayList<LienHe> lh = l.layHetLienHe();
		for (LienHe lienHe : lh) {
			System.out.println(lienHe);
		}
	}
}
