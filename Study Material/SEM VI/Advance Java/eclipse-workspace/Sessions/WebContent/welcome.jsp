<html>
<body bgcolor="#84ADDB">
<form action="welcome.jsp"></form>
<%
	String name = request.getParameter("ename");
	out.println("Welcome: "+name);
	session.setAttribute("user_session",name);
%>
<br>
<br>
<a href="second.jsp"> Click to go to the second jsp page.</a>

</body>
</html>