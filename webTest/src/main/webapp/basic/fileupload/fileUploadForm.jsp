<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>File Upload Form</h3>
<form action="<%= request.getContextPath()%>/fileupload.do" method="post" enctype="multipart/form-data">
	작성자 이름 : <input type="text" name="username"><br><br>
	한 개 파일 선택 : <input type="file" name="upFile1"><br><br>
	여러 개의 파일 선택 : <input type="file" name="upFile2" multiple><br><br>
	<input type="submit" value="전송">
</form>
<br><hr><br>

<a href="<%= request.getContextPath()%>/fileList.do">파일 목록 보기</a>
</body>
</html>