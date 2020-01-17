 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ page import = "boardtwo.*" %>
<%@ include file = "view/color.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	try{
		BoardDAO dbPro = BoardDAO.getInstance();
		BoardVO article = dbPro.getArticle(num);
		int ref = article.getRef();
		int step = article.getStep();
		int depth = article.getDepth();
%>
<body bgcolor = "<%=bodyback_c %>">
<div align = center>
<b>글내용 보기</b>
<br><br>
<form>
<table width = "500" border = "1" cellspacing = "0" cellpadding = "0" bgcolor = "<%=bodyback_c %>" align = "center">
	<tr height = "30">
		<td align = "center" width = "125" bgcolor = "<%=value_c %>">글번호</td>
		<td align = "center" width = "125"><%=article.getNum() %></td>
		<td align = "center" width = "125" bgcolor = "<%=value_c %>">조회수</td>
		<td align = "center" width = "125"><%=article.getReadcount() %></td>
	</tr>
	<tr>
		<td align = "center" width = "125" bgcolor = "<%=value_c%>">작성자</td>
		<td align = "center" width = "125"><%=article.getWriter() %></td>
		<td align = "center" width = "125" bgcolor = "<%=value_c %>">작성일</td>
		<td align = "center" width = "125"><%=sdf.format(article.getRegdate()) %></td>
	</tr>
	<tr height = "30">
		<td align = "center" width = "125" bgcolor = "<%=value_c %>">글제목</td>
		<td align = "left" width = "375" colspan = "3"><%=article.getContent() %></td>
	</tr>
	<tr height = "30">
		<td colspan = "4" bgcolor = "<%=value_c %>" align = "right">
			<input type = "button" value = "글수정" onclick = "document.location.href ='updateForm.jsp?num=<%=article.getNum() %>&pageNum=<%=pageNum %>'">
			&nbsp;&nbsp;&nbsp;&nbsp;
			<input type = "button" value = "글삭제" onclick = "document.location.href='deleteForm.jsp?num=<%=article.getNum() %>&pageNum=<%=pageNum %>'">
			&nbsp;&nbsp;&nbsp;&nbsp;
			<!-- 수정<1> -->
			<input type = "button" value = "글목록" onclick = "document.location.href='list.jsp?pageNum=<%=pageNum %>'">
		</td>
	</tr>
</table>
<%
	}catch(Exception e) {} 
%>
</form>
</div>
</body>
</html>