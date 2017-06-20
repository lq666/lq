<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script>
	onload = function(){
		setTimeout(changetime,1000);
	}
	
	function changetime(){
		var count = document.getElementById("mytime").innerHTML;
		if(count>0){
			count--;
			document.getElementById("mytime").innerHTML = count;
			if(count>0){
				setTimeout(changetime,1000);
			}
		}
	}
</script>
<h2>${msg },<span id="mytime">2</span>秒之后跳转主页</h2>
<%
String path = request.getContextPath();
String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
response.setHeader("Refresh", "2;URL="+basepath);
%>