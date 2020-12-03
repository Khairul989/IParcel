package iparcel.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iparcel.DAO.messageDAO;
import iparcel.model.message;

/**
 * Servlet implementation class InsertMessage
 */
@WebServlet("/InsertMessage")
public class InsertMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String rid = request.getParameter("rid");
			String sid = request.getParameter("sid");
			String msg = request.getParameter("message");
			String type = request.getParameter("type");
			System.out.println(rid+sid+msg+type);
			try {
				if(type.equals("stu")) {
					message m = new message();
					m.setReceiverid(rid);
					m.setSenderid(sid);
					m.setMsg(msg);
					
					boolean status = messageDAO.InsertMessage(m);
					request.getRequestDispatcher("MainMenu.jsp").forward(request, response);
				}
				else if(type.equals("lect")) {
					message m = new message();
					m.setReceiverid(rid);
					m.setSenderid(sid);
					m.setMsg(msg);
					
					boolean status = messageDAO.InsertMessage(m);
					request.getRequestDispatcher("LectureMenu.jsp").forward(request, response);
					}
				else if(type.equals("staff")) {
					message m = new message();
					m.setReceiverid(rid);
					m.setSenderid(sid);
					m.setMsg(msg);
					
					boolean status = messageDAO.InsertMessage(m);
					request.getRequestDispatcher("staffMain1.jsp").forward(request, response);
					}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}

}
