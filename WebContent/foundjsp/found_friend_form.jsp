<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	<c:choose>
	<c:when test="${empty sessionScope.member.memberId }">
		<br><br><br><br><br><br><br><br><br><br>
			<h1 align="center">로그인이 필요한 서비스입니다.</h1>
			<br><br><br>
			<div align="center">
				<input type="button" value="로그인" onClick="location.href='/MiniProject/login/login_form.jsp'"/>
			</div>
	</c:when>
	<c:otherwise>
	
	<br>
	<br>
	<br>
	<br>
	<div class="head">동창 찾기</div>
	
	
	<div>
		<table>
			<tbody>
				<tr>
					<td style="width: 200px;padding:0px 80px 0px 30px;"><jsp:include
							page="/messagejsp/find_bar.jsp" /></td>
							
							
					<td style="width: 1000px;padding:0px 0px 0px 30px;"><br>
					<br>
	
<h1>동창 찾기 검색창</h1><hr><br>

<form action="/MiniProject/mini/mem/found_member" method="post">
	<table>
		<tr style="height:30px;"><td style="text-align:center">학교이름</td><td style="width: 100px;"><input type="text" name="schoolName" size="40"></td></tr>
		<tr style="height:30px;"><td style="width: 100px;text-align:center">이름</td><td style="width: 100px;"><input type="text" name="memberName" size="40"></td></tr>
		<tr style="height:30px;"><td style="width: 100px;text-align:center">졸업년도</td><td style="width: 100px;"><select name="graduateYear">
		<c:forEach begin="1950" end="2017" var="no">
			<option>${no}</option>
			</c:forEach>
		</select></td></tr>
		<tr>
		<tr style="height:30px;"><td style="width: 100px;text-align:center">성별</td><td style="width: 100px;">
		<label>남성<input type="radio" name="memberGender" value="m" id="radio_m" checked></label>
		<label>여성<input type="radio" name="memberGender" value="w" id="radio_w"></label></td></tr>
	</table><br><br>
	<div align="left">		
		<input type="submit" value="검색" onclick="alert('검색합니다');">
	</div>
</form>

</td></tr></tbody></table></div>
</c:otherwise>
</c:choose> 
<br><br><br><br><br><br>

</body>
</html>