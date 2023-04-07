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
	<table align="center">
		<tr>
			<th>아이디 중복 확인</th>
		</tr>
		<tr>
		<c:choose>
			<c:when test="${result == true}">
				<td>중복된 아이디입니다.</td>
				<td><button id='cen'>취소</button></td>
			</c:when>
			<c:otherwise><td>사용 가능 아이디입니다.</td>
			<tr>
			<td><button id='call'>사용</button></td>
			</tr>
			</c:otherwise>
		</c:choose>
		</tr>
		<tr>
		</tr>
	</table>
	<script type="text/javascript">
		$('#cen').on('click',function(){
			opener.document.getElementById('input-id').value = '';
			window.close();
		});
		
		$('#call').on('click',function(){
			opener.idValidFlag = true;
			window.close();
		});
	</script>
</body>
</html>