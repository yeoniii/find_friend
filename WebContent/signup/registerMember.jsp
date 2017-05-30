<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<div class="head">회원가입</div>

	<div>
		<table>
			<tbody>
				<tr>
					<td style="width: 200px;padding:0px 80px 0px 30px;">
						<ul id="navi">
        					<li class="group">
           						 <div class="title">회원가입</div>
            						<ul class="sub">
                						<li><a href="/MiniProject/login/login_form.jsp">로그인</a></li>
           							 </ul>
      						  </li>
   						 </ul>
					</td>
						
					<td style="width: 1000px;padding:0px 0px 0px 30px;"><br><br>

<h1>회원 가입</h1><hr><br>

<form action="${initParam.rootPath }/duplicateId">
	<table>
		<tr>
			<td>아이디 : </td>
			<td>
			<c:if test="${requestScope.memberId!=null }">
				<input type="text" name="memberId" value="${requestScope.memberId }">
				<input type="submit" value="중복확인">
			</c:if>
			<c:if test="${requestScope.memberId==null }">
				<input type="text" name="memberId" required placeholder="영문으로만 쓰세요">
				<input type="submit" value="중복확인">
				</c:if>
			</td>
			<td>
				<input type="hidden" name="schoolNo" value="${requestScope.schoolNo }">
				<input type="hidden" name="schoolName" value="${requestScope.schoolName }">
			</td>
		</tr>
	</table>
</form>

<form action="${initParam.rootPath }/duplicateEmail">
	<table>
		<tr>
			<td>이메일 : </td>
			<td>
			<c:if test="${requestScope.memberEmail!=null }">
				<input type="text" name="memberEmail" value="${requestScope.memberEmail }">
				<input type="submit" value="중복확인">
			</c:if>
			<c:if test="${requestScope.memberEmail==null }">
				<input type="email" name="memberEmail" required>
				<input type="submit" value="중복확인">
			</c:if>
			</td>
			<td>
				<input type="hidden" name="schoolNo" value="${requestScope.schoolNo }">
				<input type="hidden" name="schoolName" value="${requestScope.schoolName }">
				<input type="hidden" name="memberId" value="${requestScope.memberId }">
			</td>
		</tr>
	</table>
</form>

<form action="${initParam.rootPath }/getSchoolName">
	<table>
		<tr>
			<td>고등학교 : </td>
			<td>
			<c:if test="${requestScope.schoolName==null }">
				<input type="text" name="schoolName">
				<input type="submit" value="검색">
			</c:if>
			<c:if test="${requestScope.schoolName!=null }">
				<input type="text" name="schoolName" value="${requestScope.schoolName }">
				<input type="submit" value="검색">
			</c:if>
			</td>
			<td>
				<input type="hidden" name="schoolNo" value="${requestScope.schoolNo }">
				<input type="hidden" name="schoolName" value="${requestScope.schoolName }">
				<input type="hidden" name="memberId" value="${requestScope.memberId }">
				<input type="hidden" name="memberEmail" value="${requestScope.memberEmail }">
			</td>
		</tr>
	</table>
</form>

<c:if test="${requestScope.checkId == true}">
	<%out.println("<script>alert('ID가 중복되었습니다.');</script>"); %>
</c:if>
<c:if test="${requestScope.checkId == false}">
	<%out.println("<script>alert('해당 ID는 사용가능합니다.');</script>"); %>
</c:if>
<c:if test="${requestScope.checkEmail == true}">
	<%out.println("<script>alert('Email이 중복되었습니다.');</script>"); %>
</c:if>
<c:if test="${requestScope.checkEmail == false}">
	<%out.println("<script>alert('해당 Email은 사용가능합니다.');</script>"); %>
</c:if>
<c:if test="${requestScope.checkSchool == false}">
	<%out.println("<script>alert('해당 되는 학교가 없습니다.');</script>"); %>
</c:if>

<form action="${initParam.rootPath }/register">
	<table>
		<tr>
			<td><input type="hidden" name="memberId" value="${requestScope.memberId }"></td>
		</tr>
		<tr>
			<td>비밀번호 : </td>
			<td><input type="password" name="memberPassword" required></td>
		</tr>
		<tr>
			<td>이름 : </td>
			<td><input type="text" name="memberName" required></td>
		</tr>
		<tr>
			<td>졸업연도 : </td>
			<td>
			<select id="graduateYear" name="graduateYear">
				<option value="">졸업연도 선택</option>
				<%for(int i=1950; i <= 2017; i++) { %>
				<option value="<%= i %>"><%= i+"" %></option>
				<%} %>
			</select>
			</td>
		</tr>
		<tr>
			<td>성별 :</td>
			<td><input id="man" type="radio" name="memberGender" value="m" checked>
				<label for="man">남자</label>
				<input id="woman" type="radio" name="memberGender" value="w" checked>
				<label for="woman">여자</label></td>
		</tr>
		<tr>
			<td>
			<input type="hidden" name="schoolNo" value="${requestScope.schoolNo }">
			</td>
		</tr>
		<tr>
			<td>
			<input type="hidden" name="memberEmail" value="${requestScope.memberEmail }">
			</td>
		</tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr>
			<td><input type="submit" value="가입"></td>
		</tr>
	</table>
</form>
<br><br><br><br><br><br>
</body>
</html>