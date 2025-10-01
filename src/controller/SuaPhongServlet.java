package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.KhuNha;
import model.bean.Phong;
import model.bean.User;
import model.bo.PhongBO;
import model.dao.KhuNhaDAO;

/**
 * Servlet implementation class SuaPhongServlet
 */
@WebServlet("/SuaPhongServlet")
public class SuaPhongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SuaPhongServlet() {
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
		PhongBO phongBO = new PhongBO();
		Phong phong = null;
		if (request.getParameter("idPhong") != null)
			phong = phongBO.layPhong(Integer.parseInt(request.getParameter("idPhong")));
		if ("suaPhong".equals(request.getParameter("suaPhong"))) {
			int idp = Integer.parseInt(request.getParameter("phongID"));
			String soPhong = request.getParameter("soPhong");
			int idKhuNha = Integer.parseInt(request.getParameter("chonKhuNha"));
			int soNguoiTD = Integer.parseInt(request.getParameter("soNguoiToiDa"));
			Phong obj = new Phong(idp, idKhuNha, soPhong, 0, soNguoiTD);
			PrintWriter pw = response.getWriter();
			if (phongBO.suaPhong(obj)) {
				request.setAttribute("thanhCong", "Sửa thành công");
				RequestDispatcher rd = request.getRequestDispatcher("DanhSachPhongServlet");
				rd.include(request, response);
				return;
			} else {
				request.setAttribute("thatBai", "Có lỗi xảy ra");
				phong = phongBO.layPhong(idp);
			}
		}
		KhuNhaDAO knd = new KhuNhaDAO();
		ArrayList<KhuNha> dsKhuNhaP = knd.layHetKhuNha();

		request.setAttribute("suaPhong", phong);
		request.setAttribute("dsKhuNhaP", dsKhuNhaP);
		RequestDispatcher rd = request.getRequestDispatcher("admin/qlPhong/suaPhong.jsp");
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
