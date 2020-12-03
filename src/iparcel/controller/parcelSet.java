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
 * Servlet implementation class parcelSet
 */
@WebServlet("/parcelSet")
public class parcelSet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		try {
			ArrayList<parcel> parcel = parcelDb.getParcel(id);
			request.setAttribute("parcel", parcel);
			if (type.equals("stu")){
				request.getRequestDispatcher("MainMenu.jsp").forward(request, response);
			}
			else if(type.equals("lect")) {
				request.getRequestDispatcher("LectureMenu.jsp").forward(request, response);
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
