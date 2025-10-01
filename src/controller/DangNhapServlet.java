package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import model.bo.UserBO;

/**
 * Servlet implementation class DangNhapServlet
 */
@WebServlet("/DangNhapServlet")
public class DangNhapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangNhapServlet() {
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
		String userName = (String) request.getParameter("userName");
		String passWord = (String) request.getParameter("passWord");
		UserBO userBO = new UserBO();
		User user = userBO.kiemTraUser(userName, passWord);
		if (user != null) {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("user", user);
			if (user.getUserType() == 0) {
				// admin
				RequestDispatcher rd = request.getRequestDispatcher("DashboardServlet");
				rd.forward(request, response);

			} else {
				// response.sendRedirect("index.jsp");// chuaw co
				RequestDispatcher rd = request.getRequestDispatcher("ThongTinUserServlet");
				rd.forward(request, response);
			}

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("mess", "Sai tài khoản hoặc mật khẩu!");

			rd.include(request, response);
		}
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
