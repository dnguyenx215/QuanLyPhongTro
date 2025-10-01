package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.LienHe;
import model.bo.LienHeBO;

/**
 * Servlet implementation class LienHeServlet
 */
@WebServlet("/LienHeServlet")
public class LienHeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LienHeServlet() {
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

		String hoTen = request.getParameter("hoTen");
		String email = request.getParameter("email");
		String chuDe = request.getParameter("chuDe");
		String noiDung = request.getParameter("noiDung");
		Date ngayGui = new Date();
		LienHeBO lhBO = new LienHeBO();
		LienHe lh = new LienHe(0, hoTen, email, chuDe, noiDung, ngayGui);
		if (lhBO.themLienHe(lh)) {
			request.setAttribute("thanhCong", "Thành công");
			request.setAttribute("mess", "Gửi liên hệ thành công");
		} else {
			request.setAttribute("thatBai", "Thất bại");
			request.setAttribute("mess", "Gửi liên hệ thất bại");
		}
		RequestDispatcher rd = request.getRequestDispatcher("IndexServlet");
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
