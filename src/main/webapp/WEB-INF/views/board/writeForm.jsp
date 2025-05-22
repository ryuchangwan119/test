<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>글 작성</h1>

<c:if test="${write == 0}">
	<script>
        	alert('글이 작성되지 않았습니다.');
	</script>
</c:if>

<form:form action="writePro" method="post" modelAttribute="boardDTO">
	<%--  type="text": 텍스트 입력 필드, path="writer": BoardDTO 객체의 writer 프로퍼티와 바인딩 , 
	required="required": HTML5의 필수 입력 필드로 지정 --%>
	작성자:	<form:input type="text" path="writer" required="required"/>
			<form:errors path="writer" cssClass="error" /><br/>
	
	비밀번호: <form:input type="password" path="passwd" required="required"/>
		 	<form:errors path="passwd" cssClass="error"/><br/>
	
	제목: 	<form:input type="text" path="title" required="required"/>
			<form:errors path="title" cssClass="error"/><br/>
	
	본문: 	<form:textarea type="text" path="content" required="required" rows="10" cols="40"/>
			<form:errors path="content" cssClass="error"/><br/>
	
      		<input type="submit" value="글작성"/>
</form:form>


