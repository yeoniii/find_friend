<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/MiniProject/css/main_style.css">
<link rel="stylesheet" href="/MiniProject/css/msgbarcss.css">
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
					<td style="width: 200px;padding:0px 80px 0px 30px;">
						<ul id="navi">
        					<li class="group">
           						 <div class="title">게시판</div>
            						<ul class="sub">
                						<li><a href="${initParam.rootPath }/boardWrite.jsp">게시글 작성</a>
                						</li>
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
							
						
					<td style="width: 1000px;padding:0px 0px 0px 30px;"><br>
					<br>


<h1>게시글 정보</h1><hr><br>

	
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

<table>
	<c:forEach items="${requestScope.replyList }" var="reply">
		<c:choose>
			<c:when test="${reply.replyNo == requestScope.replyNo }">
			<tr>
				<td><form action="${initParam.rootPath }/updateReply2" method="post">
				<input type="hidden" name="replyNo" value="${reply.replyNo }">
				<input type="text" name="replyContent" value="${reply.replyContent }">
				<input type="hidden" name="memberId" value="${reply.memberId }">
				<input type="hidden" name="boardNo" value="${requestScope.board.boardNo }">
			
				<input type="submit" value="댓글수정">
				</form></td>
				<td>${reply.memberId }</td>
				<td>${reply.replyDate}</td>
			</tr>
			</c:when>
			<c:otherwise>
				<tr>	
					<td>${reply.replyContent }</td>
					<td>${reply.memberId }</td>
					<td>${reply.replyDate}</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</table>
<br><br><br><br><br><br>
</body>
</html>