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
<jsp:include page="/Homejsp/home_tag.jsp" />

	<br>
	<br>
	<br>
	<br>
	<div class="head">내 정보 수정</div>

	<div>
	<br>
		<table>
			<tbody>
				<tr>
					<td style="width: 200px;padding:0px 80px 0px 30px;">
						<ul id="navi">
        					<li class="group">
           						 <div class="title">마이 페이지</div>
            						<ul class="sub">
                						<li><a href="${initParam.rootPath }/showInfo?memberId=${sessionScope.member.memberId}">내 정보</a></li>
           							 </ul>
           							 <ul class="sub">
                						<li><a href="${initParam.rootPath }/updateMyInfo.jsp">내 정보 수정</a></li>
           							 </ul>
           							 <ul class="sub">
                						<li><a href="${initParam.rootPath }/selectMine?memberId=${sessionScope.member.memberId}">내 글 관리</a></li>
           							 </ul>
           							 <ul class="sub">
                						<li><a href="${initParam.rootPath }/logout">로그아웃</a></li>
           							 </ul>
           							 <ul class="sub">
                						<li><a href="${initParam.rootPath }/deleteInfo?LoginInfo=${sessionScope.member.memberId}">탈퇴하기</a></li>
           							 </ul>
      						  </li>
   						 </ul>
					</td>
							
						
					<td style="width: 1000px;padding:0px 0px 0px 30px;"><br>
					<br>



<h1>내 정보 수정하기</h1><hr><br>

아이디 : ${sessionScope.member.memberId }<br>

고등학교 : ${sessionScope.highSchool.schoolName }

<form action="${initParam.rootPath }/updateDuplicateEmail">
	<table>
		<tr>
			<td>이메일 : </td>
			<td>
			<c:if test="${requestScope.memberEmail!=null }">
				<input type="text" name="memberEmail" value="${requestScope.memberEmail }">
				<input type="submit" value="중복확인">
			</c:if>
			<c:if test="${requestScope.memberEmail==null }">
				<c:if test="${sessionScope.member.memberEmail != null}">
					<input type="text" name="memberEmail" value="${sessionScope.member.memberEmail }">
					<input type="submit" value="중복확인">
				</c:if>
			</c:if>
			</td>
			<td>
				<c:if test="${requestScope.schoolName==null }">
					<c:if test="${sessionScope.member.schoolNo != null}">
						<input type="hidden" name="schoolNo" value="${sessionScope.member.schoolNo }">
						<input type="hidden" name="schoolName" value="${sessionScope.highSchool.schoolName }">
					</c:if>
				</c:if>
				<c:if test="${requestScope.memberId==null }">
					<c:if test="${sessionScope.member.memberId != null}">
						<input type="hidden" name="memberId" value="${sessionScope.member.memberId }">
					</c:if>
				</c:if>
				
				<c:if test="${requestScope.schoolName!=null }">
						<input type="hidden" name="schoolNo" value="${requestScope.schoolNo }">
						<input type="hidden" name="schoolName" value="${requestScope.schoolName }">
				</c:if>
				<c:if test="${requestScope.memberId!=null }">
						<input type="hidden" name="memberId" value="${requestScope.memberId }">
				</c:if>
			</td>
		</tr>
	</table>
</form>

<c:if test="${requestScope.checkEmail == true}">
	<%out.println("<script>alert('Email이 중복되었습니다.');</script>"); %>
</c:if>
<c:if test="${requestScope.checkEmail == false}">
	<%out.println("<script>alert('해당 Email은 사용가능합니다.');</script>"); %>
</c:if>

<form action="${initParam.rootPath }/updateInfo">
	<table>
		<tr>
			<td><input type="hidden" name="memberId" value="${sessionScope.member.memberId }"></td>
		</tr>
		<tr>
			<td>비밀번호 : </td>
			<td><input type="password" name="memberPassword" value="${sessionScope.member.memberPassword }"></td>
			
			<td>
				<c:if test="${requestScope.memberPassword!=null }">		
					<input type="hidden" name="memberPassword" value="${requestScope.memberPassword }">
				</c:if>
				<c:if test="${requestScope.memberPassword==null }">
					<c:if test="${sessionScope.member.memberPassword != null}">
						<input type="hidden" name="memberPassword" value="${sessionScope.member.memberPassword }">
					</c:if>
				</c:if>
			</td>
		</tr>
		<tr>
			<td>이름 : </td>
			<td><input type="text" name="memberName" value="${sessionScope.member.memberName }"></td>
		</tr>
		<tr>
			<td>
			<input type="hidden" name="schoolName" value="${sessionScope.highSchool.schoolName }">
			</td>
		</tr>
		<tr>
			<td>졸업연도 : ${sessionScope.member.graduateYear } </td>
			<td><input type="hidden" name="graduateYear" value="${sessionScope.member.graduateYear }"></td>
		</tr>
		<tr>
			<td>성별 : ${sessionScope.member.memberGender }</td>
			<td><input type="hidden" name="memberGender" value="${sessionScope.member.memberGender }"></td>
		</tr>
		<tr>
			<td>
			<input type="hidden" name="schoolNo" value="${sessionScope.member.schoolNo }">
			</td>
		</tr>
		<tr>
			<td>
				<c:if test="${requestScope.memberEmail!=null }">		
					<input type="hidden" name="memberEmail" value="${requestScope.memberEmail }">
				</c:if>
				<c:if test="${requestScope.memberEmail==null }">
					<c:if test="${sessionScope.member.memberEmail != null}">
						<input type="hidden" name="memberEmail" value="${sessionScope.member.memberEmail }">
					</c:if>
				</c:if>
			</td>
		</tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr>
			<td><input type="submit" value="수정완료"></td>
		</tr>
	</table>
</form>
<br><br><br><br><br><br>
</body>
</html>