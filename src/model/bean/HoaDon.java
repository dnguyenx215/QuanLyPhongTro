package model.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HoaDon {
	private int id;
	private int idPhong;
	private Date ngayLap;
	private Date thangLap;
	private int chiSoCu;
	private int chiSoMoi;
	private int tienDien;
	private int tienNuoc;
	private int tongTien;

	public HoaDon() {
		super();
	}

	// public HoaDon(int id, int idPhong, Date ngayLap, Date thangLap, float
	// chiSoCu, float chiSoMoi, int tienDien,
	// int tienNuoc, int tongTien) {
	// super();
	// this.id = id;
	// this.idPhong = idPhong;
	// this.ngayLap = ngayLap;
	// this.thangLap = thangLap;
	// this.chiSoCu = chiSoCu;
	// this.chiSoMoi = chiSoMoi;
	// this.tienDien = tienDien;
	// this.tienNuoc = tienNuoc;
	// this.tongTien = tongTien;
	// }
	//

	// public HoaDon(int id, int idPhong, Date ngayLap, Date thangLap, int chiSoCu,
	// int chiSoMoi) {
	// super();
	// this.id = id;
	// this.idPhong = idPhong;
	// this.ngayLap = ngayLap;
	// this.thangLap = thangLap;
	// this.chiSoCu = chiSoCu;
	// this.chiSoMoi = chiSoMoi;
	// }

	public HoaDon(int id, int idPhong, Date ngayLap, Date thangLap, int chiSoCu, int chiSoMoi, int tienDien,
			int tienNuoc, int tongTien) {
		super();
		this.id = id;
		this.idPhong = idPhong;
		this.ngayLap = ngayLap;
		this.thangLap = thangLap;
		this.chiSoCu = chiSoCu;
		this.chiSoMoi = chiSoMoi;
		this.tienDien = tienDien;
		this.tienNuoc = tienNuoc;
		this.tongTien = tongTien;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdPhong() {
		return idPhong;
	}

	public void setIdPhong(int idPhong) {
		this.idPhong = idPhong;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public String getNgayLap2() {
		SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
		return sp.format(ngayLap);
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public Date getThangLap() {
		return thangLap;
	}

	public String getThangLap2() {

		SimpleDateFormat sp2 = new SimpleDateFormat("MM/yyyy");
		return sp2.format(thangLap);
	}

	public void setThangLap(Date thangLap) {
		this.thangLap = thangLap;
	}

	public int getChiSoCu() {
		return chiSoCu;
	}

	public void setChiSoCu(int chiSoCu) {
		this.chiSoCu = chiSoCu;
	}

	public int getChiSoMoi() {
		return chiSoMoi;
	}

	public void setChiSoMoi(int chiSoMoi) {
		this.chiSoMoi = chiSoMoi;
	}

	public int getTienDien() {
		return tienDien;
	}

	public void setTienDien(int tienDien) {
		this.tienDien = tienDien;
	}

	public int getTienNuoc() {
		return tienNuoc;
	}

	public void setTienNuoc(int tienNuoc) {
		this.tienNuoc = tienNuoc;
	}

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	@Override
	public String toString() {
		return "HoaDon [id=" + id + ", idPhong=" + idPhong + ", ngayLap=" + ngayLap + ", thangLap=" + thangLap
				+ ", chiSoCu=" + chiSoCu + ", chiSoMoi=" + chiSoMoi + ", tienDien=" + tienDien + ", tienNuoc="
				+ tienNuoc + ", tongTien=" + tongTien + "]";
	}

}
