package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
 * Servlet implementation class SuaKhuNhaServlet
 */
@WebServlet("/SuaKhuNhaServlet")
public class SuaKhuNhaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuaKhuNhaServlet() {
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
		PrintWriter pw = response.getWriter();
		NhanVienBO nhanVienBO = new NhanVienBO();
		KhuNhaBO khuNhaBO = new KhuNhaBO();
		KhuNha suaKNkhuNha = null;
		if (request.getParameter("idKhuNha") != null)
			suaKNkhuNha = khuNhaBO.layKhuNha(Integer.parseInt(request.getParameter("idKhuNha")));
		if ("suaKhuNha".equals(request.getParameter("suaKhuNha"))) {

			int id = Integer.parseInt(request.getParameter("idKhuNha"));
			String khuNha = request.getParameter("khuNha");
			int idNhanVien = Integer.parseInt(request.getParameter("idNhanVien"));
			suaKNkhuNha = new KhuNha(id, khuNha, idNhanVien);
			if (khuNhaBO.suaKhuNha(suaKNkhuNha)) {
				request.setAttribute("thanhCong", "Sửa thành công");
				RequestDispatcher rd = request.getRequestDispatcher("DanhSachKhuNhaServlet");
				rd.include(request, response);
				return;
			} else {
				request.setAttribute("thatBai", "Có lỗi xảy ra");
				suaKNkhuNha = khuNhaBO.layKhuNha(id);
			}

		}
		ArrayList<NhanVien> suaKNNhanVien = nhanVienBO.layHetNhanVien();
		request.setAttribute("suaKNkhuNha", suaKNkhuNha);
		request.setAttribute("suaKNNhanVien", suaKNNhanVien);
		RequestDispatcher rd = request.getRequestDispatcher("admin/qlKhuNha/suaKhuNha.jsp");
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
