<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table align=center valign=top>
<tr><td colspan=2>
<form method=POST action="/app/updateView">
<input type=hidden id=bbs_id name=bbs_id value='${post.bbs_id}'>
		<table  id=tblView>
		<tr><td>제목</td><td><input type=text id=title name=title value=${post.title}></td></tr>
		<tr><td>내용</td><td><input type=text id=content name=content value=${post.content}></td></tr>
		<tr><td>작성자</td><td>${post.writer}</td></tr>
		<tr><td>작성시각</td><td>${post.created}</td></tr>
		<tr><td>수정시각</td><td>${post.updated}</td></tr>
		</table>
</td></tr>
<tr><td align=center><input type=submit id=btnUpdate value="수정"></td>
<td align=center><input type=button id=btnDelete value="삭제"></td></tr>
</table>
</form>
</body>
<script src='https://code.jquery.com/jQuery-3.5.0.js'></script>
<script>
// $(document)
// .on('click','#btnUpdate',function(){
// 	console.log($('#bbs_id').val());
// 	let bbs_id=$('#bbs_id').val();
// 	let title=$('#title').val();
// 	let content=$('#conent').val();
// 	document.location="/app/list";
// 	return false;
// 	})
	</script>
</html>