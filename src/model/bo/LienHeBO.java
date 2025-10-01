package model.bo;

import java.util.ArrayList;

import model.bean.LienHe;
import model.dao.LienHeDAO;

public class LienHeBO {
	LienHeDAO lienHeDAO = new LienHeDAO();

	public boolean xoaLienHe(int id) {

		return lienHeDAO.xoaLienHe(id);
	}

	public boolean themLienHe(LienHe obj) {

		return lienHeDAO.themLienHe(obj);
	}

	public LienHe layLienHe(int id) {

		return lienHeDAO.layLienHe(id);
	}

	public ArrayList<LienHe> layHetLienHe() {

		return lienHeDAO.layHetLienHe();
	}

}
