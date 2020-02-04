<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="chris.spring.web.board.impl.BoardDAO" %>
<%@ page import="chris.spring.web.board.BoardVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Article Content</title>
</head>
<body>
<h1>글 상세</h1>
<a href="logout.do">Log-Out</a>
<form action="updateBoard.do" method="post">
<input name = "seq" type="hidden" value="${board.seq }">
<table border="1">
<tr>
	<td>제목</td>
	<td><input type="text" name="title" value="${board.title }"></td>
</tr>
<tr>
	<td>작성자</td>
	<td>${board.writer }</td>
</tr>
<tr>
	<td>내용</td>
	<td><textarea name="content">${board.content }</textarea></td>
</tr>
<tr>
	<td>등록일</td>
	<td>${board.regDate }</td>
</tr>
<tr>
	<td>조회수</td>
	<td>${board.cnt }</td>
</tr>
<tr>
	<td colspan="2"><input type="submit" value="글 수정"></td>
</tr>
</table>
</form><hr>
<a href="insertBoard.jsp">글 등록</a>&nbsp;&nbsp;&nbsp;
<a href="deleteBoard.do?seq=${board.seq }">글 삭제</a>&nbsp;&nbsp;&nbsp;
<a href="getBoardList.do">글 목록</a>
</body>
</html>