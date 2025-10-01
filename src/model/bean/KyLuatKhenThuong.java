package model.bean;

import java.util.Date;

public class KyLuatKhenThuong {
	private int id;
	private int idSinhVien;
	private String nguyenNhan;
	private Date ngayThang;
	private String hinhPhat;

	public KyLuatKhenThuong() {
		super();
	}

	public KyLuatKhenThuong(int id, int idSinhVien, String nguyenNhan, Date ngayThang, String hinhPhat) {
		super();
		this.id = id;
		this.idSinhVien = idSinhVien;
		this.nguyenNhan = nguyenNhan;
		this.ngayThang = ngayThang;
		this.hinhPhat = hinhPhat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdSinhVien() {
		return idSinhVien;
	}

	public void setIdSinhVien(int idSinhVien) {
		this.idSinhVien = idSinhVien;
	}

	public String getNguyenNhan() {
		return nguyenNhan;
	}

	public void setNguyenNhan(String nguyenNhan) {
		this.nguyenNhan = nguyenNhan;
	}

	public Date getNgayThang() {
		return ngayThang;
	}

	public void setNgayThang(Date ngayThang) {
		this.ngayThang = ngayThang;
	}

	public String getHinhPhat() {
		return hinhPhat;
	}

	public void setHinhPhat(String hinhPhat) {
		this.hinhPhat = hinhPhat;
	}

	@Override
	public String toString() {
		return "KyLuatKhenThuong [id=" + id + ", idSinhVien=" + idSinhVien + ", nguyenNhan=" + nguyenNhan
				+ ", ngayThang=" + ngayThang + ", hinhPhat=" + hinhPhat + "]";
	}

}
