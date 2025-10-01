package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.NhanVien;
import model.bean.User;
import model.bo.NhanVienBO;

/**
 * Servlet implementation class ThemNhanVienServlet
 */
@WebServlet("/ThemNhanVienServlet")
public class ThemNhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemNhanVienServlet() {
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
		if ("themNV".equals(request.getParameter("themNV"))) {
			SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
			String hoTenNV = request.getParameter("hoTenNV");
			String diaChiNV = request.getParameter("diaChiNV");
			String soDT = request.getParameter("soDT");
			int gioiTinh = Integer.parseInt(request.getParameter("gioiTinh"));
			Date ngaySinh = null;
			try {
				ngaySinh = sp.parse(request.getParameter("ngaySinh"));

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String chucVu = request.getParameter("chucVu");
			NhanVienBO nhanVienBO = new NhanVienBO();
			if (nhanVienBO.themNhanVien(new NhanVien(0, hoTenNV, diaChiNV, soDT, gioiTinh, ngaySinh, chucVu))) {
				request.setAttribute("thanhCong", "Thêm nhân viên thành công");

			} else {
				request.setAttribute("thatBai", "Thêm nhân viên thất bại");
			}

		}
		RequestDispatcher rd = request.getRequestDispatcher("admin/qlNhanVien/themNhanVien.jsp");
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
