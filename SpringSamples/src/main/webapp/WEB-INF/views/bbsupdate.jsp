<%@page import="mul.cam.a.dto.BbsDTO"%>
<%@page import="mul.cam.a.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
MemberDTO login = (MemberDTO)session.getAttribute("login");
BbsDTO dto = (BbsDTO) request.getAttribute("updatebbs");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>

<h1>글 수정하기</h1>

<div align="center">

<form action="bbsUpdateAf.do" id="frm" method="post">
<input type="hidden" name="seq" value="<%=dto.getSeq() %>">
<table border="1">
<col width="200"><col width="500">

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
		<input type="text" id="title" name="title" size="50px" class="form-control form-control-lg" value='<%=dto.getTitle() %>' placeholder="제목기입">
	</td>
</tr>
<tr>
	<th>내용</th>
	<td>
		<textarea rows="20" id="content" class="form-control" name="content" placeholder="내용기입"><%=dto.getContent()%></textarea>
	</td>
</tr>
<tr>
	<td colspan="2">
		<button type="button">수정</button>
	</td>
</tr>

</table>
</form>
</div>

<script type="text/javascript">
$(document).ready(function() {
	
	$("button").click(function() {
		
		if($("#title").val().trim() == "" ){
			alert("제목을 기입해 주십시오");
			return;
		}else if($("#content").val().trim() == "" ){
			alert("내용을 기입해 주십시오");
			return;
		}else{
			$("#frm").submit();
		}		
	});	
});
</script>


</body>
</html>