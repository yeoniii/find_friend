<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/MiniProject/css/main_style.css">
<link rel="stylesheet" href="/MiniProject/css/msgbarcss.css">
</head>
<body>

	<jsp:include page="../Homejsp/home_tag.jsp" />
	
	
		<br><br><br><br><br><br><br><br><br><br>
			<h1 align="center">로그인이 필요한 서비스입니다.</h1>
			<br><br><br>
		<div align="center">
				<input type="button" value="로그인" onClick="location.href='/MiniProject/login/login_form.jsp'"/>
			</div>

		<br><br><br><br><br><br>
</body>
</html>