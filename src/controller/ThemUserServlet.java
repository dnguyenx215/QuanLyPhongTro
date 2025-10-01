package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.KiemTra;
import model.bean.User;
import model.bo.UserBO;

/**
 * Servlet implementation class ThemUserServlet
 */
@WebServlet("/ThemUserServlet")
public class ThemUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemUserServlet() {
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
		if ("themUser".equals(request.getParameter("themUser"))) {
			UserBO userBO = new UserBO();
			String usName = request.getParameter("userName");
			String pass = request.getParameter("passWord");
			String email = request.getParameter("email");

			PrintWriter pw = response.getWriter();
			if (KiemTra.kiemTraEmail(email) && userBO.themUser(new User(0, usName, pass, email, 1, 1))) {
				request.setAttribute("thanhCong", "Thêm thành công");
				RequestDispatcher rd = request.getRequestDispatcher("DanhSachUserServlet");
				rd.include(request, response);
			} else {

				request.setAttribute("thatBai", "Thêm thất bại");
				RequestDispatcher rd = request.getRequestDispatcher("admin/qlUser/themUser.jsp");
				rd.include(request, response);
			}
		} else {

			RequestDispatcher rd = request.getRequestDispatcher("admin/qlUser/themUser.jsp");
			rd.include(request, response);
		}
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
