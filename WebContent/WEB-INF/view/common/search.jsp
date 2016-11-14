<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div align="center">
<form>
	<b style="font-size: 20pt;">SAAN</b>&nbsp;&nbsp;
	<input type="text" size="25" style="font-size: 20pt;" list="srchrst" id="srch"/>
	<datalist id="srchrst">
	</datalist>
</form>
</div>
<script>
	document.getElementById("srch").addEventListener("keyup", function(){
		var xhr = new XMLHttpRequest();
		/*
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		*/
		var url = "/file/searchJSON.do?q="+document.getElementById("srch").value;
		xhr.open("get", url, true);
		xhr.onreadystatechange = function() {
			if(xhr.readyState==4 && xhr.status==200) {
			//	var html = xhr.responseText;
			//	document.getElementById("srchrst").innerHTML = html;
				var list = JSON.parse(xhr.responseText);
				var html = "";
				console.log(xhr.responseText);
				console.log(list.length);
				for(var i=0; i<list.length; i++) {
					console.log(list[i].title);
					html+="<option>"+list[i].title+"</option>";
				}
				document.getElementById("srchrst").innerHTML = html;
				console.log(html);
			}
		}
		xhr.send();
		
	});

</script>


