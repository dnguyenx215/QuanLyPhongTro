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
 * Servlet implementation class SuaSinhVienServlet
 */
@WebServlet("/SuaSinhVienServlet")
public class SuaSinhVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuaSinhVienServlet() {
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
		SinhVienBO svBO = new SinhVienBO();
		PrintWriter pw = response.getWriter();
		SinhVien obj = null;
		if (request.getParameter("idSinhVien") != null)
			obj = svBO.laySinhVien(Integer.parseInt(request.getParameter("idSinhVien")));
		if ("suaSV".equals(request.getParameter("suaSV"))) {
			try {
				int idSV = Integer.parseInt(request.getParameter("svID"));
				String maSV = request.getParameter("maSV");
				String hoTen = request.getParameter("tenSV");
				int maTruong = Integer.parseInt(request.getParameter("chonTruong"));
				String lop = request.getParameter("lop");
				int gioiTinh = Integer.parseInt(request.getParameter("gioiTinh"));
				SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd");
				// SimpleDateFormat sp2 = new SimpleDateFormat("dd/MM/yyyy");
				Date ngaySinh = sp.parse(request.getParameter("ngaySinh"));
				String soCMT = request.getParameter("soCMND");
				String sDT = request.getParameter("soDT");
				obj = new SinhVien(idSV, maSV, hoTen, maTruong, lop, gioiTinh, ngaySinh, soCMT, sDT);
				if (svBO.suaSinhVien(obj)) {
					request.setAttribute("thanhCong", "Sửa thành công");
					RequestDispatcher rd = request.getRequestDispatcher("DanhSachSinhVienServlet");
					rd.include(request, response);
					return;
				} else {
					request.setAttribute("thatBai", "Có lỗi xảy ra");
					obj = svBO.laySinhVien(Integer.parseInt(request.getParameter("svID")));
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		TruongHocBO thBO = new TruongHocBO();
		ArrayList<TruongHoc> dsTruongSV = thBO.layHetTruongHoc();
		request.setAttribute("sinhVien", obj);
		request.setAttribute("suaSVTruong", dsTruongSV);
		RequestDispatcher rd = request.getRequestDispatcher("admin/qlSinhVien/suaSinhVien.jsp");
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
