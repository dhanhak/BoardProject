<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.div {
	height: 250px;
}
</style>
<body>
	<form>
		<table border="1" align="center">
			<tr>
				<td colspan="3" align="center" width="600" style="font-style: normal;">${titleDto.title }</td>
			</tr>
			<tr>
				<td colspan="1">작성자 : ${titleDto.writer}</td>
				<td colspan="1">작성 날짜 : ${titleDto.write_date}</td>
				<td colspan="1">조회수 : ${titleDto.view_count}</td>
			</tr>
			<tr>
				<td colspan="3">
					<div class="div" cols="100%" rows="20%">${titleDto.contents}</div>
				</td>
			</tr>
			<tr>
				<td colspan="3" align="right">
					<a href="/board/list.jsp"><button type="button">목록으로</button></a>
					<a href="/update.board?seq=${titleDto.seq}"><button type="button">수정하기</button></a>
			</tr>
		</table>
	</form>
</body>
</html>