package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.KiemTra;
import model.bean.User;

public class UserDAO {
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

	public boolean xoaUser(int id) {
		String sql = String.format("delete tblUser where IDU=%s;", id);
		return xuLy(sql);
	}

	public boolean suaUser(User obj) {
		int id = obj.getId();
		String userName = obj.getUserName();
		String password = obj.getPassword();
		String email = obj.getEmail();
		int userType = obj.getUserType();
		int userStatus = obj.getUserStatus();
		String sql = String.format(
				"UPDATE tblUser SET UserName = '%s' ,Password = '%s' ,Email = '%s' ,UserType = %s ,UserStatus = %s WHERE IDU=%s;",
				userName, password, email, userType, userStatus, id);
		return xuLy(sql);
	}

	public boolean themUser(User obj) {
		String userName = obj.getUserName();
		String password = obj.getPassword();
		String email = obj.getEmail();
		int userStatus = obj.getUserStatus();
		if (!KiemTra.kiemTraEmail(email))
			return false;
		String sql = String.format("insert into tblUser values('%s','%s','%s',1,%s);", userName, password, email,
				userStatus);
		return xuLy(sql);
	}

	public ArrayList<User> layHetUser() {
		ArrayList<User> users = new ArrayList<>();
		String sql = "select * from tblUser where UserType=1";
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return users;
	}

	public User layUser(int id) {
		User user = null;
		String sql = String.format("SELECT * FROM dbo.tblUser WHERE IDU=%s;", id);
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			if (rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return user;
	}

	public User kiemTraUser(String u, String p) {
		User user = null;
		String sql = String.format("SELECT * FROM dbo.tblUser WHERE UserName='%s' AND Password='%s';", u, p);
		try {
			moKetNoi();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			if (rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dongKetNoi();
		}
		return user;
	}

	public void dongKetNoi() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		UserDAO ud = new UserDAO();
		ArrayList<User> kk = ud.layHetUser();
		for (User user : kk) {
			System.out.println(user);
		}
		System.out.println(ud.kiemTraUser("admin", "admin"));
	}

}
