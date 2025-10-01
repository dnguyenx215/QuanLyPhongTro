package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.KyLuatKhenThuong;
import model.bean.SinhVien;
import model.bean.User;
import model.bo.KyLuatKhenThuongBO;
import model.bo.SinhVienBO;

/**
 * Servlet implementation class ThemKyLuatServlet
 */
@WebServlet("/ThemKyLuatServlet")
public class ThemKyLuatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemKyLuatServlet() {
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
		KyLuatKhenThuongBO kyLuatKhenThuongBO = new KyLuatKhenThuongBO();
		SinhVienBO sinhVienBO = new SinhVienBO();
		ArrayList<SinhVien> themKLKTSinhVien = sinhVienBO.layHetSinhVienDangThuePhong();
		request.setAttribute("themKLKTSinhVien", themKLKTSinhVien);
		KyLuatKhenThuong kyLuatKhenThuong = null;

		if ("themKyLuat".equals(request.getParameter("themKyLuat"))) {
			try {

				SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
				int idSinhVien = Integer.parseInt(request.getParameter("idSinhVien"));
				String nguyenNhan = request.getParameter("nguyenNhan");
				Date ngayThang = sp.parse(request.getParameter("ngayThang"));
				String hinhPhat = request.getParameter("hinhPhat");

				kyLuatKhenThuong = new KyLuatKhenThuong(0, idSinhVien, nguyenNhan, ngayThang, hinhPhat);

				if (kyLuatKhenThuongBO.themKyLuatKhenThuong(kyLuatKhenThuong)) {
					request.setAttribute("thanhCong", "Thêm thành công");

					RequestDispatcher rd = request.getRequestDispatcher("DanhSachKyLuatServlet");
					rd.include(request, response);
					return;
				} else {

					request.setAttribute("thatBai", "Thêm thất bại");
				}

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("admin/qlKyLuat/themKyLuat.jsp");
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
