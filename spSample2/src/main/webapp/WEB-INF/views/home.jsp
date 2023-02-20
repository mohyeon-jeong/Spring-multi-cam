<%@page import="mul.cam.a.DTO.HumanDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>home</h1>
	<br>
	<a href="hello.do">hello</a>
	<br>
	<%
	String name = (String) request.getAttribute("name");
	if (name != null && !name.equals("")) {
	%>
		name : <%=name %>
	<%
	}
	%>
	<br>
	<br>
	<form action="world.do" method="post">
		name : <input type="text" name="name"><br>
		age : <input type="text" name="age"><br>
		<input type="submit" value="go to world">
	</form>
	<br>
	<br>
	<form action="main.do" method="post">
		name : <input type="text" name="name"><br>
		age : <input type="text" name="age"><br>
		<input type="submit" value="go to main">
	</form>
	<br>
	<br>
	<a href="mylist.do?message=hi">mylist</a>
	<%
	List<HumanDTO> list = (List<HumanDTO>) request.getAttribute("list");
	if (list != null && !list.isEmpty()) {
		%>
		<table border="1">
			<tr>
				<th>number</th>
				<th>name</th>
				<th>age</th>
			</tr>
			<%
			for (int i = 0; i < list.size(); i++) {
				HumanDTO dto = list.get(i);
				%>
				<tr>
					<th><%=i + 1 %></th>
					<td><%=dto.getName() %></td>
					<td><%=dto.getAge() %></td>
				</tr>
				<%
			}
			%>
		</table>
		<%
	}
	%>
</body>
</html>












