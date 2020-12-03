package iparcel.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iparcel.DAO.custDAO;
import iparcel.DAO.lecturerDAO;
import iparcel.DAO.studentDAO;
import iparcel.model.customer;
import iparcel.model.lecturer;
import iparcel.model.student;

@WebServlet("/AddParcel")
public class AddParcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String type = request.getParameter("type");
			if(type.equals("lect")) {
				ArrayList<lecturer> lect = lecturerDAO.getLecturer();
				request.setAttribute("lecturer", lect);
			}
			else if (type.equals("stud"))
			{
				ArrayList<student> stu = studentDAO.getStudent();
				request.setAttribute("student", stu);
			}
			request.getRequestDispatcher("AddParcel.jsp").forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
