<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "actiontag.Customer, java.util.ArrayList" %>
<%
	ArrayList<String> singer = new ArrayList<String>();
	singer.add("김동률");
	singer.add("이적");
	request.setAttribute("carnival", singer);
	
	Customer[] customer = new Customer[2];
	customer[0] = new Customer();
	customer[0].setName("손오공");
	customer[0].setEmail("son@hanmail.net");
	customer[0].setPhone("010-1234-5678");
	customer[1] = new Customer();
	customer[1].setName("홍길동");
	customer[1].setEmail("hong@hanmail.net");
	customer[1].setPhone("010-9876-5432");
	request.setAttribute("customer", customer);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Example</title>
</head>
<body>
<ul>
	<li>${carnival[0]}, ${carnival[1]}</li>
</ul>
<ul>
	<li>이름 : ${customer[0].name }</li>
	<li>메일 : ${customer[0].email }</li>
	<li>전화 : ${customer[0].phone }</li>
</ul>
<ul>
	<li>이름 : ${customer[1].name }</li>
	<li>메일 : ${customer[1].email }</li>
	<li>전화 : ${customer[1].phone }</li>
</ul>
</body>
</html>