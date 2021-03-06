<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp" %>
<%@ include file="/WEB-INF/views/common/config.jsp" %>

<!DOCTYPE html>
<html lang="${accessibility}">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width">
	<title>로그인</title>
	<link rel="shortcut icon" href="/images/favicon.ico">
	<link rel="stylesheet" href="/css/${lang}/style.css" />
	<script type="text/javascript" src="/externlib/jquery/jquery.js"></script>
	<script type="text/javascript" src="/js/${lang}/message.js"></script>
</head>
<body>
<div style="height: 100%;">
	<form:form id="loginForm" modelAttribute="loginForm" method="post" action="/login/process-login" onsubmit="return check();">
	<div style="text-align:center; padding-top: 300px;">
			<label for="user_id"><span class="icon-glyph glyph-users"></span>ID</label>
			<input type="text" id="user_id" name="user_id" maxlength="32" title="ID" placeholder="ID" required="required" />
			<label for="password"><span class="icon-glyph glyph-lock"></span>PASSWORD</label>
			<input type="password" id="password" name="password" maxlength="32" title="PWD" placeholder="PWD" required="required" />
			<input type="submit" value="Sign In" class="sign-submit" />
	</div>
	</form:form>
</div>	
<script type="text/javascript">
	$(document).ready(function () {
	});
	
	function check() {
		if ($("#user_id").val() == "") {
			alert(JS_MESSAGE["user.id.empty"]);
			$("#user_id").focus();
			return false;
		}
		
		if ($("#password").val() == "") {
			alert(JS_MESSAGE["password.empty"]);
			$("#password").focus();
			return false;
		}
		
		/* GibberishAES.size(128);	
		var encryptionPassword = GibberishAES.aesEncrypt($("#password").val(), "${TOKEN_AES_KEY}");
		alert("encryptionPassword = " + encryptionPassword + ", password = " + encodeURIComponent(encryptionPassword));
		$("#password").val(encodeURIComponent(encryptionPassword)); */
	}
	
</script>
</body>
</html>