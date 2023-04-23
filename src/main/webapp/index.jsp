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

	<c:if test="${param.state == 'a_j'}">
		<script type="text/javascript">
			alert('회원가입을 축하드립니다.');
		</script>
	</c:if>

	<c:choose>
		<c:when test="${sessionScope.loginID == null}">
			<form action="Login.member" method="get">
				<table border="1" align="center">
					<tr>
						<th colspan="2">Login Box</th>
					</tr>
					<tr>
						<td>아이디 :</td>
						<td><input type="text" name="userId" placeholder="Input your id"></td>
					</tr>
					<tr>
						<td>패스워드 :</td>
						<td><input type="password" name="userPw" placeholder="Input your pw"></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<input type="submit" value="로그인">
								</form>
						</a> <input type="button" id="toJoin" value="회원가입"><br> <input type="checkbox">ID 기억하기</td>
					</tr>
				</table>
		</c:when>
		<c:otherwise>
			<table border="1" align="center">
				<tr>
					<th colspan="4">${sessionScope.loginID }님어서오세요.</th>
				</tr>
				<tr>
					<td align="center"><a href="/list.board"><button>게시판으로</button></a></td>
					<td align="center"><a href="/Mypage.member"><button>마이페이지</button></a></td>
					<td align="center"><a href="/Logout.member"><button>로그아웃</button></a></td>
					<td align="center"><a href="/member/MemberOut.jsp"><button>회원탈퇴</button></a></td>
				</tr>
			</table>
		</c:otherwise>
	</c:choose>

	<script type="text/javascript">
		$('#toJoin').on('click', function() {
			location.href = "/member/joinform.jsp";  
		});
	</script>
</body>
</html>