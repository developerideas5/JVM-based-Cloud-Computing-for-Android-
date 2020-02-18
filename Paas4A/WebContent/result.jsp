<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
try {
	
	Object obj = session.getAttribute("resultset");
	
	if(obj != null)	{
	
ResultSet rs = (ResultSet) obj;
%>

<table>
	
	
	<tr>
		<% for ( int i =1; i <= rs.getMetaData().getColumnCount(); i++ ) { %>
		<th bgcolor="GREY">
			<%= rs.getMetaData().getColumnName(i) %>
		
		</th>
	<% } %>
	
	</tr>
	
	
	<%while(rs.next()) { %>
	
	<tr>

		<% 
		if(rs.getMetaData().getColumnCount()> 0)
		for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++) { %>
	
		<td>
			<%= rs.getString(i) %>
		
		</td>
		
		<% } %>
		
	</tr>

<%}
	
	} 
	else {
	%>
	<tr><td>
	No resultset received. (May be case of update insert or create query)
	</td></tr>
	<%	
	}
	
} 
	
	catch (Exception e) {
	%>

<tr><td> Faced issue while getting resultset </td></tr>

 <%= e.getMessage() %>

<%
e.printStackTrace();
} 


%>

</table>

<form action="/query.jsp"> <input type="submit" value="Back" /> </form>

</body>
</html>