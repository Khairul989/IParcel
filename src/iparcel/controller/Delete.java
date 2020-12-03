package iparcel.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iparcel.DAO.messageDAO;
import iparcel.DAO.parcelDb;
import iparcel.DAO.staffDAO;
import iparcel.model.parcel;
import iparcel.model.staff;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		
		try {
			if(type.equals("staff")) {
				boolean status1 = staffDAO.Delete(id);
				response.sendRedirect("staffMain1.jsp");
			}
			else if(type.equals("parcel")){
				boolean status = parcelDb.Delete(id);
				response.sendRedirect("staffMain1.jsp");
			}
			else if(type.equals("stuMessage")){
				boolean status = messageDAO.DeleteMessage(id);
				response.sendRedirect("MainMenu.jsp");
			}
			else if(type.equals("staffMessage")) {
				boolean status = messageDAO.DeleteMessage(id);
				response.sendRedirect("staffMain1.jsp");
			}
			else if(type.equals("lectMessage")) {
				boolean status = messageDAO.DeleteMessage(id);
				response.sendRedirect("LecturerMenu.jsp");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
