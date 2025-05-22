<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<form action="updatePro" method="post" name="updatePro">
	writer: <input type="text" name="writer" value="${dto.writer}" readonly> <br>
	pass: <input type="password" name="passwd" id="passwd"> <br>
	title: <input type="text" name="title" value="${dto.title}"> <br>
	contents: 
	<textarea name="content" cols="40" rows="10">${dto.content}</textarea> <br>
	<input type="hidden" name="id" value="${dto.id}">
	<input type="hidden" name="readCount" value="${dto.readCount}">
	<input type="button" value="글작성" onclick="boardUpdate()">
</form>

<script>		// 비밀번호 검증
    function boardUpdate() {
        var pass = "${dto.passwd}";
        var inputPass = document.getElementById("passwd").value;

        if (pass === inputPass) {
            document.updatePro.submit();
        } else {
            alert("비밀번호가 일치하지 않습니다.");
        }
    }
</script>