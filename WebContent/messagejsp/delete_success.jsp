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


	<h1>쪽지 삭제</h1><hr><br>
	<p align="center">
삭제 되었습니다.
</p></td></tr></tbody></table></div>
		<input type="button" value="확인" onclick="location.href='/MiniProject/mini/msg/select_receive'">

	<br>
	<br>
	<br>
	<div id="bottom" align="center" >
		<jsp:include page="/messagejsp/search_msg.jsp" />
	</div>
	<br><br><br><br><br><br>
</body>
</html>