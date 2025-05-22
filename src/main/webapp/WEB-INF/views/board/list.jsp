<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h1>게시글 목록</h1>

<table border="1" width="700">
    <thead>
        <tr>
            <th>번호</th>
            <th>작성자</th>
            <th>제목</th>
            <th>작성일</th>
            <th>조회수</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="board" items="${boardList}">
            <tr>
                <td>${board.id}</td>
                <td>${board.writer}</td>
                <td><a href="listDetail?id=${board.id}" style="text-decoration: none; color: black;">${board.title}</a></td>
                <td><fmt:formatDate value="${board.boardWriteTime}" pattern="yyyy-MM-dd"/></td>
                <td>${board.readCount}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>