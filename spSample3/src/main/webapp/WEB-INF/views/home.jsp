<%@page import="mul.cam.a.dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
List<MemberDTO> list = (List<MemberDTO>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>home</h1>
	<table border="1">
		<tr>
			<th>num</th>
			<th>id</th>
			<th>pw</th>
			<th>name</th>
			<th>email</th>
		</tr>
		<%
		for (int i = 0; i < list.size(); i++) {
			MemberDTO dto = list.get(i);
		%>
		<tr>
			<th><%=i + 1%></th>
			<td><%=dto.getId()%></td>
			<td><%=dto.getPwd()%></td>
			<td><%=dto.getName()%></td>
			<td><%=dto.getEmail()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>