package model.bo;

import java.util.ArrayList;

import model.bean.User;
import model.dao.UserDAO;

public class UserBO {
	UserDAO userDAO = new UserDAO();

	public boolean xoaUser(int id) {
		return userDAO.xoaUser(id);
	}

	public boolean suaUser(User obj) {
		return userDAO.suaUser(obj);
	}

	public boolean themUser(User obj) {
		return userDAO.themUser(obj);
	}

	public ArrayList<User> layHetUser() {
		return userDAO.layHetUser();
	}

	public User layUser(int id) {
		return userDAO.layUser(id);
	}

	public User kiemTraUser(String u, String p) {
		return userDAO.kiemTraUser(u, p);
	}

}
