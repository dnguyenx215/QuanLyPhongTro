package controller;

import java.io.IOException;

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
 * Servlet implementation class DangKyUserServlet
 */
@WebServlet("/DangKyUserServlet")
public class DangKyUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangKyUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String passWord = request.getParameter("passWord");
		String rePass = request.getParameter("rePass");
		UserBO userBO = new UserBO();
		String mess = "";
		if (!KiemTra.kiemTraString(userName) || !KiemTra.kiemTraString(passWord)) {
			mess = "Tài khoản hoặc mật khẩu không thể chứa ký tự đặc biệt hoặc khoảng trắng";
		} else if (!KiemTra.kiemTraEmail(email)) {
			mess = "Email không đúng định dạng!";
		} else if (!rePass.equals(passWord)) {
			mess = "Mật khẩu nhập lại không khớp với mật khẩu tạo";
		} else if (userBO.themUser(new User(0, userName, passWord, email, 1, 1))) {
			User user = userBO.kiemTraUser(userName, passWord);
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("user", user);
			mess = "Đăng ký thành công";
			RequestDispatcher rd = request.getRequestDispatcher("ThongTinUserServlet");
			rd.forward(request, response);
			return;

		} else {
			mess = "Đăng ký không thành công tài khoản hoặc email đã được sử dụng";
		}
		request.setAttribute("mess", mess);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
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
