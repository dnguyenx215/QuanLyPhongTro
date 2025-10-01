package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.HopDong;
import model.bean.KhuNha;
import model.bean.Phong;
import model.bean.SinhVien;
import model.bean.User;
import model.bo.HopDongBO;
import model.bo.KhuNhaBO;
import model.bo.PhongBO;
import model.bo.SinhVienBO;

/**
 * Servlet implementation class ThemHopDongServlet
 */
@WebServlet("/ThemHopDongServlet")
public class ThemHopDongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemHopDongServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		HttpSession hs = request.getSession();
		User acc = (User) hs.getAttribute("user");
		if (acc != null) {
			if (acc.getUserType() == 1) {
				response.sendRedirect("404.jsp");
				return;
			}
		} else {
			response.sendRedirect("IndexServlet");
			return;
		}
		PrintWriter pw = response.getWriter();
		HopDongBO hopDongBO = new HopDongBO();
		HopDong themHDHopDong = null;
		if ("themHopDong".equals(request.getParameter("themHopDong"))) {

			try {
				SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
				// SimpleDateFormat sp2 = new SimpleDateFormat("dd/MM/yyyy");
				int idSinhVien = Integer.parseInt(request.getParameter("idSinhVien"));
				int idPhong = Integer.parseInt(request.getParameter("idPhong"));
				Date ngayTao = sp.parse(request.getParameter("ngayTao"));
				Date ngayBatDau = sp.parse(request.getParameter("ngayBatDau"));
				Date ngayKetThuc = sp.parse(request.getParameter("ngayKetThuc"));
				themHDHopDong = new HopDong(0, idSinhVien, idPhong, ngayTao, ngayBatDau, ngayKetThuc);
				System.out.println(themHDHopDong.toString());
				if (hopDongBO.themHopDong(themHDHopDong)) {
					request.setAttribute("thanhCong", "Thêm thành công");

					RequestDispatcher rd = request.getRequestDispatcher("DanhSachHopDongServlet");
					rd.include(request, response);
					return;
				} else {

					request.setAttribute("thatBai", "Thêm thất bại");
				}

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		PhongBO phongBO = new PhongBO();
		KhuNhaBO khuNhaBO = new KhuNhaBO();
		SinhVienBO sinhVienBO = new SinhVienBO();
		ArrayList<SinhVien> themHDSinhVien = sinhVienBO.layHetSinhVienChuaThuePhong();
		ArrayList<Phong> themHDPhongTrong = phongBO.layHetPhongTrong();
		ArrayList<Phong> themHDPhongNam = phongBO.layHetPhongTheoGioiTinh(1);
		ArrayList<Phong> themHDPhongNu = phongBO.layHetPhongTheoGioiTinh(0);
		Hashtable<Integer, KhuNha> themHDKhuNha = khuNhaBO.layHetKhuNha2();
		request.setAttribute("themHDSinhVien", themHDSinhVien);
		request.setAttribute("themHDPhongTrong", themHDPhongTrong);
		request.setAttribute("themHDPhongNam", themHDPhongNam);
		request.setAttribute("themHDPhongNu", themHDPhongNu);
		request.setAttribute("themHDKhuNha", themHDKhuNha);
		RequestDispatcher rd = request.getRequestDispatcher("admin/qlHopDong/themHopDong.jsp");
		rd.include(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
