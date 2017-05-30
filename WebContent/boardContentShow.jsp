<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<div class="head">게시글 정보</div>

	<div>
		<br>
		<table>
			<tbody>
				<tr>
					<td style="width: 200px; padding: 0px 80px 0px 30px;" >
						<ul id="navi">
							<li class="group">
								<div class="title">게시판</div>
								<ul class="sub">
									<li><a href="${initParam.rootPath }/boardWrite.jsp">게시글
											작성</a></li>
								</ul>
								<ul class="sub">
									<li><a href="${initParam.rootPath }/select">게시글 목록</a></li>
								</ul>
								<ul class="sub">
									<li><a href="${initParam.rootPath }/selectMine">내 게시글</a></li>
								</ul>
							</li>
						</ul>
					</td>


					<td style="width: 1000px; padding: 0px 0px 0px 30px;"><br>
						<br>


						<h1>게시글 정보</h1>
						<hr>
						<br> <c:choose>
							<c:when test="${sessionScope.board == null }">
								<table>
									<tr>
										<td>제목</td>
										<td>${requestScope.board.boardTitle }</td>
									</tr>
									<tr>
										<td>작성자</td>
										<td>${requestScope.board.memberId }</td>
									</tr>
									<tr>
										<td>내용</td>
										<td>${requestScope.board.boardContent }</td>
									</tr>
									<tr>
										<td>작성일자</td>
										<td>${requestScope.board.boardDate }</td>
									</tr>
									<tr>
										<td>조회수</td>
										<td>${requestScope.board.boardHits }</td>
									</tr>
								</table>
							</c:when>
							<c:otherwise>
								<table>
									<tr>
										<td>제목</td>
										<td>${sessionScope.board.boardTitle }</td>
									</tr>
									<tr>
										<td>작성자</td>
										<td>${sessionScope.board.memberId }</td>
									</tr>
									<tr>
										<td>내용</td>
										<td>${sessionScope.board.boardContent }</td>
									</tr>
									<tr>
										<td>작성일자</td>
										<td>${sessionScope.board.boardDate }</td>
									</tr>
									<tr>
										<td>조회수</td>
										<td>${sessionScope.board.boardHits }</td>
									</tr>
								</table>
							</c:otherwise>
						</c:choose> <c:choose>
							<c:when
								test="${empty requestScope.loginMemberId && empty sessionScope.board.memberId }">

								<form action="${initParam.rootPath }/insertReply" method="post">
									<input type="text" name="replyContent"
										placeholder="상대방 욕설 및 비방 금지"> <input type="hidden"
										name="boardNo" value="${requestScope.board.boardNo }">
									<input type="hidden" name="loginMemberId"
										value="${requestScope.loginMemberId}"> <input
										type="submit" value="댓글등록"><br>
								</form>
							</c:when>
							<c:when test="${sessionScope.board.memberId != null}">
								<form action="${initParam.rootPath }/insertReply" method="post">
									<input type="text" name="replyContent"
										placeholder="상대방 욕설 및 비방 금지"> <input type="hidden"
										name="boardNo" value="${sessionScope.board.boardNo }">
									<input type="hidden" name="loginMemberId"
										value="${sessionScope.memberId}"> <input type="submit"
										value="댓글등록"><br>
								</form>
							</c:when>
							<c:when test="${requestScope.loginMemberId != null}">
								<form action="${initParam.rootPath }/insertReply" method="post">
									<input type="text" name="replyContent"
										placeholder="상대방 욕설 및 비방 금지"> <input type="hidden"
										name="boardNo" value="${requestScope.board.boardNo }">
									<input type="hidden" name="loginMemberId"
										value="${requestScope.loginMemberId}"> <input
										type="submit" value="댓글등록"><br>
								</form>
							</c:when>
						</c:choose>

						<table>
							<c:choose>
								<c:when test="${sessionScope.reply != null }">
									<c:forEach items="${sessionScope.reply }" var="reply">
										<c:choose>
											<c:when
												test="${reply.memberId eq sessionScope.loginMemberId }">
												<tr>
													<td>${reply.replyContent }</td>
													<td>${reply.memberId }</td>
													<td>${reply.replyDate}</td>
													<td><form action="${initParam.rootPath }/updateReply"
															method="post">
															<input type="hidden" name="replyNo"
																value="${reply.replyNo }"> <input type="hidden"
																name="boardNo" value="${sessionScope.board.boardNo }">
															<input type="submit" value="댓글수정">
														</form></td>
													<td><input
														onclick="Javascript:button_event('${reply.replyNo }', '${sessionScope.board.boardNo }');"
														type="button" value="댓글삭제"></td>
												</tr>
											</c:when>
											<c:otherwise>
												<tr>
													<td>${reply.replyContent }</td>
													<td>${reply.memberId }</td>
													<td>${reply.replyDate}</td>
													<td></td>
													<td></td>
												</tr>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<c:forEach items="${requestScope.reply }" var="reply">
										<c:choose>
											<c:when
												test="${reply.memberId eq requestScope.loginMemberId }">
												<tr>
													<td>${reply.replyContent }</td>
													<td>${reply.memberId }</td>
													<td>${reply.replyDate}</td>
													<td><form action="${initParam.rootPath }/updateReply"
															method="post">
															<input type="hidden" name="replyNo"
																value="${reply.replyNo }"> <input type="hidden"
																name="boardNo" value="${requestScope.board.boardNo }">
															<input type="submit" value="댓글수정">
														</form></td>
													<td><input
														onclick="Javascript:button_event('${reply.replyNo }', '${requestScope.board.boardNo }');"
														type="button" value="댓글삭제"></td>
												</tr>
											</c:when>
											<c:otherwise>
												<tr>
													<td>${reply.replyContent }</td>
													<td>${reply.memberId }</td>
													<td>${reply.replyDate}</td>
													<td></td>
													<td></td>
												</tr>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</c:otherwise>
							</c:choose>
						</table>

						<form name="replyDelete"
							action="${initParam.rootPath }/deleteReply" method="post">
							<input type="hidden" name="replyNo"> <input type="hidden"
								name="boardNo">
						</form> <c:choose>
							<c:when test="${sessionScope.board.memberId != null }">
								<form action="${initParam.rootPath }/update">
									<input type="hidden" name="boardNo"
										value="${sessionScope.board.boardNo }"> <input
										type="hidden" name="title"
										value="${sessionScope.board.boardTitle }"> <input
										type="hidden" name="memberId"
										value="${sessionScope.board.memberId}"> <input
										type="hidden" name="content"
										value="${sessionScope.board.boardContent}"> <input
										type="hidden" name="date"
										value="${sessionScope.board.boardDate}"> <input
										type="submit" value="수정">
								</form>
							</c:when>
							<c:when
								test="${sessionScope.board.memberId == requestScope.loginMemberId}">
								<form action="${initParam.rootPath }/update">
									<input type="hidden" name="boardNo"
										value="${requestScope.board.boardNo }"> <input
										type="hidden" name="title"
										value="${requestScope.board.boardTitle }"> <input
										type="hidden" name="memberId"
										value="${requestScope.board.memberId}"> <input
										type="hidden" name="content"
										value="${requestScope.board.boardContent}"> <input
										type="hidden" name="date"
										value="${requestScope.board.boardDate}"> <input
										type="submit" value="수정">
								</form>
							</c:when>
						</c:choose> <script type="text/javascript">
							function button_event(replyNo, boardNo) {
								if (confirm("정말 삭제하시겠습니까??") == true) {
									document.replyDelete.replyNo.value = replyNo;
									document.replyDelete.boardNo.value = boardNo;
									document.replyDelete.submit();
								} else {
									return;
								}
							}
						</script> 
						</td></tr></tbody></table></div>
						<br>
					<br>
					<br>
					<br>
					<br>
					<br>
</body>
</html>