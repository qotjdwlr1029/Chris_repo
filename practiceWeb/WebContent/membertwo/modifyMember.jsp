<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "membertwo.*" %>
<%
	request.setCharacterEncoding("utf-8");
	String id = (String)session.getAttribute("userId");
	MemberDAO dao = MemberDAO.getInstance();
	MemberVO vo = dao.getMember(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정 화면</title>
<link rel = "stylesheet" href = "modifyMember.css">
<script src = "script.js"></script>
</head>
<body>
<form method = "post" action = "modifyProc.jsp"  width = "500" name = "modiForm">
<table border = "1">
	<tr>
		<td colspan = "2" id = "title">회원 수정 정보 입력</td>
	</tr>
	<tr>
		<td class = "subject">아이디 : </td>
		<td><%= vo.getId() %></td>
	</tr>
	<tr>
		<td class = "subject">패스워드 : </td>
		<td><input type = "text" name = "pass" value = "<%= vo.getPass() %>"></td>
	</tr>
	<tr>
		<td class = "subject">패스워드 확인 : </td>
		<td><input type = "text" name = "repass" value = "<%=vo.getPass() %>"></td>
	</tr>
	<tr>
		<td class = "subject">이름 : </td>
		<td><%=vo.getName() %></td>
	</tr>
	<tr>
		<td class = "subject">전화번호 : </td>
		<td>
			<input type = "text" name = "phone1" size = "4" value = "<%=vo.getPhone1() %>">
			- <input type = "text" name = "phone2" size = "5" value = "<%=vo.getPhone2() %>">
			- <input type = "text" name = "phone3" size = "5" value = "<%=vo.getPhone3() %>">
		</td>
	</tr>
	<tr>
		<td class = "subject">이메일 : </td>
		<td>
			<input type = "text" name = "email" value = "<%=vo.getEmail() %>">
		</td>
	</tr>
	<tr>
		<td class = "subject">우편번호 : </td>
		<td><input type = "text" name = "zipcode" value = "<%=vo.getZipcode() %>">&nbsp;&nbsp;
		<input type = "button" value = "찾기" onClick = "zipCheck()"></td>
	</tr>
	<tr>
		<td class = "subject">주소 1 : </td>
		<td><input type = "text" name = "address1" size = "50" value = "<%= vo.getAddress1()%>"></td>
	</tr>
	<tr>
		<td class = "subject">주소 2 : </td>
		<td><input type = "text" name = "address2" size = "30" value = "<%= vo.getAddress2()%>"></td>
	</tr>
	<tr>
		<td colspan = "2" id = "submit">
			<input type = "button" value = "정보수정" onClick = "modifyCheck()">&nbsp;&nbsp;
			<input type = "button" value = "취소" onClick = "javascript:window.location='login.jsp'">
		</td>
	</tr>
</table>
</form>
</body>
</html>