<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request연습용 Form문서</title>
</head>
<body>
<!-- 
	HTML 주석 영역... 
 -->

<%--
	JSP 주석 영역...
 --%>

<%
	// 이 영역은 JSP문서에서 Java명령을 사용할 수 있는 영역으로 '스크립틀릿'이라고 한다. 
	String name = "홍길동";
%>

<%--

<%= 변수명 또는 수식 %>  ==> "수식영역"이라 하고 이것은 JSP에서 변수의 값이나 수식의 결과를 출력할 때 사용한다.    

 --%>

<!-- 
	<form>태그의 속성 
1) action ==> <form>에서 구성한 데이터를 서버로 전송할 때 이 데이터를 받아서 처리할 문서명 또는 Servlet URL
 			   이 속성이 생략되면 현재 문서가 처리할 문서가 된다. 	
2) method ==> 전송방식 ( GET 또는 POST ) ==> (기본 : GET) 
3) enctype ==> 서버로 파일을 전송할 때 사용하는 속성으로 'multipart/form-data'값을 지정한다. 
4) target ==> 응답 결과가 나타날 프레임명  
 -->


<h2><%= name %>의 Request연습용 Form <%= 3*5 %></h2>

<form action="/webTest/requestTest01.do" method="get">
<table border="1">
	<tr>
		<td>이름</td>
		<td><input type="text" size="10" name="username"></td>
	</tr>
	
	<tr>
		<td>직업</td>
		<td>
			<select name="job">
				<option value="무직">==무직==</option>
				<option value="회사원">==회사원==</option>
				<option value="전문직">==전문직==</option>
				<option value="학생">==학생==</option>
			</select>
		</td>
	</tr>
	
	<tr>
		<td>취미</td>
		<td>
			<input type="checkbox" name="hobby" value="여행">여행
			<input type="checkbox" name="hobby" value="독서">독서
			<input type="checkbox" name="hobby" value="게임">게임
			<input type="checkbox" name="hobby" value="배드민턴">배드민턴
		</td>
	</tr>
	
	<tr>
		<td colspan="2" style="text-align:center; ">
			<input type="submit" value="전송">
			<input type="reset" value="초기화">
		</td>
	</tr>
</table>

</form>

</body>
</html>