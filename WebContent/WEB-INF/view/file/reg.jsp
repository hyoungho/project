<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 
	form을 이용해서 
	클라이언트로부터 전달받고자 하는 내용이 파일(문자 기반이)이 있다면, 설정을 바꿔줘야 한다.
-->
<h3>자료등록</h3>
<hr/>
<div style="line-height: 40px;">
<form action="/file/upload.do" method="post" enctype="multipart/form-data">
	카테고리 # <select name="ctg" style="font-size: 10pt;">
		<option value="util">유틸리티</option>
		<option value="game">게임</option>
		<option value="media">멀티미디어</option>
	</select>
	<br/>
	제목 # <input type="text" name="title" size="30"/> <br/>
	첨부파일 # <input type="file" name="file"/> <br/>
	<input type="submit" value="등록"/>
</form>
</div>


