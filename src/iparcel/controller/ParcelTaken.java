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

/**
 * Servlet implementation class ParcelTaken
 */
@WebServlet("/ParcelTaken")
public class ParcelTaken extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			ArrayList<parcel> par = parcelDb.getTakenParcel(id);
			request.setAttribute("par", par);
			request.getRequestDispatcher("ParcelList.jsp").forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
