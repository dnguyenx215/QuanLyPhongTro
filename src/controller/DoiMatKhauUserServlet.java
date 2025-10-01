package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.User;
import model.bo.UserBO;

/**
 * Servlet implementation class DoiMatKhauUserServlet
 */
@WebServlet("/DoiMatKhauUserServlet")
public class DoiMatKhauUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoiMatKhauUserServlet() {
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
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		if ("doimkUser".equals(request.getParameter("doimkUser"))) {
			UserBO userBO = new UserBO();
			int id = Integer.parseInt(request.getParameter("ID"));
			User user = userBO.layUser(id);
			if (userBO.kiemTraUser(request.getParameter("userName"), request.getParameter("oldPass")) != null) {
				if (userBO.kiemTraUser(request.getParameter("userName"), request.getParameter("oldPass")) != null) {
					String newPass = request.getParameter("newPass");
					String reNewPass = request.getParameter("reNewPass");
					PrintWriter pw = response.getWriter();
					if (!newPass.equals(reNewPass)) {
						request.setAttribute("thatBai",
								"Thay đổi thất bại. Mật khẩu nhập lại phải trùng với mật khẩu mới");
						RequestDispatcher rd = request.getRequestDispatcher("user/doiMatKhauUser.jsp");
						rd.include(request, response);
					} else {
						user.setPassword(request.getParameter("newPass"));

						if (userBO.suaUser(user)) {
							request.setAttribute("thanhCong", "Thay đổi thành công");
						} else {
							request.setAttribute("thatBai", "Thay đổi thất bại.");
						}
						RequestDispatcher rd = request.getRequestDispatcher("ThongTinUserServlet");
						rd.include(request, response);
					}
				}

			} else {
				PrintWriter pw = response.getWriter();
				request.setAttribute("thatBai", "Mật khẩu không đúng");
				RequestDispatcher rd = request.getRequestDispatcher("user/doiMatKhauUser.jsp");
				rd.include(request, response);
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("user/doiMatKhauUser.jsp");
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
