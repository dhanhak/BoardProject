<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"></script>
		<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
		<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js"></script>
	</head>
	<style>
		* {
			box-sizing: border-box;
		}

		h4 {
			text-align: center;
		}

		.left {
			text-align: right;
		}
	</style>

	<body>
		<form action="" method="post">
			<div class="container">
				<div class="row header">
					<div class="col-12">
						<h4>내 정보</h4>
					</div>
				</div>
				<div class="row body">
					<div class="col-4 left">아이디</div>
					<div class="col-8 right">
						<input type="text" value="${sessionScope.dto.id }" readonly>
					</div>
				</div>
				<div class="row body">
					<div class="col-4 left">이름</div>
					<div class="col-8 right">
						<input type="text" value="${sessionScope.dto.name }" name="inputNAME" id="input-name" readonly>
					</div>
				</div>
				<div class="row body">
					<div class="col-4 left">전화번호</div>
					<div class="col-8 right">
						<input type="text" name="inputPHONE" id="input-phone" value="${sessionScope.dto.phone }"
							readonly>
					</div>
				</div>
				<div class="row body">
					<div class="col-4 left">이메일</div>
					<div class="col-8 right">
						<input type="text" name="inputEMAIL" id="input-email" value="${sessionScope.dto.email }"
							readonly>
					</div>
				</div>
				<div class="row body">
					<div class="col-4 left">우편번호</div>
					<div class="col-8 right">
						<input type="text" name="inputPOST" id="sample6_postcode" value="${sessionScope.dto.zipcode }"
							readonly> <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
					</div>
				</div>
				<div class="row body">
					<div class="col-4 left">주소1</div>
					<div class="col-8 right">
						<input type="text" name="inputADDRESS1" id="sample6_address"
							value="${sessionScope.dto.address1 }" readonly size="40px">
					</div>
				</div>
				<div class="row body">
					<div class="col-4 left">주소2</div>
					<div class="col-8 right">
						<input type="text" name="inputADDRESS2" id="sample6_detailAddress"
							value="${sessionScope.dto.address2 }" readonly size="40px">
					</div>
				</div>
				<div class="row body">
					<div class="col-4 left">가입날짜</div>
					<div class="col-8 right">
						<input type="text" name="joindate" value="${sessionScope.dto.join_date }" readonly>
					</div>
				</div>
				<div class="row footer" id="control">
					<div class="col-12" align="center" id="change">
						<button type="button" id="cen">취소</button>
						<button type="button" id="upd">수정</button>
					</div>
				</div>
			</div>
		</form>

		<script type="text/javascript">
			$('#cen').on('click', function () {
				location.href = '/index.jsp';
			});

			$('#upd').on('click', function () {
				$('input').prop('readonly' ,false);
				$('#cen,#upd').css('display', 'none');

				let btn1 = $('<button>');
				btn1.attr("type","button");
				btn1.text('취소');

				let btn2 = $('<button>');
				btn2.text('수정완료');
				
				btn1.on('click',function(){
					location.reload();
				});

				$('#change').append(btn1,btn2);
				
			});

			function sample6_execDaumPostcode() {
				new daum.Postcode({
					oncomplete: function (data) {
						var addr = "";
						var extraAddr = "";

						if (data.userSelectedType === "R") {
							addr = data.roadAddress;
						} else {
							addr = data.jibunAddress;
						}

						document.getElementById("sample6_postcode").value = data.zonecode;
						document.getElementById("sample6_address").value = addr;
						document.getElementById("sample6_detailAddress").focus();
					}
				}).open();
			}
		</script>
	</body>

	</html>