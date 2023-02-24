<%@page import="mul.cam.a.dto.MemberDTO"%>
<%@page import="mul.cam.a.dto.BbsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<title>Answer</title>
</head>
<body>

<%
BbsDTO dto = (BbsDTO) request.getAttribute("dto");
%>

<div align="center">

<h2>원문</h2>

<table border="2">
<col width="200"><col width="500">
<tr>
	<th>작성자</th>
	<td><%=dto.getId() %></td>
</tr>
<tr>
	<th>제목</th>
	<td><%=dto.getTitle() %></td>
</tr>
<tr>
	<th>작성일</th>
	<td><%=dto.getWdate() %></td>
</tr>
<tr>
	<th>조회수</th>
	<td><%=dto.getReadcount() %></td>
</tr>
<tr>
	<th>내용</th>
	<td>
		<textarea rows="10" cols="50" readonly><%=dto.getContent() %></textarea>
	</td>
</tr>
</table>

<%
MemberDTO login = (MemberDTO) session.getAttribute("login");
%>

<h2>답글</h2>

<form action="answerAf.do" id="frm" method="post">
<input type="hidden" name="seq" value="<%=dto.getSeq() %>">

<table border="1">
<col width="200"><col width="500">
<tr>
	<th>아이디</th>
	<td>
		<input type="text" name="id" size="50" readonly="readonly" value="<%=login.getId() %>">
	</td>
</tr>
<tr>
	<th>제목</th>
	<td>
		<input type="text" id="title" name="title" size="50">
	</td>	
</tr>
<tr>
	<th>내용</th>
	<td>
		<textarea rows="10" cols="50" id="content" name="content"></textarea>
	</td>
</tr>
<tr>
	<td colspan="2" align="center">
		<button type="button">작성완료</button>
	</td>
</tr>
</table>
</form>
</div>
<script type="text/javascript">
	$("button").click(function() {
		if($("#title").val().trim() == ""){
			alert("제목을 기입해 주십시오");
			return;
		}else if($("#content").val().trim() == ""){
			alert("내용을 기입해 주십시오");
			return;
		}else{
			$("#frm").submit();
		}		
	});
</script>
</body>
</html>