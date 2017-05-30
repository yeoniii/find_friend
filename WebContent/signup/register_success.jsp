<%@page import="mini.VO.Member"%>
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
	<div class="head">회원가입 성공</div>
	
	<div>
		<table>
			<tbody>
				<tr>
					<td style="width: 200px;padding:0px 80px 0px 30px;">
						<ul id="navi">
        					<li class="group">
           						 <div class="title">회원가입 성공</div>
            						<ul class="sub">
                						<li><a href="${initParam.rootPath }/login/login_form.jsp">로그인</a></li>
           							 </ul>
      						  </li>
   						 </ul>
					</td>
						
					<td style="width: 1000px;padding:0px 0px 0px 30px;"><br>
					<br>
	
	<h1>회원가입 정보</h1><hr><br>
	
<table>
	<tr>
		<td>아이디</td>
		<td>&nbsp;&nbsp;${sessionScope.registerInfo.memberId }</td>
	</tr>
	
	<tr>
		<td>비밀번호</td>
		<td>&nbsp;&nbsp;${sessionScope.registerInfo.memberPassword }</td>
	</tr>
	
	<tr>
		<td>이름</td>
		<td>&nbsp;&nbsp;${sessionScope.registerInfo.memberName }</td>
	</tr>
	
	<tr>
		<td>출신 고등학교</td>
		<td>&nbsp;&nbsp;${sessionScope.highSchool.schoolName }</td>
	</tr>
	
	<tr>
		<td>졸업연도</td>
		<td>&nbsp;&nbsp;${sessionScope.registerInfo.graduateYear }</td>
	</tr>
	
	<tr>
		<td>이메일</td>
		<td>&nbsp;&nbsp;${sessionScope.registerInfo.memberEmail }</td>
	</tr>
	
	<tr>
		<td>성별</td>
		<td>&nbsp;&nbsp;${sessionScope.registerInfo.memberGender }</td>
	</tr>
</table>
<%session.removeAttribute("member"); %>
<br><br><br><br><br><br>
</body>
</html>