<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/insertwrite.board">
		<table border="1" align="center">
			<tr>
				<td colspan="3" align="center" width="600"
					style="font-style: normal;">자유게시판 글 작성하기</td>
			</tr>
			<tr>
				<td colspan="3">
				<input type="text" placeholder="글 제목을 입력하세요." name="title" size="50">
				</td>
			</tr>
			<tr>
				<td colspan="3"><textarea cols="100%" name="contents" rows="20%"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="3" align="right"><a href="/list.board">
						<button type="button">목록으로</button>
				</a>

					<button>작성완료</button></td>
			</tr>
		</table>
	</form>
</body>
</html>