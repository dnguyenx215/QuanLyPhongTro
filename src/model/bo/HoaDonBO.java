package model.bo;

import java.util.ArrayList;

import model.bean.HoaDon;
import model.dao.HoaDonDAO;

public class HoaDonBO {
	HoaDonDAO hoaDonDAO = new HoaDonDAO();

	public boolean xoaHoaDon(int id) {
		return hoaDonDAO.xoaHoaDon(id);

	}

	public boolean suaHoaDon(HoaDon obj) {
		return hoaDonDAO.suaHoaDon(obj);
	}

	public boolean themHoaDon(HoaDon obj) {

		return hoaDonDAO.themHoaDon(obj);
	}

	public HoaDon layHoaDon(int id) {
		return hoaDonDAO.layHoaDon(id);

	}

	public ArrayList<HoaDon> layHetHoaDon() {

		return hoaDonDAO.layHetHoaDon();
	}
}
