<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<style>
table#tblList {
	border-collapse:collapse;
}
table#tblList td {
	border:1px solid blue;
}
table#tblList th {
	color:white;
	background-color:black;
	border:1px solid yello;
}
</style>
<body>
<table align=center valign=top>
<tr><td>
		<table id=tblList>
		<thead>
		<tr><th>게시물번호</th><th>제목</th><th>작성자</th><th>작성시각</th><th>수정시각</th></tr>
		</thead>
<c:forEach items="${list_BBS }" var="rec">
		<tr><td>${rec.bbs_id}</td><td>${rec.title}</td><td>${rec.writer}</td>
				<td>${rec.created}</td><td>${rec.updated}</td></tr>
</c:forEach>
</table>
</td></tr>
<tr><td>
<input type=button value='새글쓰기'  id=btnNew>
</td></tr>
</table>
</body>
<script src='https://code.jquery.com/jQuery-3.5.0.js'></script>
<script>
$(document)
.on('click','#tblList tr',function(){
	let bbs_id=$(this).find('td:eq(0)').text();
	console.log('bbs_id['+bbs_id+']');
	document.location="/app/view/"+bbs_id; //"http://localhost:8081/app/view/2"
	return false;
})
.on('click','#btnNew',function(){
	document.location="/app/new/"
	return false;
})
</script>
</html>