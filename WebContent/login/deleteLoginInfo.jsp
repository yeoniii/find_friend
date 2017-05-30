<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${requestScope.deleteMsg == false}">
	<%out.println("<script>alert('탈퇴되었습니다.');</script>"); %>
</c:if>

</body>
</html>