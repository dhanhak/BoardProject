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
<body>
	<table border="1" align="center">
		<tr>
			<td colspan="5" align="center" width="600">자유게시판</td>
		</tr>
		<tr>
			<td width="60%">제목</td>
			<td width="15%">작성자</td>
			<td width="15%">날짜</td>
			<td>조회</td>
		</tr>
		<c:choose>
			<c:when test="${list != null}">
				<c:forEach var="dto" items="${list }">
					<tr>
						<td><a href='/title.board?seq=${dto.seq }'>${dto.title }</a></td>
						<td>${dto.writer }</td>
						<td>${dto.write_date }</td>
						<td>${dto.view_count }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="5" align="center" width="500" height="500">표시할 내용이 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
		<tr>
			<td colspan="5" align="center">1 2 3 4 5 6 7 8 9 10</td>
		</tr>
		<tr>
			<td colspan="5" align="right">
				<a href="/write.board"><input type="button" value="작성하기"></a>
			</td>
		</tr>
	</table>
</body>
</html>