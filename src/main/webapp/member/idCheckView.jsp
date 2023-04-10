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
	<table>
		<tr>
			<th>아이디 중복 확인</th>
		</tr>
		<tr>
			<td></td>
		</tr>
		<tr>
			<td><button id='sele'>사용</button></td>
			<td><button id='cen'>취소</button></td>
		</tr>
	</table>
	<script type="text/javascript">
		$('#sele').on('click', function() {
			opener.idValidFlag = true;
			window.close();
		});
		$('#cen').on('click', function() {
			opener.document.getElementById('input-id').value = '';
			window.close();
		});
	</script>
</body>
</html>