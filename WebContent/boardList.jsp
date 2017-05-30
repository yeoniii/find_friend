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

</head>
<body>

	<br>
	<br>
	<br>
	<br>
	<div class="head">게시글 목록</div>

	<div>
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


					<h1>게시글 목록</h1>
					<p align="right">※ 삭제시 복구할 수 없습니다</p>
					<hr><br><br>


						<table>
							<thead>
								<tr>
									<td style="width: 50px;text-align:center;">글번호</td>
									<td style="width: 300px;text-align:center;">제목</td>
									<td style="width: 100px;text-align:center;">작성자</td>
									<td style="width: 300px;text-align:center;">작성일자</td>
								</tr>
							</thead>
							<tbody>	
											
							<c:forEach items="${requestScope.list }" var="board">
								<c:choose>
									<c:when test="${board.memberId eq requestScope.memberId && board.replyCount !=0 }">
											<tr>
												<td style="text-align:center"><a href="${initParam.rootPath }/selectInfo?boardNo=${board.boardNo }&title=${board.boardTitle }&content=${board.boardContent}&date=${board.boardDate}&memberId=${board.memberId}&boardHits=${board.boardHits}&loginMemberId=${requestScope.memberId}">${board.boardNo }</a></td>
												<td style="text-align:center"><a href="${initParam.rootPath }/selectInfo?boardNo=${board.boardNo }&title=${board.boardTitle }&content=${board.boardContent}&date=${board.boardDate}&memberId=${board.memberId }&boardHits=${board.boardHits}&loginMemberId=${requestScope.memberId}">${board.boardTitle }</a>&nbsp;<a href="${initParam.rootPath }/selectReply?boardNo=${board.boardNo }">(${board.replyCount })</a></td>
												<td style="text-align:center">${board.memberId }</td>
												<td style="text-align:center">${board.boardDate }</td>
												<td style="text-align:center"><input type="submit" onclick="board_delete('${board.boardNo }');" value="삭제"></td>
											</tr>
									</c:when>
									<c:when test="${board.memberId eq requestScope.memberId && board.replyCount == 0 }">
										<tr>
											<td style="text-align:center"><a href="${initParam.rootPath }/selectInfo?boardNo=${board.boardNo }&title=${board.boardTitle }&content=${board.boardContent}&date=${board.boardDate}&memberId=${board.memberId}&boardHits=${board.boardHits}&loginMemberId=${requestScope.memberId}">${board.boardNo }</a></td>
											<td style="text-align:center"><a href="${initParam.rootPath }/selectInfo?boardNo=${board.boardNo }&title=${board.boardTitle }&content=${board.boardContent}&date=${board.boardDate}&memberId=${board.memberId }&boardHits=${board.boardHits}&loginMemberId=${requestScope.memberId}">${board.boardTitle }</a></td>
											<td style="text-align:center">${board.memberId }</td>
											<td style="text-align:center">${board.boardDate }</td>
											<td style="text-align:center"><input type="submit" onclick="board_delete('${board.boardNo }');" value="삭제"></td>
										</tr>
									</c:when>
									<c:when test="${board.memberId ne requestScope.memberId && board.replyCount != 0 }">
										<tr>
											<td style="text-align:center"><a href="${initParam.rootPath }/selectInfo?boardNo=${board.boardNo }&title=${board.boardTitle }&content=${board.boardContent}&date=${board.boardDate}&memberId=${board.memberId}&boardHits=${board.boardHits}&loginMemberId=${requestScope.memberId}">${board.boardNo }</a></td>
											<td style="text-align:center"><a href="${initParam.rootPath }/selectInfo?boardNo=${board.boardNo }&title=${board.boardTitle }&content=${board.boardContent}&date=${board.boardDate}&memberId=${board.memberId }&boardHits=${board.boardHits}&loginMemberId=${requestScope.memberId}">${board.boardTitle }</a>&nbsp;<a href="${initParam.rootPath }/selectReply?boardNo=${board.boardNo }">(${board.replyCount })</a></td>
											<td style="text-align:center">${board.memberId }</td>
											<td style="text-align:center">${board.boardDate }</td>
											<td style="text-align:center"></td>
										</tr>
									</c:when>
									<c:otherwise>
										<tr>
											<td style="text-align:center"><a href="${initParam.rootPath }/selectInfo?boardNo=${board.boardNo }&title=${board.boardTitle }&content=${board.boardContent}&date=${board.boardDate}&memberId=${board.memberId}&boardHits=${board.boardHits}&loginMemberId=${requestScope.memberId}">${board.boardNo }</a></td>
											<td style="text-align:center"><a href="${initParam.rootPath }/selectInfo?boardNo=${board.boardNo }&title=${board.boardTitle }&content=${board.boardContent}&date=${board.boardDate}&memberId=${board.memberId }&boardHits=${board.boardHits}&loginMemberId=${requestScope.memberId}">${board.boardTitle }</a></td>
											<td style="text-align:center">${board.memberId }</td>
											<td style="text-align:center">${board.boardDate }</td>
											<td></td>
										</tr>
									</c:otherwise>
								</c:choose>
							</c:forEach>

							</tbody>
						</table>
			</tbody>
		</table>
	</div>

<br>
<br>

<div id="button" align="center">
	<form action="${initParam.rootPath }/select">
		<select name="selectMethod">
			<option value="title">제목</option>
			<option value="content">내용</option>
			<option value="writer">작성자</option>
			<input type="text" name="method">
			<input type="submit" value="검색">
		</select>
	</form>
</div>

<form name="boardDelete" action="${initParam.rootPath }/delete" method="post">
	<input type="hidden" name="boardNo">
</form>

<script type="text/javascript">
	function board_delete(boardNo) {
		if(confirm("정말 삭제하시겠습니까??")) {
			document.boardDelete.boardNo.value=boardNo;
			document.boardDelete.submit();
		} else {
			return;
		}
	}
</script>

<%-- #### 페이징 처리 ####--%>
<%-- 첫 페이지로 이동 --%>
<p align="center">
	<a href="${initParam.rootPath }/select?page=1">첫 페이지</a>
	
	<%-- 이전 페이지 그룹 처리 --%>
	<c:choose>
		<c:when test="${requestScope.pageBean.previousPageGroup }">
			<%-- 이전 페이지 그룹이 있다면 isPreviousPageGroup() 호출 --%>
			<a href="${initParam.rootPath }/select?page=${requestScope.pageBean.beginPage - 1 }">◀</a>
		</c:when>
		<c:otherwise>
			◀
		</c:otherwise>
	</c:choose>

	<%-- 현재 page가 속한 page 그룹 내의 페이지들 링크 --%>
	<c:forEach begin="${requestScope.pageBean.beginPage }" end="${requestScope.pageBean.endPage }" var="page">
		<c:choose>
			<c:when test="${requestScope.pageBean.page != page }">
				<!-- 현재 페이지가 아니라면 -->
				<a href="${initParam.rootPath }/select?page=${page}">${page }&nbsp;&nbsp;</a>
			</c:when>
			<c:otherwise>
				[${page }]&nbsp;&nbsp;  <%-- &nbsp;는 공백을 나타냄 --%>
			</c:otherwise>
		</c:choose>	
	</c:forEach>
	
	<!-- 다음페이지 그룹으로 이동. 만약에 다음페이지 그룹이 있으면 링크 처리 없으면 화살표만 나오도록 처리 -->
	<c:choose>
		<c:when test="${requestScope.pageBean.nextPageGroup }">
			<%-- isNextPageGroup() 호출 --%>
			<a href="${initParam.rootPath }/select?page=${requestScope.pageBean.endPage + 1 }">▶</a>
			<%-- getEndPage()에서 리턴된 값 넣기 --%>
		</c:when>
		<c:otherwise>
			▶
		</c:otherwise>
	</c:choose>
	
	<!-- 마지막 페이지로 이동 -->
	<a href="${initParam.rootPath }/select?page=${requestScope.pageBean.totalPage}">마지막 페이지</a>
</p>

<br><br><br><br><br><br>
</body>
</html>