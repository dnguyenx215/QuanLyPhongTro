package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
 * Servlet implementation class ThemHoaDonServlet
 */
@WebServlet("/ThemHoaDonServlet")
public class ThemHoaDonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemHoaDonServlet() {
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
		if ("themHoaDon".equals(request.getParameter("themHoaDon"))) {
			HoaDonBO hoaDonBO = new HoaDonBO();
			HoaDon obj = null;
			try {
				SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat sp2 = new SimpleDateFormat("dd/MM/yyyy");
				int idPhong = Integer.parseInt(request.getParameter("idPhong"));
				Date ngayLap = sp.parse(request.getParameter("ngayLap"));
				Date thangLap = sp.parse(request.getParameter("thangLap"));
				int chiSoCu = Integer.parseInt(request.getParameter("chiSoCu"));
				int chiSoMoi = Integer.parseInt(request.getParameter("chiSoMoi"));
				obj = new HoaDon(0, idPhong, sp2.parse(sp2.format(ngayLap)), sp2.parse(sp2.format(thangLap)), chiSoCu,
						chiSoMoi, 0, 0, 0);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (hoaDonBO.themHoaDon(obj)) {
				request.setAttribute("thanhCong", "Thêm thành công");

				RequestDispatcher rd = request.getRequestDispatcher("DanhSachHoaDonServlet");
				rd.include(request, response);
				return;
			} else {

				request.setAttribute("thatBai", "Thêm thất bại");
			}
		}
		KhuNhaBO khuNhaBO = new KhuNhaBO();
		PhongBO phongBO = new PhongBO();
		ArrayList<Phong> themHDPhong = phongBO.layHetPhongDangThue();
		Hashtable<Integer, KhuNha> themHDKhuNha = khuNhaBO.layHetKhuNha2();
		request.setAttribute("themHDPhong", themHDPhong);
		request.setAttribute("themHDKhuNha", themHDKhuNha);
		RequestDispatcher rd = request.getRequestDispatcher("admin/qlHoaDon/themHoaDon.jsp");
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
