<%@page import="java.net.URLEncoder"%>
<%@page import="mini.VO.Member"%>
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
<style type="text/css">
a:link{
	/*방문하지 않은 링크 설정.*/
	text-decoration:none; /*밑줄 안나오도록 처리.*/
	color:green;
}
a:visited{
	/*방문한 링크 설정*/
	text-decoration: none;
	color:green;
}
a:hover{
	/*마우스 포인터가 올라간 시점의 설정.*/
	text-decoration: underline;
	color:red;
}
a:active{
	/*마우스를 링크에 클릭하는 시점*/
	color:blue;
}
#result, #tr, #td {
	border:1px solid black;
	padding: 10px;
}
#result {
	border-collapse: collapse;
}
</style>
<body>

<jsp:include page="../Homejsp/home_tag.jsp" />

<br>
	<br>
	<br>
	<br>
	<div class="head">동창 찾기</div>
	
	
	<div>
		<table id="all">
			<tbody>
				<tr>
					<td style="width: 200px;padding:0px 80px 0px 30px;"><jsp:include
							page="/messagejsp/find_bar.jsp" /></td>
							
							
					<td style="width: 1000px;padding:0px 0px 0px 30px;"><br>
					<br>
	

<h1>검색 결과</h1><hr><br><br>
<div align="center">
<table id="result">
	<thead>
		<tr id="tr">
			<td id="td" style="width: 120px;text-align:center">이름</td>
			<td id="td" style="width: 120px;text-align:center">학교</td>
			<td id="td" style="width: 120px;text-align:center">성별</td>
			<td id="td" style="width: 120px;text-align:center">쪽지</td>
		</tr>
	</thead>
	<tbody>
<c:forEach items="${requestScope.foundList}" var="member">
	<tr id="tr">
		<td id="td">${member.memberName }</td>
		<td id="td">${member.highSchool.schoolName }</td>
		<td id="td">${member.memberGender }</td>
		<td id="td"><input type="button" value="쪽지" onClick="location.href='/MiniProject/mini/msg/passInfo?id=${member.memberId}&&name=<%=URLEncoder.encode(((Member)pageContext.getAttribute("member")).getMemberName(), "UTF-8")%>'"></td>

	</tr>
</c:forEach>
	</tbody>
</table>

<p>
<%-- ####################################
										페이징 처리
###################################### --%>

						<!-- 첫페이지로 이동 -->
<a href="/MessageProject/mini/mem/found_member?page=1">첫페이지</a>

<!-- 
			이전 페이지 그룹 처리
			이전 페이지 그룹이 있으면 링크 처리하고 없으면 화살표만 나오도록
-->
		 <c:choose >
			<c:when test="${requestScope.pageBean.previousPageGroup }">
			<a href="/MiniProject/mini/mem/found_member?page="${requestScope.pageBean.beginPage-1 }>◀</a>
		 </c:when>
		 <c:otherwise>
			 ◀
		 </c:otherwise>
		 </c:choose>
		 
<!-- 	
			현재 page가 속한 page 그룹내의 페이지들 링크
			현재 pageGroup의 시작page~끝page
			현재 page가 현재페이지이면 링크 처리를 하지 않고 page가 현재 페이지가 아니라면 링크처리
 -->
 	<c:forEach begin="${requestScope.pageBean.beginPage }" end="${requestScope.pageBean.endPage }" var="page">
		<c:choose>
			<c:when test="${requestScope.pageBean.page!=page }">
				<!-- 현재 페이지가 아니라면 -->
			<a href="/MiniProject/mini/mem/found_member?page=${page}">${page }</a>
			</c:when>
			<c:otherwise>
				&nbsp;[${page }]&nbsp;
			</c:otherwise>
		</c:choose>
	</c:forEach>
 
<!-- 
			다음페이지 그룹으로 이동
			만약에 다음페이지 그룹이 있으면 링크 처리 없으면 화살표만 나오도록 처리
-->
	
	<c:choose>
		<c:when test="${requestScope.pageBean.nextPageGroup }">
			<a href="/MiniProject/mini/mem/found_member?page=${requestScope.pageBean.endPage+1}">▶</a>
		</c:when>
		<c:otherwise>
			▶
		</c:otherwise>
	</c:choose>
		 
						<!-- 마지막 페이지로 이동 -->

<a href="/MiniProject/mini/mem/found_member?page=${requestScope.pageBean.totalPage}">마지막페이지</a>

</p>
</div>
</td></tr></tbody></table></div>

<br><br><br><br><br><br>

</body>
</html>