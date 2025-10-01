package model.bean;

import java.util.Date;

public class NhanVien {
	private int id;
	private String hoTen;
	private String diaChi;
	private String sdt;
	private int gioiTinh;
	private Date ngaySinh;
	private String chucVu;

	public NhanVien() {
		super();
	}

	public NhanVien(int id, String hoTen, String diaChi, String sdt, int gioiTinh, Date ngaySinh, String chucVu) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.chucVu = chucVu;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
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

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	@Override
	public String toString() {
		return "NhanVien [id=" + id + ", hoTen=" + hoTen + ", diaChi=" + diaChi + ", sdt=" + sdt + ", gioiTinh="
				+ gioiTinh + ", ngaySinh=" + ngaySinh + ", chucVu=" + chucVu + "]";
	}

}
