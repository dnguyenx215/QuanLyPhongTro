package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.HoaDon;
import model.bean.KhuNha;
import model.bean.Phong;
import model.bean.User;
import model.bo.HoaDonBO;
import model.bo.KhuNhaBO;
import model.bo.PhongBO;

/**
 * Servlet implementation class DanhSachHoaDonServlet
 */
@WebServlet("/DanhSachHoaDonServlet")
public class DanhSachHoaDonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DanhSachHoaDonServlet() {
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
		PhongBO phongBO = new PhongBO();
		KhuNhaBO khuNhaBO = new KhuNhaBO();
		HoaDonBO hoaDonBO = new HoaDonBO();
		ArrayList<HoaDon> dsHDHoaDon = hoaDonBO.layHetHoaDon();
		Hashtable<Integer, KhuNha> dsHDKhuNha = khuNhaBO.layHetKhuNha2();
		Hashtable<Integer, Phong> dsHDPhong = phongBO.layHetPhong2();
		request.setAttribute("dsHDHoaDon", dsHDHoaDon);
		request.setAttribute("dsHDKhuNha", dsHDKhuNha);
		request.setAttribute("dsHDPhong", dsHDPhong);
		RequestDispatcher rd = request.getRequestDispatcher("admin/qlHoaDon/danhSachHoaDon.jsp");
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
