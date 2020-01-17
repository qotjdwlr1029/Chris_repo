<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "membertwo.*" %>
<jsp:useBean id = "vo" class = "membertwo.MemberVO">
	<jsp:setProperty name = "vo" property = "*"/>
</jsp:useBean>
<%
	System.out.println("a" + vo.getPass());
	request.setCharacterEncoding("utf-8");
	MemberDAO dao = MemberDAO.getInstance();
	String loginID = (String)session.getAttribute("userId");
	vo.setId(loginID);
	dao.updateMember(vo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 결과</title>
</head>
<meta http-equiv = "refresh" content = "3;url=login.jsp">
<body>
회원정보 수정이 완료 되었습니다.<br>
3초후에 로그인 화면으로 이동합니다.
</body>
</html>