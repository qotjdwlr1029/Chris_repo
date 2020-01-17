<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "membertwo.*" %>
<%
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	MemberDAO dao = MemberDAO.getInstance();
	int result = dao.loginCheck(id, pass);
%>
<%
	if(result == -1){
%>
<script>
alert('아이디가 존재하지 않습니다.');
history.go(-1);
</script>
<%
	}else if(result == 0){
%>
<script>
alert('비밀번호가 일치하지 않습니다.');
history.go(-1);
</script>
<%
	}else{
		session.setAttribute("userId", id);
		response.sendRedirect("login.jsp");
	}
%>