<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="m1" class="sec01.ex01.MemberBean"/>
<jsp:setProperty property="*" name="m1"/>
<jsp:useBean id="addr" class="sec01.ex01.Address"/>
<jsp:setProperty property="city" name="addr" value="서울"/>
<jsp:setProperty property="zipcode" name="addr" value="07654"/>
<%
	m1.setAddr(addr);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
<table border="1" align="center">
	<tr align="center" bgcolor="#99ccff">
		<td width="7%"><b>아이디</b></td>
		<td width="7%"><b>비밀번호</b></td>
		<td width="5%"><b>이름</b></td>
		<td width="5%"><b>이메일</b></td>
		<td width="5%"><b>도시</b></td>
		<td width="5%"><b>우편번호</b></td>
	</tr>
	<tr align="center">
		<td>${m1.id }</td>
		<td>${m1.pwd }</td>
		<td>${m1.name }</td>
		<td>${m1.email }</td>
		<td>${m1.addr.city }</td>
		<td>${m1.addr.zipcode }</td>
	</tr>
</table>
</body>
</html>