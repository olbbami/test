<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session 로그인 페이지</title>
</head>
<body>
<%
	
	String check = (String)session.getAttribute("chk");	
	MemberVO loginMember = (MemberVO)session.getAttribute("loginMember");
	
%>

<% if("success".equals(check)) {%>

	<h2><%= session.getAttribute("ID")%>님 반갑습니다.</h2>
	
	<a href="<%= request.getContextPath()%>/dbsessionLogout.do">로그아웃</a>

<% } else {
	if("fail".equals((String)session.getAttribute("chk"))){
		out.println("로그인에 실패하였습니다.");
	}
		
	
%>

<form action="<%= request.getContextPath()%>/dbsessionLogin.do">
	<table>
		
		<tr>
			<td>ID :</td>
			<td><input type="text" name="userid" placeholder="ID를 입력하세요"></td>
		</tr>
		
		<tr>
			<td>PASS : </td>		
			<td><input type="password" name="userpass" placeholder="PASSWORD를 입력하세요"></td>		
		</tr>

		<tr>
			<td colspan="2"><input type="submit" value="Login"></td>		
		</tr>
	</table>
</form>

<% } %>


</body>
</html>