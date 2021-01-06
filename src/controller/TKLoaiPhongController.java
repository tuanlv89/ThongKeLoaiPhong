package controller;

import java.io.IOException;
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

import dao.NhanVienDAO;
import dao.TKPhongDAO;
import dao.ThanhVienDAO;
import model.LoaiPhong;
import model.NhanVien;
import model.Phong;
import model.PhongThue;
import model.TKLoaiPhong;
import model.TKPhong;
import model.ThanhVien;

@WebServlet(urlPatterns = {"/gdTKLoaiPhong"})
public class TKLoaiPhongController extends HttpServlet{
	
	public TKLoaiPhongController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		RequestDispatcher rd = request.getRequestDispatcher("/view/gdTKLoaiPhong.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String timeStart = request.getParameter("timeStart");
		String timeEnd = request.getParameter("timeEnd");
		
		TKPhongDAO tkPhongDAO = new TKPhongDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date thoiGianDen = sdf.parse(timeStart);
			Date thoiGianVe = sdf.parse(timeEnd);
			ArrayList<TKPhong> listTKPhong = tkPhongDAO.getTKPhongByStage(thoiGianDen, thoiGianVe);
			ArrayList<LoaiPhong> listLP = tkPhongDAO.getAllLoaiPhong();
			ArrayList<TKLoaiPhong> listTkLoaiPhong = tkPhongDAO.getTKLoaiPhong(listTKPhong, listLP);
			
			System.out.println("AAAAAAAALLLLLLOOOOOOOO" + listTkLoaiPhong.size());
			for(int i = 0; i< listTkLoaiPhong.size(); i++) {
				System.out.println(listTkLoaiPhong.get(i));
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("timeStart", timeStart);
			session.setAttribute("timeEnd", timeEnd);
			session.setAttribute("listRoomType", listTkLoaiPhong);
			session.setAttribute("listTKDatPhong", listTKPhong);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url = "/view/gdTKLoaiPhong.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
    	dispatcher.forward(request, response);
		
		
//		System.out.println(timeStart + "OKEEEEEEEEE" + timeEnd + listPhong.toString());
//		//----------------
//		HttpSession session = request.getSession();
//		session.setAttribute("timeStart", timeStart);
//		session.setAttribute("timeEnd", timeEnd);
//		session.setAttribute("listRoom", listPhong);
//		
//		String url = "/view/gdTKLoaiPhong.jsp";
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
//    	dispatcher.forward(request, response);
			   
	}
}
