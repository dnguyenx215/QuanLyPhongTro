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

import model.bean.KhuNha;
import model.bean.NhanVien;
import model.bean.User;
import model.bo.KhuNhaBO;
import model.bo.NhanVienBO;

/**
 * Servlet implementation class DanhSachKhuNhaServlet
 */
@WebServlet("/DanhSachKhuNhaServlet")
public class DanhSachKhuNhaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DanhSachKhuNhaServlet() {
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
		NhanVienBO nhanVienBO = new NhanVienBO();
		KhuNhaBO khuNhaBO = new KhuNhaBO();
		ArrayList<KhuNha> dsKNKhuNha = khuNhaBO.layHetKhuNha();
		Hashtable<Integer, NhanVien> dsKNNhanVien = nhanVienBO.layHetNhanVien2();
		request.setAttribute("dsKNKhuNha", dsKNKhuNha);
		request.setAttribute("dsKNNhanVien", dsKNNhanVien);
		RequestDispatcher rd = request.getRequestDispatcher("admin/qlKhuNha/danhSachKhuNha.jsp");
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
