<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h3>전체자료</h3>
총 <b>${size}</b> 개의 자료가 등록이 되어있습니다. 무료로 다운을 받으실수 있습니다.
<hr/>
<span id="rrr"></span>
인기 top 3
	<c:forEach var="t" items="${tlist }">
		<a href="#file${t.num }">
			<b>${t.title }</b>
		</a>		
	</c:forEach>
<hr/>
<c:forEach items="${list }" var="t">
	<p id="file${t.num }">
	<b>→${t.ctg } (다운로드수 : ${t.count})</b><br/>
	제공자 : ${t.uploader }
	<br/>
	파일설명 : ${t.title }<br/>
	<a href="/file/down.do?num=${t.num }">${t.filename }</a>
	<c:choose>
		<c:when test="${t.filesize < 1024*1024 }">
			(<fmt:formatNumber value="${t.filesize/1024 }"/> KB)
		</c:when>
		<c:when test="${t.filesize < 1024*1024*1024 }">
			(<fmt:formatNumber value="${t.filesize / (1024*1024) }"/> MB)
		</c:when>
		<c:otherwise>
			(<fmt:formatNumber value="${t.filesize / (1024*1024*1024) }"/> GB)	
		</c:otherwise>
	</c:choose>
	<br/>
	<br/>
	</p>
</c:forEach>
<audio autoplay="autoplay">
	<source src="/sound/alert.wav" type="audio/wav"/>
</audio>
<script>
	window.onload=function() {
		var ws = new WebSocket("ws://192.168.10.1/socket/alert.do");
		
		ws.onmessage = function() {
			// window.alert("새자료가 추가되었습니다.");
			
		}
	}

</script>











