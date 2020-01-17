<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session = "true" %>
<%
	request.setAttribute("name", "이승재");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Object</title>
</head>
<body>
요청 URI : ${pageContext.request.requestURI }<br><br><!-- page범위 내에서 가질수 있는 값 -->
request의 name 속성 : ${requestScope.name }<br><br><!-- request객체 범위 내에서 가질수 있는 값 -->
code 파라미터 : ${param.code }<br><br><!-- parameter객체 범위에서 가질수 있는 값 -->
</body>
</html>