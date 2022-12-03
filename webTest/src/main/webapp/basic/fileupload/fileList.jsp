<%@page import="kr.or.ddit.vo.FileVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%
	// 서블릿에서 보내온 파일 목록 받기 
	List<FileVO> fileList = (List<FileVO>)request.getAttribute("fileList");
%>
</head>
<body>
	<h2>전체 파일 목록</h2> <br><hr><br>
	
	<a href="<%= request.getContextPath()%>/fileupload.do">파일 업로드</a>
	
	<table border="1">
		<tr>
			<th>번호</th><th>작성자</th><th>저장파일명</th><th>원래의 파일명</th>
			<th>파일 크기</th><th>날짜</th><th>비고</th>
		</tr>
		
	<%
		if(fileList==null || fileList.size() == 0){
			
	%>
		<tr>
			<td colspan="7">파일 목록이 하나도 없습니다.</td>
		</tr>		
	<% }else{
		for(FileVO filevo : fileList){
			
	%>		
		<tr>
			<td><%= filevo.getFile_no() %></td>
			<td><%= filevo.getFile_writer() %></td>
			<td><%= filevo.getSave_file_name()%></td>
			<td><%= filevo.getOrigin_file_name() %></td>
			<td><%= filevo.getFile_size() %></td>
			<td><%= filevo.getFile_date() %></td>
			<td><a href="<%= request.getContextPath()%>/fileDownload.do?fileno=<%= filevo.getFile_no()%>">DownLoad</a></td>
		</tr>
	
	<% 
		}
		
	}
	%>
	
	</table>
</body>
</html>