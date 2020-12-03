package iparcel.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iparcel.DAO.parcelDb;
import iparcel.model.parcel;

@WebServlet("/UpdateParcel")
public class UpdateParcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String ptrack = request.getParameter("track");
		String customer = request.getParameter("customer");
		String type = request.getParameter("type");
		String da = request.getParameter("da");
		
		parcel p = new parcel();
		p.setPtrack(ptrack);
		p.setPid(customer);
		p.setPtype(type);
		p.setDate_arrive(da);
		
		System.out.println(p.toString());
		try {
			boolean status = parcelDb.Update(p);
			request.setAttribute("p",p);
			request.getRequestDispatcher("updateParcelStatus.jsp").forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
