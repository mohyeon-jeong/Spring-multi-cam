<%@page import="mul.cam.a.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
MemberDTO login = (MemberDTO) session.getAttribute("login");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>자료 추가</h1>
	<div align="center">
		<form action="pdsUpload.do" method="post" enctype="multipart/form-data">
			<table border="1">
				<tr>
					<th>아이디</th>
					<td>
						<%=login.getId() %>
						<input type="hidden" name="id" value="<%=login.getId() %>">
					</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="title" size="50">
					</td>
				</tr>
				<tr>
					<th>파일 업로드</th>
					<td>
						<input type="file" name="fileload">
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea rows="10" cols="50" name="content"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="자료 올리기">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>





















