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
<jsp:include page="/Homejsp/home_tag.jsp" />

	<br>
	<br>
	<br>
	<br>
	<div class="head">회원정보 수정 성공</div>

	<div>
	<br>
	<br>
		<table>
			<tbody>
				<tr>
					<td style="width: 200px;padding:0px 80px 0px 30px;">
						<ul id="navi">
        					<li class="group">
           						 <div class="title">마이 페이지</div>
            						<ul class="sub">
                						<li><a href="${initParam.rootPath }/showInfo?memberId=${sessionScope.member.memberId}">내 정보</a></li>
           							 </ul>
           							 <ul class="sub">
                						<li><a href="${initParam.rootPath }/updateMyInfo.jsp">내 정보 수정</a></li>
           							 </ul>
           							 <ul class="sub">
                						<li><a href="${initParam.rootPath }/selectMine?memberId=${sessionScope.member.memberId}">내 글 관리</a></li>
           							 </ul>
           							 <ul class="sub">
                						<li><a href="${initParam.rootPath }/logout">로그아웃</a></li>
           							 </ul>
           							 <ul class="sub">
                						<li><a href="${initParam.rootPath }/deleteInfo?LoginInfo=${sessionScope.member.memberId}">탈퇴하기</a></li>
           							 </ul>
      						  </li>
   						 </ul>
					</td>
							
						
					<td style="width: 1000px;padding:0px 0px 0px 30px;"><br>
					<br>

	<h1>수정 정보</h1><hr><br>

<table>
	<tr>
		<td>회원 아이디</td>
		<td>${sessionScope.member.memberId }</td>
	</tr>
	
	<tr>
		<td>회원 비밀번호</td>
		<td>${sessionScope.member.memberPassword }</td>
	</tr>
	
	<tr>
		<td>회원 이름</td>
		<td>${sessionScope.member.memberName }</td>
	</tr>
	
	<tr>
		<td>출신 고등학교</td>
		<td>${sessionScope.highSchool.schoolName }</td>
	</tr>
	
	<tr>
		<td>졸업연도</td>
		<td>${sessionScope.member.graduateYear }</td>
	</tr>
	
	<tr>
		<td>회원 이메일</td>
		<td>${sessionScope.member.memberEmail }</td>
	</tr>
	
	<tr>
		<td>회원 성별</td>
		<td>${sessionScope.member.memberGender }</td>
	</tr>
</table>
<br><br><br><br><br><br>
</body>
</html>