<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script
	  src="https://code.jquery.com/jquery-3.7.1.min.js"
	  integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	  crossorigin="anonymous">
</script>

<button onclick="sendGetDTOList()">GET DTO List 요청 보내기</button>
<button onclick="sendPostDTOList()">POST DTO List 요청 보내기</button>
<br><br>
<div id="result" style="margin-top:20px;"></div>

<script>
	function sendGetDTOList() {
		$.ajax({
			type: "get",
			url: "/ajax/getDTOList",
			dataType: "json",
			success: function(response) {
				var output = "";
				for(var i = 0; i < response.length; i++) {
					output += "MSG : " + response[i].msg + "/ EXTRA : " + response[i].extra + "<br/>"
				}
				$("#result").html(output);
			},
			error : function() {
				$("#result").html(error);
			}
		});
	};

</script>

















