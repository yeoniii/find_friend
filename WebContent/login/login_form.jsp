<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	<div class="head">로그인</div>
		
	<div>
	<br>
		<table>
			<tbody>
				<tr>
					<td style="width: 200px;padding:0px 80px 0px 30px;">
						<ul id="navi">
        					<li class="group">
           						 <div class="title">로그인</div>
           							 <ul class="sub">
                						<li><a href="${initParam.rootPath }/login/findLoginInfo.jsp">ID/PW 찾기</a></li>
           							 </ul>
           							 <ul class="sub">
                						<li><a href="${initParam.rootPath }/signup/registerMember.jsp">회원가입</a></li>
           							 </ul>
      						  </li>
   						 </ul>
					</td>
						
					<td style="width: 1000px;padding:0px 0px 0px 30px;"><br>
					<br>

	
<h1>로그인</h1><hr><br>

<div>
  <form action="${initParam.rootPath }/login">
    <label for="fname">아이디</label>
    <input type="text" id="fname" name="id">
	<br>
    <label for="lname">비밀번호</label>
    <input type="password" id="lname" name="password">
    <br>
    <input type="submit" value="로그인">
  </form>
</div>

<c:if test="${requestScope.loginCheckInBoard == false}">
	<%out.println("<script>alert('로그인 후에 이용가능합니다!');</script>"); %>
</c:if>

<c:if test="${requestScope.login == false}">
	<%out.println("<script>alert('아이디 혹은 비밀번호가 틀렸습니다!');</script>"); %>
</c:if>
<br><br><br><br><br><br>
</body>
</html>