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
 * Servlet implementation class SuaTruongServlet
 */
@WebServlet("/SuaTruongServlet")
public class SuaTruongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuaTruongServlet() {
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
		int idTruong = Integer.parseInt(request.getParameter("idTruong"));
		TruongHocBO truongHocBO = new TruongHocBO();

		if ("suaTruong".equals(request.getParameter("suaTruong"))) {
			String tenTruong = request.getParameter("schoolName");
			String diaChi = request.getParameter("schoolAddress");
			if (truongHocBO.suaTruongHoc(new TruongHoc(idTruong, tenTruong, diaChi))) {
				request.setAttribute("thanhCong", "Sửa trường thành công");
			} else {
				request.setAttribute("thatBai", "Sửa trường thất bại");
			}
		}
		TruongHoc truongHoc = truongHocBO.layTruongHoc(idTruong);
		request.setAttribute("truongHoc", truongHoc);
		RequestDispatcher rd = request.getRequestDispatcher("admin/qlTruong/suaTruong.jsp");
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
