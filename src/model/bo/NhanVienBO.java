package model.bo;

import java.util.ArrayList;
import java.util.Hashtable;

import model.bean.NhanVien;
import model.dao.NhanVienDAO;

public class NhanVienBO {
	NhanVienDAO nhanVienDAO = new NhanVienDAO();

	public boolean xoaNhanVien(int id) {
		return nhanVienDAO.xoaNhanVien(id);
	}

	public boolean suaNhanVien(NhanVien obj) {
		return nhanVienDAO.suaNhanVien(obj);
	}

	public boolean themNhanVien(NhanVien obj) {
		return nhanVienDAO.themNhanVien(obj);
	}

	public NhanVien layNhanVien(int id) {

		return nhanVienDAO.layNhanVien(id);
	}

	public ArrayList<NhanVien> layHetNhanVien() {

		return nhanVienDAO.layHetNhanVien();
	}

	public Hashtable<Integer, NhanVien> layHetNhanVien2() {
		return nhanVienDAO.layHetNhanVien2();
	}
}
