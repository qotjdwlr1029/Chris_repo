<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"
    import="java.util.*,sec01.ex01.*"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="m1" class="sec01.ex01.MemberBean"/>
<jsp:setProperty name="m1" property="*" />
<%--회원가입창에서 전송된 회원 정보를 빈 속성에 설정합니다. --%>
<jsp:useBean id="membersList" class="java.util.ArrayList"/>
<%
	MemberBean m2 = new MemberBean("son","1234","손흥민","son@test.com");
	membersList.add(m1);
	membersList.add(m2);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
	<table border="1" align="center">
		<tr align = "center" bgcolor="#99ccff">
			<td width="20%"><b>아이디</b></td>
			<td width="20%"><b>비밀번호</b></td>
			<td width="20%"><b>이름</b></td>
			<td width="20%"><b>이메일</b></td>
		</tr>
		<tr align="center">
			<td>${membersList[0].id }</td>
			<td>${membersList[0].pwd }</td>
			<td>${membersList[0].name }</td>
			<td>${membersList[0].email }</td>
		</tr>
		<tr align="center">
			<td>${membersList[1].id }</td>
			<td>${membersList[1].pwd }</td>
			<td>${membersList[1].name }</td>
			<td>${membersList[1].email }</td>
		</tr>
	</table>
</body>
</html>