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
 * Servlet implementation class SuaUserServlet
 */
@WebServlet("/SuaUserServlet")
public class SuaUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuaUserServlet() {
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
		UserBO userBO = new UserBO();
		PrintWriter pw = response.getWriter();
		User userSua = null;
		if (request.getParameter("idUser") != null)
			userSua = userBO.layUser(Integer.parseInt(request.getParameter("idUser")));
		if ("luuUser".equals(request.getParameter("luuUser"))) {
			int idu = Integer.parseInt(request.getParameter("userID"));
			String usName = request.getParameter("userName");
			String pass = request.getParameter("passWord");
			String email = request.getParameter("email");
			// System.out.println(new User(idu, usName, pass, email, 0, 0).toString());
			if (KiemTra.kiemTraEmail(email) && KiemTra.kiemTraString(usName) && KiemTra.kiemTraString(pass)
					&& userBO.suaUser(new User(idu, usName, pass, email, 1, 1))) {
				request.setAttribute("thanhCong", "Sửa thành công");
				RequestDispatcher rd2 = request.getRequestDispatcher("DanhSachUserServlet");
				rd2.include(request, response);
				return;
			} else {
				request.setAttribute("thatBai", "Có lỗi xảy ra");
				userSua = userBO.layUser(idu);
			}

		}
		request.setAttribute("suaUser", userSua);
		RequestDispatcher rd = request.getRequestDispatcher("admin/qlUser/suaUser.jsp");
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
