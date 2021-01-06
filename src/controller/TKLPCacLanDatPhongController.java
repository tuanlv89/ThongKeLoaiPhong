package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TKPhongDAO;
import model.LoaiPhong;
import model.TKPhong;

@WebServlet(urlPatterns = {"/tkCacLanDatPhong"}, name = "tkCacLanDatPhong")
public class TKLPCacLanDatPhongController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		
		String idLP = request.getParameter("idLoaiPhong");
		TKPhongDAO tkPhongDAO = new TKPhongDAO();
		LoaiPhong loaiPhong = tkPhongDAO.getLoaiPhongById(Integer.parseInt(idLP));
		
		HttpSession session = request.getSession();
		session.setAttribute("tenLP", loaiPhong.getTen());
		ArrayList<TKPhong> ls = (ArrayList<TKPhong>) session.getAttribute("listTKDatPhong");
		ArrayList<TKPhong> lsTKBookedOfRoomType = new ArrayList<TKPhong>();
		for (TKPhong tkPhong : ls) {
			if(tkPhong.getLoaiPhong().getId()==Integer.parseInt(idLP)) {
				lsTKBookedOfRoomType.add(tkPhong);
			}
		}
		session.setAttribute("listTKBookedRoomType", lsTKBookedOfRoomType);

		RequestDispatcher rd = request.getRequestDispatcher("view/gdTKCacLanDatPhong.jsp");
		rd.forward(request, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		String url = "/view/gdTKCacLanDatPhong.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}
	
	
	
}
