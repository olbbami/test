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
	// 문자열 처리 
	$('#strBtn').on('click',function(){
		
		$.ajax({
			url : "<%= request.getContextPath() %>/JSONController.do",		
			type : "post",
			data : "choice=str", // 서버로 전송할 데이터 설정 
// 			data : "choice=str&test=123",
// 			data : {"choice" : "str", "test" : 123},
			success : function(data){  // 'data'변수에는 서버에서 보내온 데이터가 저장된다. 
				$('#result').html(data);   // 가져온 데이터를 화면에 보여주기 
			
			},
			
			dataType : "json"     // 서버가 보내온 데이터의 종류를 나타낸다. 
			
		})
	
	})
	//---------------------------------------
	
	// 배열 
	$('#arrayBtn').on('click', function(){
		$.ajax({
			url : "<%= request.getContextPath() %>/JSONController.do",
			type : "post",
			data : "choice=array",
			success : function(data){    // data변수에 배열이 저장된다. 
				let htmlcode = "";
				$.each(data, function(i,v){
					htmlcode += i + "번째 자료 : " + v + "<br>";
				})
				
				$("#result").html(htmlcode);
				
			},
			
			dataType : "json"
		})
	})
	//-----------------------------------
	
	// 객체 
	$('#objBtn').on('click', function(){
		$.ajax({
			url : "<%= request.getContextPath() %>/JSONController.do",
			type : "post",
			data : "choice=obj",
			success : function(data){    // JSON객체 구조의 데이터가 저장된다.  (data가 객체변수가 된다.) 
										 // {"testId" : "a001", "name" : "홍길동"}	
				let htmlCode = ""; 
				htmlCode += "ID : "+ data.testId + "<br>";
				htmlCode += "NAME : " + data.name + "<br>";
				$('#result').html(htmlCode);
			},
			
			
			dataType : "json"
		})
	})
	
	$('#listBtn').on('click', function(){
		$.ajax({
			url : "<%= request.getContextPath() %>/JSONController.do",
			type : "post",
			data : "choice=list",
			success : function(data){    // JAVA의 리스트는 JSON의 배열로 나타낸다.. 
				let htmlCode = ""; 
				$.each(data, function(i,v){
					htmlCode += i + "번째 자료<br>";
					htmlCode += "ID : " + v.testId + "<br>";
					htmlCode += "NAME : " + v.name + "<hr>";
				})
				
				$('#result').html(htmlCode);
				
			},
			dataType : "json"
		})
	})
	
	
	$('#mapBtn').on('click', function(){
		$.ajax({
			url : "<%= request.getContextPath() %>/JSONController.do",
			type : "post",
			data : "choice=map",
			success : function(data){    // JAVA의 Map객체는 JSON에서 일반 객체로 나타낸다. 
				let htmlCode = ""; 
				htmlCode += "이름 : " + data.name +"<br>";
				htmlCode += "전화 : " + data.tel + "<br>";
				htmlCode += "주소 : " + data.addr + "<br>";
			
				$('#result').html(htmlCode);
								
			},
			dataType : "json"
		})
	})
	
	
});
</script>

</head>

<body>
	<form>
		<input type="button" id="strBtn" value="문자열">
		<input type="button" id="arrayBtn" value="배열">
		<input type="button" id="objBtn" value="객체">
		<input type="button" id="listBtn" value="리스트">
		<input type="button" id="mapBtn" value="Map객체">
	</form>
	
	<hr>
	<div id="result">
	
	</div>
	
</body>
</html>