<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request 연습</title>


<script>
function validateForm(a){
// 	console.log(typeof())
	if(a.first_num.value == ''){
		alert("숫자를 입력하세요.")
		a.second_num.focus();
		return false;
	}
}

</script>

</head>
<body>

<h2>Request연습 Form(숫자 입력은 정수형으로 입력하세요.)</h2>

<form action="/webTest/requestTest02.do" method="get" onsubmit="return validateForm(this)">
	<input type="text" name="first_num">
	<select name="operator">
		<option>+</option>
		<option>-</option>
		<option>/</option>
		<option>%</option>
		<option>*</option>
	</select>
	<input type="text" name="second_num">
	<input type="submit" value="확인">
<!-- 	<button type="submit" name="확인">확인</button> -->
</form>

</body>
</html>