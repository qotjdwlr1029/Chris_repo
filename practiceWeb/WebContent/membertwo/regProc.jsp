<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "membertwo.*" %>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id = "vo" class = "membertwo.MemberVO">
	<jsp:setProperty name = "vo" property = "*"/>
</jsp:useBean>
<%
	MemberDAO dao = MemberDAO.getInstance();
	boolean check = dao.insertMember(vo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 확인페이지</title>
</head>
<body>
<%
	if(check){
%>
<div align = "center">
회원가입을 축하드립니다.
<br><a href = "login.jsp">로그인</a>
</div>
<%}else{ %>
<div align = "center">
다시 입력하시기 바랍니다.
<br><a href = "regForm.jsp">다시 입력</a>
</div>
<%} %>
</body>
</html>