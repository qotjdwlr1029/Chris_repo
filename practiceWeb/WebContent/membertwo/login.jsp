<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String LoginID = (String)session.getAttribute("userId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<link rel = "stylesheet" href = "login.css">
</head>
<body>
<%
	if(LoginID == null){
%>
<h1>로그인 화면</h1>
<form method = "post" action = "loginProc.jsp">
<table border = "1">
<tr>
	<td class = "ti">아이디 : </td>
	<td><input type = "text" name = "id" placeholder = "아이디"></td>
</tr>
<tr>
	<td class = "ti">비밀번호 : </td>
	<td><input type = "password" name = "pass" placeholder = "비밀번호"></td>
</tr>
<tr>
<td id = "button"><input type = "submit" value = "로그인" ></td>
<td><input type ="button" id = "register" value = "회원가입" onClick = "javascript:window.location='regForm.jsp'"></td>
</tr>
</table>
</form>
<%
	}else{
%>
<table border = "1">
<tr>
	<td colspan = "3"><%=LoginID %>님 환영합니다.</td>
</tr>
<tr>
	<td><a href = "modifyMember.jsp">정보수정</a></td>
	<td><a href = "delete.jsp">회원탈퇴</a></td>
	<td><a href = "logout.jsp">로그아웃</a></td>
</tr>
</table>
<%} %>
</body>
</html>