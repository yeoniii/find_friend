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
	
	<br>
	<br>
	<br>
	<br>
	<div class="head">쪽지 관리</div>
	
	<div >
		<table>
			<tbody>
				<tr>
					<td style="width: 200px;padding:0px 80px 0px 30px;"><jsp:include
							page="/messagejsp/msg_bar.jsp" /></td>
							
							
					<td style="width: 1000px;padding:0px 0px 0px 30px;"><br>
					<br>

<h2>쪽지보내기 </h2><hr><br>
	<form action="/MiniProject/mini/msg/sendMsg" method="post">
	<table>
		<tr style="height:30px;"><td style="width: 100px;text-align:center">받는이</td><td style="width: 100px;">${requestScope.receiveMemberName }(${requestScope.receiveMemberId })</td></tr>
		<tr style="height:30px;"><td style="width: 100px;text-align:center">제목</td><td style="width: 100px;"><input type="text" name="title" size="80"></td></tr>
		<tr style="height:30px;"><td style="width: 100px;text-align:center">내용</td>
		<td style="width: 100px;"><input type="text" name="content" size="80" style="height:100px;"></td></tr>
	</table>
		
				<br>
	<div align="center">
		<input type="submit" value="전송">
		<input type="button" value="취소" onclick="location.href='/MiniProject/foundjsp/found_friend_form.jsp'">
	</div>
		<input type="hidden" name="receiveId" value="${requestScope.receiveMemberId }">
		<input type="hidden" name="sendId" value="${sessionScope.member.memberId }">
	</form>

	<%-- 	From : <%=((Member)session.getAttribute("로그인정보")).getMemberId()%>  
												로그인 정보를 session에 넣을거니까 그 값을 갖고옴. --%>
	</td></tr></tbody></table></div>
	
	<br><br><br><br><br><br>
</body>
</html>