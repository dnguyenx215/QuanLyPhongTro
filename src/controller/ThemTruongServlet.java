package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.TruongHoc;
import model.bean.User;
import model.bo.TruongHocBO;

/**
 * Servlet implementation class ThemTruongServlet
 */
@WebServlet("/ThemTruongServlet")
public class ThemTruongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemTruongServlet() {
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
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
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
		if ("themTruong".equals(request.getParameter("themTruong"))) {
			String tenTruong = request.getParameter("schoolName");
			String diaChi = request.getParameter("schoolAddress");
			TruongHocBO truongHocBO = new TruongHocBO();
			if (truongHocBO.themTruongHoc(new TruongHoc(0, tenTruong, diaChi))) {
				request.setAttribute("thanhCong", "Thêm trường thành công");
			} else {
				request.setAttribute("thatBai", "Thêm trường thất bại");
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher("admin/qlTruong/themTruong.jsp");
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
