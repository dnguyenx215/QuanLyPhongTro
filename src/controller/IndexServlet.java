package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexAdminServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
//		KhuNhaBO khuNhaBO = new KhuNhaBO();
//		PhongBO phongBO = new PhongBO();
//		SinhVienBO sinhVienBO = new SinhVienBO();
//		request.setAttribute("dsSinhVien", sinhVienBO.layHetSinhVienChuaThuePhong());
		// request.setAttribute("dsKhuNu", khuNhaBO.layKhuConPhong(0));
		// request.setAttribute("dsKhuNam", khuNhaBO.layKhuConPhong(1));
//		request.setAttribute("dsKhu", khuNhaBO.layHetKhuNha2());
//		request.setAttribute("dsPhongNu", phongBO.layHetPhongTheoGioiTinh(0));
//		request.setAttribute("dsPhongNam", phongBO.layHetPhongTheoGioiTinh(1));
//		request.setAttribute("dsPhongTrong", phongBO.layHetPhongTrong());
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
