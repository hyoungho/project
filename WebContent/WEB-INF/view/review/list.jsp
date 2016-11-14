<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>방명록</h3>
<c:forEach var="i" begin="1" end="${size }">
	<c:choose>
		<c:when test="${current == i }">
		<b>${i }</b>
		</c:when>
		<c:otherwise>
		<a href="/review/list.do?p=${i }">${i }</a>
		</c:otherwise>
	</c:choose>
</c:forEach>
<hr/>
<c:forEach items="${data }" var="obj">
	<b>${obj.num }</b> 남긴이:${obj.writer }  (좋아요:${obj.good }) | ${obj.writedate }
	<br/>
<pre style="font-family: 맑은 고딕; font-size: 9pt;">
${obj.memo }
</pre>
	<hr/>
	
</c:forEach>