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
import iparcel.DAO.staffDAO;
import iparcel.DAO.studentDAO;
import iparcel.model.customer;
import iparcel.model.parcel;
import iparcel.model.staff;
import iparcel.model.student;

@WebServlet("/ViewAll")
public class ViewAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArrayList<parcel> par = parcelDb.getAllParcel();
			ArrayList<staff> st = staffDAO.AllStaff();
			ArrayList<customer> cust = custDAO.getCustomer();
			ArrayList<parcel> ntPar = parcelDb.getAllNotTaken();
			int totntPar = ntPar.size();
			int totCust = cust.size();
			int totParcel = par.size();
			int totSt = st.size();
			request.setAttribute("par", par);
			request.setAttribute("totntPar", totntPar);
			request.setAttribute("totPar", totParcel);
			request.setAttribute("totCust", totCust);
			request.setAttribute("totSt", totSt);
			request.getRequestDispatcher("listParcelStaff.jsp").forward(request, response);
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
