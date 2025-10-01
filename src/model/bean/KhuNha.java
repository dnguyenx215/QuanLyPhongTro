package model.bean;

public class KhuNha {
	private int id;
	private String khuNha;
	private int idNhanVien;

	public KhuNha() {
		super();
	}

	public KhuNha(int id, String khuNha, int idNhanVien) {
		super();
		this.id = id;
		this.khuNha = khuNha;
		this.idNhanVien = idNhanVien;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKhuNha() {
		return khuNha;
	}

	public void setKhuNha(String khuNha) {
		this.khuNha = khuNha;
	}

	public int getIdNhanVien() {
		return idNhanVien;
	}

	public void setIdNhanVien(int idNhanVien) {
		this.idNhanVien = idNhanVien;
	}

	@Override
	public String toString() {
		return "KhuNha [id=" + id + ", khuNha=" + khuNha + ", idNhanVien=" + idNhanVien + "]";
	}

}
