<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 삭제</title>
</head>
<body>
<form method = "post" action = "deleteProc.jsp">
<table border = "1">
<tr>
	<td colspan = "2">회원 탈퇴</td>
</tr>
<tr>
	<td>비밀번호 입력</td>
	<td><input type = "text" name = "pass"></td>
</tr>
<tr>
	<td colspan = "2">
		<input type = "submit" value = "회원탈퇴">
		<input type = "button" value = "취소" onClick = "javascript:window.location='login.jsp'">
	</td>
</tr>
</table>
</form>
</body>
</html>