package iparcel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iparcel.DAO.lecturerDAO;
import iparcel.DAO.staffDAO;
import iparcel.DAO.studentDAO;
import iparcel.model.lecturer;
import iparcel.model.staff;
import iparcel.model.student;

@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String mail = request.getParameter("mail");
		String phone = request.getParameter("phone");
		String ic = request.getParameter("ic");
		String type = request.getParameter("type");
		
		if(type.equals("staff")) {
			try {
				staff s = new staff(id, name, pass, mail, phone, ic);
				boolean status = staffDAO.Update(s);
				request.getRequestDispatcher("updateSuccess.jsp").forward(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(type.equals("student")) {
			String program = request.getParameter("program");
			String status = request.getParameter("status");
			
			try {
				student s = new student(id, name, ic, phone, mail, pass, status, program);
				boolean status1 = studentDAO.update(s);
				request.getRequestDispatcher("updateSuccess.jsp").forward(request, response);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(type.equals("lecturer")) {
			String faculty = request.getParameter("faculty");
			try {
				lecturer l = new lecturer(id, name, ic, phone, mail, pass, faculty);
				boolean status1 = lecturerDAO.update(l);
				request.getRequestDispatcher("updateSuccess.jsp").forward(request, response);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
