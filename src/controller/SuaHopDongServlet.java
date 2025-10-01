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

import model.bean.HopDong;
import model.bean.KhuNha;
import model.bean.Phong;
import model.bean.SinhVien;
import model.bean.User;
import model.bo.HopDongBO;
import model.bo.KhuNhaBO;
import model.bo.PhongBO;
import model.bo.SinhVienBO;

/**
 * Servlet implementation class SuaHopDongServlet
 */
@WebServlet("/SuaHopDongServlet")
public class SuaHopDongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuaHopDongServlet() {
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

		HopDongBO hopDongBO = new HopDongBO();
		PrintWriter pw = response.getWriter();
		HopDong suaHDHopDong = null;
		if (request.getParameter("idHopDong") != null)
			suaHDHopDong = hopDongBO.layHopDong(Integer.parseInt(request.getParameter("idHopDong")));
		if ("suaHopDong".equals(request.getParameter("suaHopDong"))) {
			try {

				SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
				// SimpleDateFormat sp2 = new SimpleDateFormat("dd/MM/yyyy");
				int idSinhVien = Integer.parseInt(request.getParameter("idSinhVien"));
				int id = Integer.parseInt(request.getParameter("idHopDong"));
				int idPhong = Integer.parseInt(request.getParameter("idPhong"));
				Date ngayTao = sp.parse(request.getParameter("ngayTao"));
				Date ngayBatDau = sp.parse(request.getParameter("ngayBatDau"));
				Date ngayKetThuc = sp.parse(request.getParameter("ngayKetThuc"));
				suaHDHopDong = new HopDong(id, idSinhVien, idPhong, ngayTao, ngayBatDau, ngayKetThuc);
				if (hopDongBO.suaHopDong(suaHDHopDong)) {

					request.setAttribute("thanhCong", "Sửa thành công");
					RequestDispatcher rd = request.getRequestDispatcher("DanhSachHopDongServlet");
					rd.include(request, response);
					return;
				} else {
					request.setAttribute("thatBai", "Có lỗi xảy ra");
					suaHDHopDong = hopDongBO.layHopDong(id);
				}

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		KhuNhaBO khuNhaBO = new KhuNhaBO();
		PhongBO phongBO = new PhongBO();
		SinhVienBO sinhVienBO = new SinhVienBO();
		ArrayList<Phong> suaHDPhongNam = phongBO.layHetPhongTheoGioiTinh(1);
		ArrayList<Phong> suaHDPhongNu = phongBO.layHetPhongTheoGioiTinh(0);
		ArrayList<Phong> suaHDPhongTrong = phongBO.layHetPhongTrong();
		Hashtable<Integer, KhuNha> suaHDKhuNha = khuNhaBO.layHetKhuNha2();
		ArrayList<SinhVien> suaHDSinhVien = sinhVienBO.layHetSinhVien();
		request.setAttribute("suaHDPhongNam", suaHDPhongNam);
		request.setAttribute("suaHDPhongNu", suaHDPhongNu);
		request.setAttribute("suaHDPhongTrong", suaHDPhongTrong);
		request.setAttribute("suaHDKhuNha", suaHDKhuNha);
		request.setAttribute("suaHDSinhVien", suaHDSinhVien);
		request.setAttribute("suaHDHopDong", suaHDHopDong);
		RequestDispatcher rd = request.getRequestDispatcher("admin/qlHopDong/suaHopDong.jsp");
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
