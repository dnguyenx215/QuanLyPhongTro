package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.bean.Phong;

public class KiemTra {
	public static boolean kiemTraSoDienThoai(String sdt) {
		String regex = "^(\\+84|0)\\d{9,10}$";
		return sdt.matches(regex);
	}

	public static boolean kiemTraEmail(String email) {
		String regex = "^(\\w+\\.*)+@(\\w+\\.+\\w+)(\\.\\w+){0,1}$";
		// String regex =
		// "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$";
		return email.matches(regex);
	}

	public static boolean kiemTraNgaySinh(Date ngaySinh) {
		Date date = new Date();
		SimpleDateFormat sp = new SimpleDateFormat("yyyy");
		int i = Integer.parseInt(sp.format(ngaySinh));
		int j = Integer.parseInt(sp.format(date));
		if (i + 18 < j) {
			return true;
		} else {
			return false;
		}
	}

	public static String layTrangThai(int i) {
		if (i == 1)
			return "Active";
		return "Block";
	}

	public static String layGioiTinh(int i) {
		if (i == 1)
			return "Nam";
		return "Nữ";
	}

	public static boolean kiemTraString(String name) {
		String regex = "^\\w+\\d*$";
		return name.matches(regex);
	}

	public static int demSoNguoi(ArrayList<Phong> ds) {
		int dem = 0;
		for (Phong phong : ds) {
			dem += (phong.getSoNguoiHienTai());
		}
		return dem;
	}

	public static String tinhPhanTram(int a, int b) {
		// return "123";
		System.out.println(a + "---------------------" + b);
		return String.valueOf(Math.round(((double) a / (double) b * 100) * 100.0) / 100.0);
	}

	public static void main(String[] args) {
		SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date d = sp.parse("22/12/2002");
			System.out.println(kiemTraNgaySinh(d));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(tinhPhanTram(5, 7));

	}

}
