<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h2>ajaxTest.jsp</h2>
<script
	  src="https://code.jquery.com/jquery-3.7.1.min.js"
	  integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	  crossorigin="anonymous">
</script>

<input type="text" id="message" placeholder="메세지 입력 : ">
<br/>

<button onclick="sendGet()">GET 요청 보내기</button>

<div id="result">
</div>
<script>
	function sendGet() {
		var msg = $("#message").val();
		
		$.ajax({
			type: "post",
			url: "/ajax/postTest",
			data: {message: msg},
			success: function(response) {
				$("#result").html("POST Response: " + response)
			},
			error: function(xhr, status, error) {
				$("#result").html("POST ERROR: " + error)
			}
		});
	};

</script>
