<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%= request.getContextPath()%>/js/jquery-3.6.1.min.js"></script>

<script>
$(function(){
	$('#lprodBtn').on('click', function(){
		$.ajax({
			url : "<%= request.getContextPath()%>/lprodListController.do",
			type : "get",
			success : function(data){
				let htmlcode = "<table border='1'>";
				htmlcode += "<tr><td>LPROD_ID</td><td>LPROD_NM</td></tr>";
				
				$.each(data, function(i, v){
					htmlcode += "<tr><td>" + v.lprod_id + "</td>";
					htmlcode += "<td>" + v.lprod_gu + "</td>";
					htmlcode += "<td>" + v.lprod_nm + "</td></tr>";
 				});
				
				htmlcode += "</table>";
				
				$('#result').html(htmlcode);
				
				
			},
			
			dataType : "json"
		})
	})
	
	$('#lprodBtn2').on('click', function(){
		location.href = "<%= request.getContextPath()%>/lprodListController2.do";
		
	})
	
})
</script>
</head>

<body>
	<form>
		<input type="button" id="lprodBtn" value="Lprod자료 가져오기(Ajax-비동기방식)">
		<input type="button" id="lprodBtn2" value="Lprod자료 가져오기(Non Ajax-동기방식)">
	</form>
	<hr>
	<h2>Lprod 자료 목록</h2>
	<div id="result"></div>
</body>
</html>