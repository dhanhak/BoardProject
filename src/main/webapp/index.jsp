<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<th colspan="2">Login Box</th>
		</tr>
		<tr>
			<td>아이디 :</td>
			<td><input type="text" placeholder="Input your id"></td>
		</tr>
		<tr>
			<td>패스워드 :</td>
			<td><input type="text" placeholder="Input your pw"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><a href="quiz04_boardList.html">
					<input type="button" value="로그인">
			</a> <input type="button" id="toJoin" value="회원가입"><br> <input
				type="checkbox">ID 기억하기</td>
		</tr>
	</table>
	<script type="text/javascript">
		$('#toJoin').on('click',function(){
			location.href="/member/joinform.jsp";
		});
	</script>
</body>
</html>