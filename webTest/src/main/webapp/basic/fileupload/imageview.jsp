<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<h3>IMG 태그의 src속성에 Servlet으로 처리하기</h3>

<img src="../images/Koala.jpg" width="300"><br><br>

<img src="<%= request.getContextPath() %>/basic/images/Koala.jpg" width="300"><br><br>

<!-- <img src="d:/d_other/uploadFiles/" width="300"> --> 
<img src="<%= request.getContextPath() %>/images/imageView.do?fileno=8" width="300">
</body>
</html>