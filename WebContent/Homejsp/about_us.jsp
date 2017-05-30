<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/MiniProject/css/main_style.css">
<link rel="stylesheet" href="/MiniProject/css/msgbarcss.css">

<style>

ul{list-style-type: square;}
body{font:나눔스퀘어 Bold;}

</style>
</head>
<body>

	<jsp:include page="../Homejsp/home_tag.jsp" />

	<br>
	<br>
	<br>
	<br>
	<div class="head">About</div>


	<div>
		<table>
			<tbody>
				<tr>
					<td style="width: 200px; padding: 0px 80px 0px 30px;" valign=top><br><br><br>
						<ul id="navi">
							<li class="group">
								<div class="title">About</div>
								<ul class="sub">
									<li><a href="/MiniProject/Homejsp/about_us.jsp">소개</a></li>
								</ul>
							</li>
						</ul>
					</td>

					<td style="width: 1000px; padding: 0px 0px 0px 30px;"><br>
						<br>


						<h1>About Us</h1>
						<hr>
						<br>

						<ul>
							<font size="6">Part.1 프로젝트 설명</font>
							<br>
							<br>
							<li>가입시 졸업한 고등학교의 이름과 졸업년도로 등록 후 그 정보를 바탕으로 동창을 찾아주는 사이트
								입니다.<br> 동창을 찾은 후 찾은 동창에게 쪽지를 주고 받을 수 있습니다.<br> 로그인 후
								게시판에 글을 작성할 수 있습니다.
							</li>
						</ul>
						<br>



						<ul>
							<font size="6">Part.2 기능 설명</font>
							<br>
							<br>
							<li>회원관리</li> - 회원가입, 로그인
							<li>동창찾기</li> - 가입 후 가입된 회원 중 검색을 통해 동창 찾기
							<li>쪽지관리</li> - 가입 후 가입된 회원을 찾아서 쪽지 보내기
							<li>게시판관리</li> - 가입 후 게시판에 글작성 가능
							<li>댓글관리</li> - 가입 후 게시판에 댓글 달기 가능
						</ul>
						<br>




						<ul>
							<font size="6">Part.3 조원소개</font>
							<br>
							<br>

							<li>강여림</li>
							<li>박세연</li>
							<li>백진현</li>
							<li>최민희</li>
						</ul><br>

						<ul>
							<font size="6">Part.4 Github 주소</font>
							<br>
							<br>
							<li><a href="https://github.com/yeoniii/find_friend">https://github.com/yeoniii/find_friend</a>
							</li>
						</ul>
						<br></td>
				</tr>
			</tbody>
		</table>
	</div><br><br><br><br>
</body>
</html>