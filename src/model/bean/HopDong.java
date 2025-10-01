package model.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HopDong {
	private int id;
	private int idSinhVien;
	private int idPhong;
	private Date ngayTao;
	private Date ngayBatDau;
	private Date ngayKetThuc;

	public HopDong() {
		super();
	}

	public HopDong(int id, int idSinhVien, int idPhong, Date ngayTao, Date ngayBatDau, Date ngayKetThuc) {
		super();
		this.id = id;
		this.idSinhVien = idSinhVien;
		this.idPhong = idPhong;
		this.ngayTao = ngayTao;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
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

	public int getIdPhong() {
		return idPhong;
	}

	public void setIdPhong(int idPhong) {
		this.idPhong = idPhong;
	}

	public Date getNgayTao() {
		return ngayTao;
	}

	public String getNgayTao2() {
		SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
		return sp.format(ngayTao);
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public String getNgayBatDau2() {
		SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
		return sp.format(ngayBatDau);
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	public String getNgayKetThuc2() {
		SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
		return sp.format(ngayKetThuc);
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	@Override
	public String toString() {
		return "HopDong [id=" + id + ", idSinhVien=" + idSinhVien + ", idPhong=" + idPhong + ", ngayTao=" + ngayTao
				+ ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + "]";
	}

}
