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
 * Servlet implementation class SuaKyLuatServlet
 */
@WebServlet("/SuaKyLuatServlet")
public class SuaKyLuatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuaKyLuatServlet() {
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
		PrintWriter pw = response.getWriter();
		KyLuatKhenThuongBO kyLuatKhenThuongBO = new KyLuatKhenThuongBO();
		SinhVienBO sinhVienBO = new SinhVienBO();
		ArrayList<SinhVien> suaKLKTSinhVien = sinhVienBO.layHetSinhVienDangThuePhong();
		request.setAttribute("suaKLKTSinhVien", suaKLKTSinhVien);
		KyLuatKhenThuong kyLuatKhenThuong = null;
		if (request.getParameter("idKyLuat") != null)
			kyLuatKhenThuong = kyLuatKhenThuongBO
					.layKyLuatKhenThuong(Integer.parseInt(request.getParameter("idKyLuat")));
		if ("suaKyLuat".equals(request.getParameter("suaKyLuat"))) {
			try {

				SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
				// SimpleDateFormat sp2 = new SimpleDateFormat("dd/MM/yyyy");

				int id = Integer.parseInt(request.getParameter("idKyLuat"));
				int idSinhVien = Integer.parseInt(request.getParameter("idSinhVien"));
				String nguyenNhan = request.getParameter("nguyenNhan");
				Date ngayThang = sp.parse(request.getParameter("ngayThang"));
				String hinhPhat = request.getParameter("hinhPhat");

				kyLuatKhenThuong = new KyLuatKhenThuong(id, idSinhVien, nguyenNhan, ngayThang, hinhPhat);

				if (kyLuatKhenThuongBO.suaKyLuatKhenThuong(kyLuatKhenThuong)) {

					request.setAttribute("thanhCong", "Sửa thành công");

					RequestDispatcher rd = request.getRequestDispatcher("DanhSachKyLuatServlet");
					rd.include(request, response);
					return;
				} else {

					request.setAttribute("thatBai", "Có lỗi xảy ra");
					kyLuatKhenThuong = kyLuatKhenThuongBO.layKyLuatKhenThuong(id);
				}

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("kyLuatKhenThuong", kyLuatKhenThuong);
		RequestDispatcher rd = request.getRequestDispatcher("admin/qlKyLuat/suaKyLuat.jsp");
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
