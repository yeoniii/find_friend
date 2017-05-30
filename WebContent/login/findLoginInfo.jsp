<%@ page contentType="text/html;charset=UTF-8"%>
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

	<br>
	<br>
	<br>
	<br>
	<div class="head">ID/PW 찾기</div>

	<div>
	<br>
		<table>
			<tbody>
				<tr>
					<td style="width: 200px;padding:0px 80px 0px 30px;">
						<ul id="navi">
        					<li class="group">
           						 <div class="title">ID/PW 찾기</div>
            						<ul class="sub">
                						<li><a href="${initParam.rootPath }/login/findId.jsp">아이디 찾기</a></li>
           							 </ul>
           							 <ul class="sub">
                						<li><a href="${initParam.rootPath }/login/findPwd.jsp">비밀번호 찾기</a></li>
           							 </ul>
           							 <ul class="sub">
                						<li><a href="${initParam.rootPath }/login/login_form.jsp">로그인</a></li>
           							 </ul>
      						  </li>
   						 </ul>
					</td>
						
					<td style="width: 1000px;padding:0px 0px 0px 30px;"><br>
					<br>

	<h1 align="center">ID와 비밀번호를 찾으실 수 있습니다.</h1>
	<br><br><br>
	<br><br><br>
</body>
</html>