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

<style>
a {
    color: red;
}
</style>

	<br>
	<br>
	<br>
	<br>
	<div class="head">아이디 찾기</div>

<c:if test="${requestScope.findIdMsg == false}">
	<%out.println("<script>alert('해당 되는 회원이 없습니다.');</script>"); %>
</c:if>

	<div>
	<br>
	<br>
		<table>
			<tbody>
				<tr>
					<td style="width: 200px;padding:0px 80px 0px 30px;">
						<ul id="navi">
        					<li class="group">
           						 <div class="title">아이디 찾기</div>
            						<ul class="sub">
                						<li><a href="/MiniProject/login/login_form.jsp">로그인</a></li>
           							 </ul>
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

	
<h1>아이디 찾기</h1><hr><br>

<div>
  <form action="${initParam.rootPath }/findLoginInfo">
    <label>이메일</label>
    <input type="email" name="memberEmail">

	<input type="hidden" name="infoKind" value="findId">
	<input type="submit" value="찾기">
  </form>
</div>

<p>
	<c:if test="${requestScope.resultIdByFinding != null}"> 
			찾으시는 아이디는 <a>${requestScope.resultIdByFinding }</a> 입니다.
	</c:if>
</p>
<br><br><br><br><br><br>
</body>
</html>