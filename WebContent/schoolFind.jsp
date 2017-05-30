<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/MiniProject/css/main_style.css">
<link rel="stylesheet" href="/MiniProject/css/msgbarcss.css">
<style type="text/css">
table, td {
	border : 1px solid gray;
}
table {
	border : 1px solid gray;
	width : 900px;
}
td{		<%-- 박스칸과 내용의 간격(안쪽공간)--%>
	padding: 15px;
}
</style>
</head>
<body>
<jsp:include page="/Homejsp/home_tag.jsp" />

	<br>
	<br>
	<br>
	<br>
	<div class="head">학교 목록</div>

				

<h1 align="center">학교 목록</h1><hr><br>

<table align="center">
	<thead>
		<tr>
			<td>학교 번호</td>
			<td>학교 이름</td>
			<td>지번 주소</td>
			<td>도로명 주소</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${requestScope.schoolList }" var="highSchool">
			<tr>
				<td>${highSchool.schoolNo }</td>
				<td><a href="${initParam.rootPath }/forwardSchoolNo?schoolNo=${highSchool.schoolNo}&schoolName=${highSchool.schoolName}&memberId=${param.memberId}&memberEmail=${param.memberEmail}">${highSchool.schoolName}</a></td>
				<td>${highSchool.address }</td>
				<td>${highSchool.roadAddress }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<br><br><br><br><br><br>
</body>
</html>