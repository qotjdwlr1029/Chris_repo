<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String userID = request.getParameter("userID");
	if(userID.length()==0){
%>
<jsp:forward page="login.jsp"/>
<%
//위의 태그는 RequestDispatcher클래스의 forward메서드의 기능과 동일하다.
	}
%>
<h1> 환영합니다. <%=userID %>님!! </h1>
</body>
</html>