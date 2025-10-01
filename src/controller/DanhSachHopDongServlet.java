package controller;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class DanhSachHopDongServlet
 */
@WebServlet("/DanhSachHopDongServlet")
public class DanhSachHopDongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DanhSachHopDongServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		HopDongBO hopDongBO = new HopDongBO();
		SinhVienBO sinhVienBO = new SinhVienBO();
		PhongBO phongBO = new PhongBO();
		KhuNhaBO khuNhaBO = new KhuNhaBO();
		ArrayList<HopDong> dsHDHopDong = hopDongBO.layHetHopDong();
		Hashtable<Integer, SinhVien> dsHDSinhVien = sinhVienBO.layHetSinhVien2();
		Hashtable<Integer, Phong> dsHDPhong = phongBO.layHetPhong2();
		Hashtable<Integer, KhuNha> dsHDKhuNha = khuNhaBO.layHetKhuNha2();
		request.setAttribute("dsHDHopDong", dsHDHopDong);
		request.setAttribute("dsHDSinhVien", dsHDSinhVien);
		request.setAttribute("dsHDPhong", dsHDPhong);
		request.setAttribute("dsHDKhuNha", dsHDKhuNha);
		RequestDispatcher rd = request.getRequestDispatcher("admin/qlHopDong/danhSachHopDong.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
