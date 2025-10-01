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
 * Servlet implementation class SuaHoaDonServlet
 */
@WebServlet("/SuaHoaDonServlet")
public class SuaHoaDonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuaHoaDonServlet() {
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

		HoaDonBO hoaDonBO = new HoaDonBO();
		KhuNhaBO khuNhaBO = new KhuNhaBO();
		PhongBO phongBO = new PhongBO();

		HoaDon suaHDHoaDon = null;
		if (request.getParameter("idHoaDon") != null)
			suaHDHoaDon = hoaDonBO.layHoaDon(Integer.parseInt(request.getParameter("idHoaDon")));

		if ("suaHoaDon".equals(request.getParameter("suaHoaDon"))) {

			try {

				SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat sp2 = new SimpleDateFormat("dd/MM/yyyy");
				int id = Integer.parseInt(request.getParameter("idHoaDon"));
				int idPhong = Integer.parseInt(request.getParameter("idPhong"));
				Date ngayLap = sp.parse(request.getParameter("ngayLap"));
				Date thangLap = sp.parse(request.getParameter("thangLap"));
				int chiSoCu = Integer.parseInt(request.getParameter("chiSoCu"));
				int chiSoMoi = Integer.parseInt(request.getParameter("chiSoMoi"));
				suaHDHoaDon = new HoaDon(id, idPhong, sp2.parse(sp2.format(ngayLap)), sp2.parse(sp2.format(thangLap)),
						chiSoCu, chiSoMoi, 0, 0, 0);

				if (hoaDonBO.suaHoaDon(suaHDHoaDon)) {
					request.setAttribute("thanhCong", "Sửa thành công");
					RequestDispatcher rd = request.getRequestDispatcher("DanhSachHoaDonServlet");
					rd.include(request, response);
					return;
				} else {
					request.setAttribute("thatBai", "Có lỗi xảy ra");
					suaHDHoaDon = hoaDonBO.layHoaDon(id);
				}

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		ArrayList<Phong> suaHDPhong = phongBO.layHetPhongDangThue();
		Hashtable<Integer, KhuNha> suaHDKhuNha = khuNhaBO.layHetKhuNha2();
		request.setAttribute("suaHDPhong", suaHDPhong);
		request.setAttribute("suaHDKhuNha", suaHDKhuNha);
		request.setAttribute("suaHDHoaDon", suaHDHoaDon);
		RequestDispatcher rd = request.getRequestDispatcher("admin/qlHoaDon/suaHoaDon.jsp");
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
