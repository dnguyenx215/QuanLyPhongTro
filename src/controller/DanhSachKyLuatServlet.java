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

import model.bean.KyLuatKhenThuong;
import model.bean.SinhVien;
import model.bean.User;
import model.bo.KyLuatKhenThuongBO;
import model.bo.SinhVienBO;

/**
 * Servlet implementation class DanhSachKyLuatServlet
 */
@WebServlet("/DanhSachKyLuatServlet")
public class DanhSachKyLuatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DanhSachKyLuatServlet() {
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		SinhVienBO sinhVienBO = new SinhVienBO();
		KyLuatKhenThuongBO kyLuatKhenThuongBO = new KyLuatKhenThuongBO();
		ArrayList<KyLuatKhenThuong> dsKLKyLuat = kyLuatKhenThuongBO.layHetKyLuatKhenThuong();
		Hashtable<Integer, SinhVien> dsKLSinhVien = sinhVienBO.layHetSinhVien2();
		request.setAttribute("dsKLKyLuat", dsKLKyLuat);
		request.setAttribute("dsKLSinhVien", dsKLSinhVien);
		RequestDispatcher rd = request.getRequestDispatcher("admin/qlKyLuat/danhSachKyLuat.jsp");
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
