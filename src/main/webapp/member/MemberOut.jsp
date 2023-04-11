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
	<form action="/MemberOut" method="post">
		<table border="1" align="center">
			<tr>
				<th colspan="2">내 정보</th>
			</tr>
			<tr>
				<td><button type="button" id="cen">취소</button></td>
				<td><button id="out">탈퇴</button></td>
			</tr>
		</table>
	</form>

	<script type="text/javascript">
		$('#cen').on('click',function(){
			location.href="/index.jsp";
		});   
		
		$('#out').on('click',function(){
			let co = confirm("회원탈퇴하시겠습니까?");
			if(co){
				alert('회원 탈퇴 완료!')
				location.href = "/MemberOut";
			}else{
				location.href = "/member/MemberOut.jsp";
			}
		});
	</script>
</body>
</html>