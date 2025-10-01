package model.bean;

public class Phong {
	private int id;
	private int idKhuNha;
	private String tenPhong;
	private int soNguoiHienTai;
	private int soNguoiToiDa;

	public Phong() {
		super();
	}

	public Phong(int id, int idKhuNha, String tenPhong, int soNguoiHienTai, int soNguoiToiDa) {
		super();
		this.id = id;
		this.idKhuNha = idKhuNha;
		this.tenPhong = tenPhong;
		this.soNguoiHienTai = soNguoiHienTai;
		this.soNguoiToiDa = soNguoiToiDa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdKhuNha() {
		return idKhuNha;
	}

	public void setIdKhuNha(int idKhuNha) {
		this.idKhuNha = idKhuNha;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public int getSoNguoiHienTai() {
		return soNguoiHienTai;
	}

	public void setSoNguoiHienTai(int soNguoiHienTai) {
		this.soNguoiHienTai = soNguoiHienTai;
	}

	public int getSoNguoiToiDa() {
		return soNguoiToiDa;
	}

	public void setSoNguoiToiDa(int soNguoiToiDa) {
		this.soNguoiToiDa = soNguoiToiDa;
	}

	@Override
	public String toString() {
		return "Phong [id=" + id + ", idKhuNha=" + idKhuNha + ", tenPhong=" + tenPhong + ", soNguoiHienTai="
				+ soNguoiHienTai + ", soNguoiToiDa=" + soNguoiToiDa + "]";
	}

}
