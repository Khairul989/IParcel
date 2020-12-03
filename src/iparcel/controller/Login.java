package iparcel.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import iparcel.DAO.lecturerDAO;
import iparcel.DAO.parcelDb;
import iparcel.DAO.staffDAO;
import iparcel.DAO.studentDAO;
import iparcel.model.lecturer;
import iparcel.model.parcel;
import iparcel.model.staff;
import iparcel.model.student;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String customer = request.getParameter("customer");
		
		try {
			ArrayList<parcel> parcel = parcelDb.getParcel(id);
			ArrayList<parcel> par = parcelDb.getTakenParcel(id);
			ArrayList<staff> staff = staffDAO.AllStaff();
			ArrayList<parcel> takenpar = parcelDb.getAllNotTaken();
			request.setAttribute("notTaken", takenpar);
			request.setAttribute("staff", staff);
			request.setAttribute("par", par);
			request.setAttribute("parcel", parcel);
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		
		if(customer.equals("student")) {
			try {
				student s = studentDAO.login(id, password);
				if(s != null) {

					HttpSession session = request.getSession();
					session.setAttribute("user", s);
					request.getRequestDispatcher("MainMenu.jsp").forward(request, response);;
				}
				else
				{
					request.setAttribute("err", true);
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
		}
		else if(customer.equals("lecturer")){
			try {

				lecturer l = lecturerDAO.login(id,password);
				
				if(l != null) {
					HttpSession session = request.getSession();
					session.setAttribute("user1", l);
					request.getRequestDispatcher("LectureMenu.jsp").forward(request, response);;
				}
				else
				{
					request.setAttribute("err", true);
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		else
		{
			try {

				staff s = staffDAO.login(id, password);
				
				if(s != null) {
					HttpSession session = request.getSession();
					session.setAttribute("user", s);
					request.getRequestDispatcher("staffMain1.jsp").forward(request, response);;
				}
				else
				{
					request.setAttribute("err", true);
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
				
			}
			catch (Exception e) {
				request.setAttribute("err", "system error"+e.getMessage());
				request.getRequestDispatcher("index.jsp").forward(request, response);
				return;
			}
		}
	}

}
