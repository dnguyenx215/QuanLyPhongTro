package model.bo;

import java.util.ArrayList;
import java.util.Hashtable;

import model.bean.KhuNha;
import model.dao.KhuNhaDAO;

public class KhuNhaBO {
	KhuNhaDAO khuNhaDAO = new KhuNhaDAO();

	public boolean xoaKhuNha(int id) {
		return khuNhaDAO.xoaKhuNha(id);

	}

	public boolean suaKhuNha(KhuNha obj) {
		return khuNhaDAO.suaKhuNha(obj);
	}

	public boolean themKhuNha(KhuNha obj) {
		return khuNhaDAO.themKhuNha(obj);
	}

	public ArrayList<KhuNha> layHetKhuConPhong(int gioiTinh) {
		return khuNhaDAO.layHetKhuConPhong(gioiTinh);

	}

	public KhuNha layKhuNha(int id) {
		return khuNhaDAO.layKhuNha(id);
	}

	public ArrayList<KhuNha> layHetKhuNha() {
		return khuNhaDAO.layHetKhuNha();
	}

	public Hashtable<Integer, KhuNha> layHetKhuNha2() {
		return khuNhaDAO.layHetKhuNha2();
	}

}
