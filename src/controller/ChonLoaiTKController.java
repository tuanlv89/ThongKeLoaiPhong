package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.NhanVienDAO;
import dao.ThanhVienDAO;
import model.NhanVien;
import model.ThanhVien;

@WebServlet(urlPatterns = {"/gdChonLoaiTK"})
public class ChonLoaiTKController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("view/gdChonLoaiTK.jsp");
		rd.forward(req, resp);
		System.out.println("AAAAAAAAAAAAALLLLLLLLOOOOOOOOOOOo");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String doiTuongTK = request.getParameter("doiTuongTK");
		String kieuTK = request.getParameter("kieuTK");
	    System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAa"+ doiTuongTK + kieuTK);
	    if(!(doiTuongTK.equals("LOAI_PHONG") && kieuTK.equals("LUOT_THUE"))) {
	    	response.sendRedirect("gdChonLoaiTK?err=fail");
	    }
			   
	}
}
