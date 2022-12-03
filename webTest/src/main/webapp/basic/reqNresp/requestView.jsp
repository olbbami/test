<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% int num1 = Integer.parseInt(request.getParameter("first_num"));
   int num2 = Integer.parseInt(request.getParameter("second_num"));	
   String operator = request.getParameter("operator");
   double result = 0; 	
   
   boolean calcOk = true; // 계산 성공여부가 저장될 변수 선언 
   
   switch(operator){
   case "+":
	   result = num1 + num2; break;
   case "-":
   	   result = num1 - num2; break;
   case "*":
	   result = num1 * num2; break;
   case "/":
	   if(num2 != 0){
		   result = (double)num1 / num2;
	   }else{
		   calcOk = false;
	   }
	   result = num1 / num2; break;
   case "%":
	   if(num2 != 0){	
	   	result = (double)num1 % num2; 
	   }else{
		   calcOk = false;
	   }
	   	break;
   }
   
   if(calcOk == false){
	   
   	   response.sendRedirect("/webTest/basic/reqNresp/requestTest02.jsp");
   }
   
%>
 	
<h2>계산 결과</h2>

<p> <%= num1 + operator + num2 + "=" + result %> 


</body>
</html>