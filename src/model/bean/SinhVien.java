package model.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SinhVien {
	private int id;
	private String maSinhVien;
	private String hoTen;
	private int idTruongHoc;
	private String lop;
	private int gioiTinh;
	private Date ngaySinh;
	private String soCMND;
	private String sdt;

	public SinhVien() {
		super();
	}

	public SinhVien(int id, String maSinhVien, String hoTen, int idTruongHoc, String lop, int gioiTinh, Date ngaySinh,
			String soCMND, String sdt) {
		super();
		this.id = id;
		this.maSinhVien = maSinhVien;
		this.hoTen = hoTen;
		this.idTruongHoc = idTruongHoc;
		this.lop = lop;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.soCMND = soCMND;
		this.sdt = sdt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getIdTruongHoc() {
		return idTruongHoc;
	}

	public void setIdTruongHoc(int idTruongHoc) {
		this.idTruongHoc = idTruongHoc;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public int getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public String getNgaySinh2() {
		SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
		return sp.format(ngaySinh);
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoCMND() {
		return soCMND;
	}

	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	@Override
	public String toString() {
		return "SinhVien [id=" + id + ", maSinhVien=" + maSinhVien + ", hoTen=" + hoTen + ", idTruongHoc=" + idTruongHoc
				+ ", lop=" + lop + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", soCMND=" + soCMND + ", sdt="
				+ sdt + "]";
	}

}
