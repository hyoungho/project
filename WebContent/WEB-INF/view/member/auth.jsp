<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>사용자인증</h2>
(※인증받을 메일주소를 작성후 인증키 요청을 하세요.)
<form action="">
	<b>인증키 받을 e- mail 주소</b>
	<br/>
	<input type="email" name="" id="em" size="30"/>
	<input type="button" value="인증키요청" id="btt"/>
	<br/>
	<b>받은 인증키</b><br/>
	<input type="text" name=""  size="30"/>
	<input type="submit" value="인증 고고"/>
</form>
<script>
	document.getElementById("btt").addEventListener("click", function(){
		var url = "/member/authAjax.do?email="+document.getElementById("em").value;
		var xhr = new XMLHttpRequest();
		xhr.open("get",url,true);
		xhr.onreadystatechange = function() {
			if(xhr.readyState==4 && xhr.status==200) {
				var resp = xhr.responseText;
				if(resp == "YYYYY") {
					window.alert("인증키값이 발송되었습니다.");
				}else {
					window.alert("인증키 발송이 실패하였습니다.\n다시 시도해주십시오.");
				}
			}	
		};	
		xhr.send();
	});

</script>







