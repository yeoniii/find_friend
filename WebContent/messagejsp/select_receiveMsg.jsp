<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
	<div>
		<table>
			<tbody>
				<tr>
					<td style="width: 200px;padding:0px 80px 0px 30px;"><jsp:include
							page="/messagejsp/msg_bar.jsp" /></td>
							
							
					<td style="width: 1000px;padding:0px 0px 0px 30px;"><br>
					<br>
						
						<h1>받은쪽지함</h1>
						<p align="right">※ 삭제시 복구할 수 없습니다</p>
						<hr><br><br>
						<table>
							<thead>
								<tr>
									<td style="width: 120px;text-align:center;">No</td>
									<td style="width: 120px;text-align:center;">보낸사람</td>
									<td style="width: 300px;text-align:center;">제목</td>
									<td style="width: 300px;text-align:center;">받은날짜</td>
									<td style="width: 70px;text-align:center;">삭제</td>
								</tr>
							</thead>
							<tbody>

								<c:choose>
									<c:when test="${not empty sessionScope.messageInfo }">
											<% int i=1; %>
										<c:forEach items="${ sessionScope.messageInfo }" var="list">
											<tr>
												<td style="text-align:center"><%=i %></td>
												<td style="text-align:center">${list.member.memberName}(${list.sendId })</td>
												<td style="text-align:center"><a
													href="/MiniProject/mini/msg/viewReceive?message_no=${list.messageNo }">${list.title }</a></td>
												<td style="text-align:center"><fmt:formatDate value="${list.sendDate }"
														type="both" /></td>
												<td style="text-align:center">
												<input type="button" value="삭제 "
													onClick="location.href='/MiniProject/mini/msg/deleteMsg?msgNo=${list.messageNo}&&location=receive'" /></td>
											<% i++; %>
											</tr>
									 </c:forEach>
									</c:when>
									<c:otherwise>
										<p>검색 결과가 없습니다.</p>
									</c:otherwise>
								</c:choose>
							</tbody>
							</table>
			</tbody>
		</table>
	</div>

	<br>
	<br>
	<br>
	<div id="bottom" align="center" >
		<jsp:include page="/messagejsp/search_msg.jsp" />
	</div>
	
	
	<br><br><br><br><br><br>
</body>
</html>