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

import model.bean.SinhVien;
import model.bean.TruongHoc;
import model.bean.User;
import model.bo.SinhVienBO;
import model.bo.TruongHocBO;

/**
 * Servlet implementation class DanhSachSinhVienServlet
 */
@WebServlet("/DanhSachSinhVienServlet")
public class DanhSachSinhVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DanhSachSinhVienServlet() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
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
		TruongHocBO truongHocBO = new TruongHocBO();
		ArrayList<SinhVien> dsSVSinhVien = sinhVienBO.layHetSinhVien();
		Hashtable<Integer, TruongHoc> dsSVTruongHoc = truongHocBO.layHetTruongHoc2();
		request.setAttribute("dsSVSinhVien", dsSVSinhVien);
		request.setAttribute("dsSVTruongHoc", dsSVTruongHoc);
		RequestDispatcher rd = request.getRequestDispatcher("admin/qlSinhVien/danhSachSinhVien.jsp");
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
