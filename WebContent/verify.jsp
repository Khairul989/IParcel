<%
	if (session.getAttribute("user") == null || session.getAttribute("user").equals("")){
		response.sendRedirect("index.jsp");
	}
	else if (session.getAttribute("user1") == null || session.getAttribute("user1").equals("")){
		response.sendRedirect("index.jsp");
	}
%>
