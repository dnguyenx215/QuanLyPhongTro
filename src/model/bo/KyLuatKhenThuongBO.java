package model.bo;

import java.util.ArrayList;

import model.bean.KyLuatKhenThuong;
import model.dao.KyLuatKhenThuongDAO;

public class KyLuatKhenThuongBO {
	KyLuatKhenThuongDAO kyLuatKhenThuongDAO = new KyLuatKhenThuongDAO();

	public boolean xoaKyLuatKhenThuong(int id) {
		return kyLuatKhenThuongDAO.xoaKyLuatKhenThuong(id);

	}

	public boolean suaKyLuatKhenThuong(KyLuatKhenThuong obj) {
		return kyLuatKhenThuongDAO.suaKyLuatKhenThuong(obj);
	}

	public boolean themKyLuatKhenThuong(KyLuatKhenThuong obj) {

		return kyLuatKhenThuongDAO.themKyLuatKhenThuong(obj);
	}

	public KyLuatKhenThuong layKyLuatKhenThuong(int id) {

		return kyLuatKhenThuongDAO.layKyLuatKhenThuong(id);

	}

	public ArrayList<KyLuatKhenThuong> layHetKyLuatKhenThuong() {

		return kyLuatKhenThuongDAO.layHetKyLuatKhenThuong();
	}
}
