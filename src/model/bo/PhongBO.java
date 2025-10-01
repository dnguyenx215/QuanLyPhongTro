package model.bo;

import java.util.ArrayList;
import java.util.Hashtable;

import model.bean.Phong;
import model.dao.PhongDAO;

public class PhongBO {
	PhongDAO phongDAO = new PhongDAO();

	public boolean xoaPhong(int id) {
		return phongDAO.xoaPhong(id);

	}

	public void capNhatNguoiTrongPhong() {
		phongDAO.capNhatNguoiTrongPhong();
	}

	public boolean suaPhong(Phong obj) {
		return phongDAO.suaPhong(obj);
	}

	public boolean themPhong(Phong obj) {
		return phongDAO.themPhong(obj);
	}

	public Phong layPhong(int id) {

		return phongDAO.layPhong(id);

	}

	public ArrayList<Phong> layHetPhongTheoGioiTinh(int gioiTinh) {

		return phongDAO.layHetPhongTheoGioiTinh(gioiTinh);
	}

	public ArrayList<Phong> layHetPhongTrong() {
		return phongDAO.layHetPhongTrong();
	}

	public ArrayList<Phong> layHetPhongDangThue() {
		return phongDAO.layHetPhongDangThue();
	}

	public ArrayList<Phong> layHetPhong() {

		return phongDAO.layHetPhong();
	}

	public Hashtable<Integer, Phong> layHetPhong2() {
		return phongDAO.layHetPhong2();
	}
}
