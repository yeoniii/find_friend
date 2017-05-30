<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

		<h2>받은 쪽지 내용 보기</h2><hr><br>
		<fmt:setLocale value="ko_KR"/>
		<table>
			<tr style="height:30px;"><td style="text-align:center">보낸이</td><td style="width: 100px;">${sessionScope.memName }(${sessionScope.messageInfo.sendId })</td></tr>
			<tr style="height:30px;"><td style="text-align:center">제목</td><td style="width: 100px;">${sessionScope.messageInfo.title }</td></tr>
			<tr style="height:30px;"><td style="text-align:center">받은 시간</td><td style="width: 100px;"><fmt:formatDate value="${sessionScope.messageInfo.sendDate }" type="both"/></td></tr>
			<tr style="height:50px;"><td style="text-align:center;width: 150px;">내용</td>
			<td style="width: 100px;"><textarea id="content" readonly="readonly" cols="70" rows="10" style="text-align:left">
				${sessionScope.messageInfo.content }
			</textarea></td></tr>
			</tbody>
		</table>
		</td></tr></tbody></table></div>
		<br>
		<div align="center">
		<input type="button" value="답장" onClick="location.href='/MiniProject/mini/msg/reply?receive_id=${sessionScope.messageInfo.receiveId}&&send_id=${sessionScope.messageInfo.sendId}&&rec_name=<%=URLEncoder.encode((String)session.getAttribute("memName"), "UTF-8") %>'">
		<input type="button" value="확인" onclick="location.href='/MiniProject/mini/msg/select_receive'">
		</div>
		<br><br>
	<br>
	<div id="bottom" align="center" >
		<jsp:include page="/messagejsp/search_msg.jsp" />
	</div>
	<br><br><br><br><br><br>

</body>
</html>