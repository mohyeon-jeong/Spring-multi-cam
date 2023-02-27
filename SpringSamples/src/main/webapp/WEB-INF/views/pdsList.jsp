<%@page import="mul.cam.a.dto.PdsDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
List<PdsDTO> list = (List<PdsDTO>) request.getAttribute("pdsList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>자료실</h1>
	<hr>
	<div align="center">
		<table border="1">
			<col width="50">
			<col width="100">
			<col width="300">
			<col width="50">
			<col width="50">
			<col width="50">
			<col width="100">
			<col width="50">
			<thead>
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>다운로드</th>
					<th>조회수</th>
					<th>다운수</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (int i = 0; i < list.size(); i++) {
					PdsDTO pds = list.get(i);
					%>
					<tr>
						<th><%=i + 1 %></th>
						<td><%=pds.getId() %></td>
						<td><%=pds.getTitle() %></td>
						<td>
							<input type="button" value="다운로드" onclick="fileDown(<%=pds.getSeq()%>, '<%=pds.getNewFileName()%>', '<%=pds.getFileName()%>')">
						</td>
						<td><%=pds.getReadCount() %></td>
						<td><%=pds.getDownCount() %></td>
						<td><%=pds.getRegDate() %></td>
					</tr>
					<%
				}
				%>
			</tbody>
		</table>
		<button type="button" onclick="pdsWrite()">자료추가</button>
	</div>
	<form name="file_down" action="fileDownload.do" method="post">
		<input type="hidden" name="newFileName">
		<input type="hidden" name="fileName">
		<input type="hidden" name="seq">
	</form>
	<script type="text/javascript">
		function pdsWrite() {
			location.href = "pdsWrite.do";
		}
		function fileDown(seq, newFileName, fileName) {
			document.file_down.newFileName.value = newFileName;
			document.file_down.fileName.value = fileName;
			document.file_down.seq.value = seq;
			document.file_down.submit();
		}
	</script>
</body>
</html>