package model.bo;

import java.util.ArrayList;
import java.util.Hashtable;

import model.bean.HopDong;
import model.dao.HopDongDAO;

public class HopDongBO {

	HopDongDAO hopDongDAO = new HopDongDAO();

	public boolean xoaHopDong(int id) {

		return hopDongDAO.xoaHopDong(id);
	}

	public boolean suaHopDong(HopDong obj) {
		return hopDongDAO.suaHopDong(obj);
	}

	public boolean themHopDong(HopDong obj) {
		return hopDongDAO.themHopDong(obj);
	}

	public HopDong layHopDong(int id) {
		return hopDongDAO.layHopDong(id);
	}

	public boolean kiemTraHopDongCuaSinhVien(int idSV) {
		return hopDongDAO.kiemTraHopDongCuaSinhVien(idSV);
	}

	public ArrayList<HopDong> layHetHopDong() {
		return hopDongDAO.layHetHopDong();
	}

	public Hashtable<String, Integer> laySoLuong() {
		return hopDongDAO.laySoLuong();
	}

}
