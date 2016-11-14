<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${sessionScope.userId == null }">
		<div>
			<fieldset style="width: 500">
				<form action="/member/loginAuth.do" method="post">
					<b>ID</b> &nbsp; <span style="font-size: 8pt;"> <input
						type="checkbox" name="save" />아이디저장
					</span> <br /> <input type="email" required="required"
						placeholder="email형식으로 입력" name="id" /> <br /> <b>PASS</b><br />
					<input type="password" required="required" name="pass" /><br />
					<hr />
					<input type="submit" value="로그인" />
				</form>
			</fieldset>
			<a href="/user/join.do">아직회원이아니십니까?</a>
		</div>
	</c:when>
	<c:otherwise>
		<div>
			<fieldset style="width: 500">
				<ul>
					<li><a href="">내 정보</a></li>
					
				</ul>
			</fieldset>
		</div>
	</c:otherwise>
</c:choose>
