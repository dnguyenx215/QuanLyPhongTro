package model.bo;

import java.util.ArrayList;
import java.util.Hashtable;

import model.bean.TruongHoc;
import model.dao.TruongHocDAO;

public class TruongHocBO {
	TruongHocDAO truongHocDAO = new TruongHocDAO();

	public boolean xoaTruongHoc(int id) {
		return truongHocDAO.xoaTruongHoc(id);
	}

	public boolean suaTruongHoc(TruongHoc obj) {
		return truongHocDAO.suaTruongHoc(obj);
	}

	public boolean themTruongHoc(TruongHoc obj) {
		return truongHocDAO.themTruongHoc(obj);
	}

	public TruongHoc layTruongHoc(int id) {
		return truongHocDAO.layTruongHoc(id);
	}

	public Hashtable<Integer, TruongHoc> layHetTruongHoc2() {
		return truongHocDAO.layHetTruongHoc2();
	}

	public ArrayList<TruongHoc> layHetTruongHoc() {
		return truongHocDAO.layHetTruongHoc();
	}
}
