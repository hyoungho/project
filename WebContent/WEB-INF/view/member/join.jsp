<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form action="/member/confirm.do" method="post" onsubmit="return valueCheck()">
	<b>* *기본정보 입력* *</b><br /> <b>ID</b> <input type="email"
		required="required" name="id" id="id"/>&nbsp;&nbsp;<span id="rst"></span><br /> 
	<b>PASS</b> <input
		type="password" required="required" name="pass" /><br /> <b>NAME</b>
	<input type="text" required="required" name="name" /><br /> <input
		type="submit" value="회원가입" />
</form>
<script>
	var check=false;
	
	function valueCheck(){
		if(check==false) {
			return false;
		}
	}
	
	
	
	document.getElementById("id").addEventListener("blur", function(){
		var xhr = new XMLHttpRequest();
		var url = "/member/check.do?id="+document.getElementById("id").value;
			xhr.open("get", url, true);
			xhr.onreadystatechange=function() {
				if(xhr.readyState==4&&xhr.status==200) {
					var rst = xhr.responseText;
					if(rst=="YES") {
						check = true;
						document.getElementById("rst").innerHTML =
							"<b style='color:green;'>멋진 아이디입니다.</b>";
					}else {
						check = false;
						document.getElementById("rst").innerHTML =
							"<b style='color:red;'>이미 사용중인 아이디입니다.</b>";
					}
				}
			};
		xhr.send();
 	});
	
	


</script>













