package controller;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.KiemTra;
import model.bean.User;
import model.bo.HopDongBO;
import model.bo.NhanVienBO;
import model.bo.PhongBO;

/**
 * Servlet implementation class IndexUserServlet
 */
@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DashboardServlet() {
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
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		request.setAttribute("user", "aa");
		PhongBO phongBO = new PhongBO();
		NhanVienBO nhanVienBO = new NhanVienBO();
		HopDongBO hopDongBO = new HopDongBO();
		Hashtable<String, Integer> dsHopDongTheoThang = hopDongBO.laySoLuong();
		int soPhong = phongBO.layHetPhong().size();
		int soPhongDangThue = phongBO.layHetPhongDangThue().size();
		int soNam = KiemTra.demSoNguoi(phongBO.layHetPhongTheoGioiTinh(1));
		int soNu = KiemTra.demSoNguoi(phongBO.layHetPhongTheoGioiTinh(0));
		int soNhanVien = nhanVienBO.layHetNhanVien().size();
		request.setAttribute("dsHopDongTheoThang", dsHopDongTheoThang);
		request.setAttribute("soPhong", soPhong);
		request.setAttribute("soPhongDangThue", soPhongDangThue);
		request.setAttribute("soNam", soNam);
		request.setAttribute("soNu", soNu);
		request.setAttribute("soNhanVien", soNhanVien);
		RequestDispatcher rd = request.getRequestDispatcher("admin/dashboard.jsp");
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
