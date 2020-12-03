package iparcel.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iparcel.DAO.custDAO;
import iparcel.DAO.parcelDb;
import iparcel.model.customer;
import iparcel.model.parcel;

@WebServlet("/parcelNotTaken")
public class parcelNotTaken extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String track = request.getParameter("track");
		String ptrack = request.getParameter("ptrack");
		try {
			if(track.equals("view")) {
				ArrayList<parcel> par = parcelDb.getAllNotTaken();
				request.setAttribute("notTaken", par);
				request.getRequestDispatcher("updateParcel.jsp").forward(request, response);
			}
			else if(track.equals("track")) {
				parcel p = parcelDb.getParcelUpdate(ptrack);
				ArrayList<customer> cust = custDAO.getCustomer();
				request.setAttribute("customer", cust);
				request.setAttribute("updatepar", p);
				request.getRequestDispatcher("UpdateParcelMenu.jsp").forward(request, response);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
