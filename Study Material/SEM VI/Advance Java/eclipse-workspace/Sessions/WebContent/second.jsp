<html>
<body bgcolor="pink">
<%
	String name = (String)session.getAttribute("user_session");
	out.print("Hello: "+name);
%>

</body>
</html>