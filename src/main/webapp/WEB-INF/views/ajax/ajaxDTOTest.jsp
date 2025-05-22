<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h2>axaxDTOTest</h2>

<script
	  src="https://code.jquery.com/jquery-3.7.1.min.js"
	  integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	  crossorigin="anonymous">
</script>

<input type="text" id="dtoMsg" placeholder="MSG 입력" />
<input type="text" id="dtoExtra" placeholder="EXTRA 입력" />
<br/><br/>

<button onclick="sendgetDTO()">GET DTO 요청 보내기</button>
<button onclick="sendPostDTO()">POST DTO 요청 보내기</button>


<div id="result" style="margin-top:20px; border:1px solid #ccc; padding:10px;"></div>

<script>
	function sendgetDTO(){
		var msg = $("#dtoMsg").val();
		var extra = $("#dtoExtra").val();
		
		$.ajax({
			type: "get",
			url: "/ajax/getDTOTest",
			data: {msg: msg, extra: extra},
			success: function(response) {
				$("#result").html(response)
			},
			error: function(xhr, status, error) {
				$("#result").html(error)
			}
		})
	};
</script>

<script>
	function sendPostDTO(){
		var msg = $("#dtoMsg").val();
		var extra = $("#dtoExtra").val();
		
		$.ajax({
			type: "post",
			url: "/ajax/postDTOTest",
			data: {msg: msg, extra: extra},
			success: function(response) {
				$("#result").html(response)
			},
			error: function(xhr, status, error) {
				$("#result").html(error)
			}
		})
	};
</script>
