<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${not empty errorMessage}">
	<h2>${errorMessage}</h2>
</c:if>

<c:if test="${not empty dto}">
	<table border="1" width="500">
		<tr>
			<th>번호</th>
	    		<td>${dto.id}</td>
		</tr>
	  	<tr>
			<th>작성자</th>
			<td>${dto.writer}</td>
	  	</tr>
	  	<tr>
			<th>제목</th>
			<td>${dto.title}</td>
	  	</tr>
	  	<tr>
			<th>내용</th>
			<td>${dto.content}</td>
	  	</tr>
	  	<tr>
			<th>작성일</th>
			<td><fmt:formatDate value="${dto.boardWriteTime}" pattern="yyyy-MM-dd"/></td>
	  	</tr>
	  	<tr>
			<th>수정일</th>
			<td><fmt:formatDate value="${dto.boardUpdateTime}" pattern="yyyy-MM-dd"/></td>
	  	</tr>
	  	<tr>
			<th>조회수</th>
			<td>${dto.readCount}</td>
	  </tr>
	</table>
</c:if>

<button onclick="location.href='update?id=${dto.id}'">글수정</button>
<button onclick="location.href='delete?id=${dto.id}'">글삭제</button>