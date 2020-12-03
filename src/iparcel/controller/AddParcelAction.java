package iparcel.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import iparcel.DAO.parcelDb;
import iparcel.model.parcel;
import iparcel.model.staff;

/**
 * Servlet implementation class AddParcelAction
 */
@WebServlet("/AddParcelAction")
public class AddParcelAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String track = request.getParameter("track");
		String customer = request.getParameter("customer");
		String type = request.getParameter("type");
		String date = request.getParameter("da");
		String dc = request.getParameter("dc");
		String courier = request.getParameter("courier");
		String status = request.getParameter("status");
		String staff = request.getParameter("staff");
		
		staff s = new staff();
		s.setId(staff);
		
		
		parcel p = new parcel();
		p.setPid(customer);
		p.setPtrack(track);
		p.setPtype(type);
		p.setDate_arrive(date);
		p.setDate_collected(dc);
		p.setCourier(courier);
		p.setStatus(status);
		p.setSt(s);
		
		try {
			boolean status1 = parcelDb.AddParcel(p);
			request.setAttribute("status", status1);
			request.getRequestDispatcher("addParcelStatus.jsp").forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
