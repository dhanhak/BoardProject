<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js"></script>
</head>
<style>
.div {
	height: 250px;
}

</style>
<body>
		<table border="1" align="center">
			<tr>
				<td colspan="3" align="center" width="600" style="font-style: normal;">
				<input type = text name="title" value = "${titleDto.title} "></td>
			</tr>
			<tr>
				<td colspan="1">작성자 : <input type = text value = "${titleDto.writer}" readonly></td>
				<td colspan="1">작성 날짜 : ${titleDto.write_date}</td>
				<td colspan="1">조회수 : ${titleDto.view_count}</td>
			</tr>
			<tr>
				<td colspan="3">
					<div class="div" cols="100%" rows="20%">
						<textarea type="text" name="contents" value="${titleDto.contents}" cols = "85" rows = "15">
						</textarea>
					</div>
				</td>
			</tr>
			<tr>
				<td colspan="3" align="right">
					<a href="/updateboard.board"><button type="submit">수정하기</button></a>
					<a href="/board/list.jsp"><button type="button">목록으로</button></a>
			</tr>
		</table>
		
</body>
</html>