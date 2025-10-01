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

import model.bean.SinhVien;
import model.bean.TruongHoc;
import model.bean.User;
import model.bo.SinhVienBO;
import model.bo.TruongHocBO;

/**
 * Servlet implementation class ThemSinhVienServlet
 */
@WebServlet("/ThemSinhVienServlet")
public class ThemSinhVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemSinhVienServlet() {
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
		if ("themSV".equals(request.getParameter("themSV"))) {
			SinhVienBO svBO = new SinhVienBO();
			SinhVien obj = null;
			try {
				String maSV = request.getParameter("maSV");
				String hoTen = request.getParameter("hoTenSV");
				int maTruong = Integer.parseInt(request.getParameter("chonTruong"));
				String lop = request.getParameter("lop");
				int gioiTinh = Integer.parseInt(request.getParameter("gioiTinh"));
				SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
				// SimpleDateFormat sp2 = new SimpleDateFormat("dd/MM/yyyy");
				Date ngaySinh = sp.parse(request.getParameter("ngaySinh"));
				String soCMT = request.getParameter("soCMND");
				String sDT = request.getParameter("soDT");
				obj = new SinhVien(0, maSV, hoTen, maTruong, lop, gioiTinh, ngaySinh, soCMT, sDT);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (svBO.themSinhVien(obj)) {
				request.setAttribute("thanhCong", "Thêm thành công");

				RequestDispatcher rd = request.getRequestDispatcher("DanhSachSinhVienServlet");
				rd.include(request, response);
				return;
			} else {

				request.setAttribute("thatBai", "Thêm thất bại");
			}
		}
		TruongHocBO thBO = new TruongHocBO();
		ArrayList<TruongHoc> dsTruongSV = thBO.layHetTruongHoc();
		request.setAttribute("themSVTruong", dsTruongSV);
		RequestDispatcher rd = request.getRequestDispatcher("admin/qlSinhVien/themSinhVien.jsp");
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
