<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>:: Dear My Friend ::</title>
<link rel="stylesheet" href="/MiniProject/css/main_style.css">

<style>
.homeview {
    padding-bottom: 20px;
    padding-left: 188px;
    background:url(http://data.whicdn.com/images/191101943/original.gif); 
    background-size: 1100px 500px;
    width:1100px;
    height:500px;
    background-repeat: no-repeat;
    background-position: left 190px bottom 20px;
}
#first{
font-family : Elephant;
font-size : 35px;
font-style : italic;
color :   #5353c6;
text-shadow:3px 3px 3px 	 #c6c6ec;

}

#sec{
font-family : Elephant;
font-size : 30px;
font-style : italic;
color :   #5353c6;
text-shadow:3px 3px 3px 	 #c6c6ec;
}

#third, #four{
font-family : 휴먼아미체;
font-size : 20px;
font-style : italic;
}

#fif{
font-family : Segoe Script;
font-size : 15px;
}


</style>

</head>
<body>

	
 	<jsp:include page="./home_tag.jsp"/> 
 	<br>
	    
	 <div class="homeview">
		<br><br><br><br><br><br><br><br>
		<p align="center"><font id="first" >I'm so happy because today I found my friends</font></p>
		<p align="center"><font id="sec">They're in my head</font></p>
		<br>
		<p align="center"><font id="third">나는 오늘 친구들을 찾아서 너무 행복하다. 그들은 내 머리속에 있다.</font></p>
		<p align="center"><font id="four">커트 코베인</font>&nbsp;&nbsp;&nbsp;<font id="fif">Kurt Cobain</font></p>
	 </div>
	 
	 <c:if test="${requestScope.deleteMsg == false}">
	<%out.println("<script>alert('탈퇴되었습니다.');</script>"); %>
</c:if>
	 
</body>
</html>
