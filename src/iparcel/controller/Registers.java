package iparcel.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iparcel.DAO.custDAO;
import iparcel.DAO.lecturerDAO;
import iparcel.DAO.staffDAO;
import iparcel.DAO.studentDAO;
import iparcel.model.customer;
import iparcel.model.lecturer;
import iparcel.model.staff;
import iparcel.model.student;

@WebServlet("/Registers")
public class Registers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		
		if(user.equals("student")) {
			
			String id = request.getParameter("stu_id");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String program = request.getParameter("prog");
			String ic = request.getParameter("ic");
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");
			String status = request.getParameter("status");
			
			customer s = new student(id, name, ic, phone, email, pass, status, program);
			try {
				boolean status1 = studentDAO.register((student) s);
				request.setAttribute("status", status1);
				request.getRequestDispatcher("successRegister.jsp").forward(request, response);;
			} catch (SQLException e) {
				e.printStackTrace();
			}
					
		}
		
		else if(user.equals("lecturer")) {
			
			String id = request.getParameter("id");
			String fullname = request.getParameter("name");
			String ic = request.getParameter("ic");
			String mail = request.getParameter("mail");
			String phone = request.getParameter("phone");
			String pass = request.getParameter("pwd");
			String faculty = request.getParameter("faculty");
			
			customer c = new lecturer(id, fullname, ic, phone, mail, pass, faculty);
			try {
				boolean status = lecturerDAO.register((lecturer) c);
				request.setAttribute("status", status);
				request.getRequestDispatcher("successRegister.jsp").forward(request, response);;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		else if(user.equals("staff")){
			staff s = new staff();
			s.setId(request.getParameter("id"));
			s.setName(request.getParameter("name"));
			s.setPassword(request.getParameter("pwd"));
			s.setEmail(request.getParameter("mail"));
			s.setPhone(request.getParameter("phone"));
			s.setIc(request.getParameter("ic"));
			
			try {
				staffDAO.staffRegister(s);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if( s.isVerify() == false) {
				response.sendRedirect("staffDuplicate.jsp");
			}
			else
			{
				response.sendRedirect("staffregSuccess.jsp");

			}
		}
	}

}
