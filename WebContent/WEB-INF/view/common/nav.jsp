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
						type="checkbox" name="save" />���̵�����
					</span> <br /> <input type="email" required="required"
						placeholder="email�������� �Է�" name="id" /> <br /> <b>PASS</b><br />
					<input type="password" required="required" name="pass" /><br />
					<hr />
					<input type="submit" value="�α���" />
				</form>
			</fieldset>
			<a href="/user/join.do">����ȸ���̾ƴϽʴϱ�?</a>
		</div>
	</c:when>
	<c:otherwise>
		<div>
			<fieldset style="width: 500">
				<ul>
					<li><a href="">�� ����</a></li>
					
				</ul>
			</fieldset>
		</div>
	</c:otherwise>
</c:choose>
