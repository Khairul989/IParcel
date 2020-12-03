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

@WebServlet("/searchParcel")
public class searchParcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("answer");
		
		try {
			ArrayList<parcel> par = parcelDb.getParcel(id);
			request.setAttribute("par", par);
			request.getRequestDispatcher("listParcel.jsp").forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
	}

}
