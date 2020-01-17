<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "membertwo.*" %>
<%
	String id = (String)session.getAttribute("userId");
	String pass = request.getParameter("pass");
	MemberDAO dao = MemberDAO.getInstance();
	int result = dao.deleteMember(id, pass);
	if(result == 1){
		session.invalidate();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<meta http-equiv="refresh" content = "3;url=login.jsp">
</head>
<body>
회원탈퇴가 정상적으로 완료되었습니다.<br>
3초후 로그인 페이지로 이동합니다.
<%
	} else {
%>
<script>
	alert('비밀번호가 틀렸습니다.');
	history.go(-1);
</script>
<%} %>
</body>
</html>