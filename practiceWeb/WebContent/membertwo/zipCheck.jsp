<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "membertwo.*,java.util.*" %>
<%
	request.setCharacterEncoding("utf-8");
	MemberDAO dao = MemberDAO.getInstance();
	String dong = request.getParameter("zip");
	Vector<ZipcodeVO> zipList = dao.zipcodeRead(dong);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우편번호 확인</title>
<script src = "script.js"></script>
</head>
<body align = "center">
<form method = "post" action = "zipCheck.jsp" name = "zipForm">
<table>
<tr>
	<td>검색 : </td>
	<td>&nbsp;&nbsp;<input type = "text" name = "zip" placeholder = "동이름을 입력하세요"></td>
	<td><input type = "button" value = "찾기" onClick = "dongCheck(document.zipForm.zip.value)"></td>
</tr>
</table>
</form>
<%
	if(zipList.size() == 0){
%>
검색결과가 없습니다.
<%
	}else{
		for(int i = 0;i<zipList.size();i++){
			ZipcodeVO vo = zipList.get(i);
%>
<a href ="javascript:sendAddress('<%=vo.getZipcode()%>','<%=vo.getSido()%>','<%= vo.getGugun()%>','<%=vo.getDong()%>','<%=vo.getRi()%>','<%=vo.getBunji()%>')">
<%=vo.getZipcode() %> <%=vo.getSido() %> <%= vo.getGugun() %> <%=vo.getDong() %> <%=vo.getRi() %> <%=vo.getBunji() %></a><br>
<%
		}
	}
%>
</body>
</html>