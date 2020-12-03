package iparcel.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iparcel.DAO.custDAO;
import iparcel.DAO.messageDAO;
import iparcel.DAO.staffDAO;
import iparcel.model.customer;
import iparcel.model.message;
import iparcel.model.staff;

@WebServlet("/setMessage")
public class setMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		System.out.println(id+type);
		try {
			if(type.equals("customer")) {
				ArrayList<message> msg = messageDAO.getMessage(id);
				request.setAttribute("message", msg);
				request.getRequestDispatcher("Message.jsp").forward(request, response);
			}
			else if(type.equals("staffview")) {
				ArrayList<message> msg = messageDAO.getMessage(id);
				request.setAttribute("message", msg);
				request.getRequestDispatcher("StaffMessage.jsp").forward(request, response);
			}
			else if(type.equals("cust")) {
				ArrayList<staff> staff = staffDAO.AllStaff();
				request.setAttribute("st", staff);
				request.getRequestDispatcher("AddMessage.jsp").forward(request, response);
			}
			else if(type.equals("staff")) {
				ArrayList<customer> cust = custDAO.getCustomer();
				request.setAttribute("cust", cust);
				request.getRequestDispatcher("AddMessageStaff.jsp").forward(request, response);
			}
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
