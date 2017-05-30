<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>메인화면</h1>
<a href="${initParam.rootPath }/login/login_form.jsp">로그인</a>
<a href="${initParam.rootPath }/signup/registerMember.jsp">회원가입</a>
<a href="${initParam.rootPath }/">동창 찾기</a>
<a href="${initParam.rootPath }/boardMenu.jsp">자유게시판</a>

<c:if test="${requestScope.deleteMsg == false}">
	<%out.println("<script>alert('탈퇴되었습니다.');</script>"); %>
</c:if>

</body>
</html>