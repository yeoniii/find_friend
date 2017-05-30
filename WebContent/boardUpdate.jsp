<%@ page contentType="text/html;charset=UTF-8"%>
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
	<div class="head">게시글 수정</div>
	
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

	
	
<h1>게시글 수정</h1><hr><br>

<form action="${initParam.rootPath }/update2">
	제목 : <input type="text" name="boardTitle" value="${requestScope.board.boardTitle }" required><br>
	내용<br>
	 <textarea rows="20" cols="100" name="boardContent" required>${requestScope.board.boardContent }</textarea> 
	 <input type="hidden" name="boardNo" value="${requestScope.board.boardNo }">
	 <input type="hidden" name="boardDate" value="${requestScope.board.boardDate }">
	 <input type="hidden" name="boardHits" value="${requestScope.board.boardHits }">
	 <input type="hidden" name="memberId" value="${requestScope.board.memberId }">
	<p>
	<input type="submit" value="수정완료">
	</p>
</form>

</body>
</html>