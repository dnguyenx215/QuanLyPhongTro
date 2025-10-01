package model.bo;

import java.util.ArrayList;
import java.util.Hashtable;

import model.bean.SinhVien;
import model.dao.SinhVienDAO;

public class SinhVienBO {
	SinhVienDAO sinhVienDAO = new SinhVienDAO();

	public boolean xoaSinhVien(int id) {
		return sinhVienDAO.xoaSinhVien(id);
	}

	public boolean suaSinhVien(SinhVien obj) {

		return sinhVienDAO.suaSinhVien(obj);
	}

	public boolean themSinhVien(SinhVien obj) {
		return sinhVienDAO.themSinhVien(obj);
	}

	public SinhVien laySinhVien(int id) {
		return sinhVienDAO.laySinhVien(id);

	}

	public ArrayList<SinhVien> layHetSinhVien() {
		return sinhVienDAO.layHetSinhVien();
	}

	public Hashtable<Integer, SinhVien> layHetSinhVien2() {
		return sinhVienDAO.layHetSinhVien2();
	}

	public ArrayList<SinhVien> layHetSinhVienChuaThuePhong() {

		return sinhVienDAO.layHetSinhVienChuaThuePhong();
	}

	public ArrayList<SinhVien> layHetSinhVienDangThuePhong() {
		return sinhVienDAO.layHetSinhVienDangThuePhong();
	}

}
