<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h2>회원가입</h2>
<script
	  src="https://code.jquery.com/jquery-3.7.1.min.js"
	  integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	  crossorigin="anonymous">
</script>

<script>
function checkId() {
	var idVal = $("#memberId").val();  // 입력값 가져오기

	if (idVal.trim() === "") {
		$("#idCheckResult").html("아이디를 입력하세요.");
		return;
	}

	$.ajax({
		type: "post",
		url: "/member/checkId",
		data: { id: idVal },
		success: function(response) {
			$("#idCheckResult").html(response);
		},
		error: function() {
			$("#idCheckResult").html("서버 오류가 발생했습니다.");
		}
	});
}

</script>

<form action="/member/inputPro" method="post">
	id : 	<input type="text" name="id" id="memberId" />
			<input type="button" value="중복확인" onclick="checkId()" /><br/>
			<div id="idCheckResult" style="color: red; margin-top: 5px;"></div><br/>
	비밀번호 :	<input type="password" name="passwd" /><br/>
	이름 : 	<input type="text" name="name" /><br/>
	이메일 : 	<input type="text" name="email" /><br/>
			<input type="submit" value="회원가입" /><br/>
</form>
