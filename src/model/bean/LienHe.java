package model.bean;

import java.util.Date;

public class LienHe {
	private int id;
	private String hoTen;
	private String email;
	private String chuDe;
	private String noiDung;
	private Date ngayGui;

	public LienHe() {
		super();
	}

	public LienHe(int id, String hoTen, String email, String chuDe, String noiDung, Date ngayGui) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.email = email;
		this.chuDe = chuDe;
		this.noiDung = noiDung;
		this.ngayGui = ngayGui;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getChuDe() {
		return chuDe;
	}

	public void setChuDe(String chuDe) {
		this.chuDe = chuDe;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public Date getNgayGui() {
		return ngayGui;
	}

	public void setNgayGui(Date ngayGui) {
		this.ngayGui = ngayGui;
	}

	@Override
	public String toString() {
		return "LienHe [id=" + id + ", hoTen=" + hoTen + ", email=" + email + ", chuDe=" + chuDe + ", noiDung="
				+ noiDung + ", ngayGui=" + ngayGui + "]";
	}

}
