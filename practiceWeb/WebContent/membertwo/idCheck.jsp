<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "membertwo.*" %>
<%
	MemberDAO dao = MemberDAO.getInstance();
	String id = request.getParameter("id");
	int result = dao.idCheck(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복확인</title>
</head>
<body align = "center">
<%if(result == 1) 
{ %>
<b><%=id %></b>는 사용가능한 아이디입니다.
<%} else {%>
<b><%=id %></b>는 존재하는 아이디입니다.
<%} %>
<br><br>
<a href = "#" onClick = "javascript:self.close()">닫기</a>
</body>
</html>