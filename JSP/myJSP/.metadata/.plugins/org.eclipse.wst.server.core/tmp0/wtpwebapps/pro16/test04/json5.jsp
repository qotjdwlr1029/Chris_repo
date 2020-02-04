<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(function(){
	$("#checkJson").click(function(){
		var _jsonInfo = '{"name":"박지성","age":"25","gender":"남자","nickname":"날쌘돌이"}';
		$.ajax({
			type:"post",
			async:false,
			url:"${pageContext.request.contextPath}/json",
			data:{jsonInfo:_jsonInfo},
			success:function(data,textStatus){
				
			},
			error:function(data,textStatus){
				alert("에러가 발생했습니다.");
			},
			complete:function(data,textStatus){
				
			}
		});//end ajax
	});
})
</script>
</head>
<body>
	<input type="button" value="콘솔출력" id="checkJson">
</body>
</html>