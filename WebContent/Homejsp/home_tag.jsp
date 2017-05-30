<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<img src="https://1.bp.blogspot.com/-UB-HMTc4oms/WSkMj2wJ9dI/AAAAAAAAACU/BeiIX9SYTtYScvu9xUc8JCNwuwSrsFGKwCLcB/s320/logo.PNG" 
align="middle" style="margin-left:40%" onClick="location.href='/MiniProject/Homejsp/HP_HOME.jsp'">
	
   <c:choose>
		<c:when test="${empty sessionScope.member.memberId }"> <!-- 로그인을 안했으면 -->
		 
		    <ul class="menu">
		    	<li class="menu__item">
		            <a href="/MiniProject/Homejsp/HP_HOME.jsp" class="menu__link">
		                <span class="menu__title">
		                    <span class="menu__first-word" data-hover="HO">
		                        HO
		                    </span>
		                    <span class="menu__second-word" data-hover="ME">
		                        ME
		                    </span>
		                </span>
		            </a>
		        </li>
		    
		        <li class="menu__item">
		            <a href="/MiniProject/Homejsp/about_us.jsp" class="menu__link">
		                <span class="menu__title">
		                    <span class="menu__first-word" data-hover="About">
		                        About
		                    </span>
		                    <span class="menu__second-word" data-hover="Us">
		                        Us
		                    </span>
		                </span>
		            </a>
		        </li>
		
		        <li class="menu__item">
		            <a href="/MiniProject/boardMenu.jsp" class="menu__link">
		                <span class="menu__title">
		                    <span class="menu__first-word" data-hover="On">
		                        On
		                    </span>
		                    <span class="menu__second-word" data-hover="Board">
		                        Board
		                    </span>
		                </span>
		            </a>
		        </li>
		
		        <li class="menu__item">
		            <a href="/MiniProject/foundjsp/found_friend_form.jsp" class="menu__link">
		                <span class="menu__title">
		                    <span class="menu__first-word" data-hover="Find">
		                        Find
		                    </span>
		                    <span class="menu__second-word" data-hover="Friend">
		                        Friend
		                    </span>
		                </span>
		            </a>
		        </li>
		
		        <li class="menu__item">
		            <a href="/MiniProject/messagejsp/msg_notLogin.jsp" class="menu__link">
		                <span class="menu__title">
		                    <span class="menu__first-word" data-hover="Manage">
		                        Manage
		                    </span>
		                    <span class="menu__second-word" data-hover="Message">
		                        Message
		                    </span>
		                </span>
		            </a>
		        </li>
		
		        <li class="menu__item">
		            <a href="/MiniProject/Homejsp/contact_us.jsp" class="menu__link">
		                <span class="menu__title">
		                    <span class="menu__first-word" data-hover="Contact">
		                        Contact
		                    </span>
		                    <span class="menu__second-word" data-hover="Us">
		                        Us
		                    </span>
		                </span>
		            </a>
		        </li>
		        
		         <li class="menu__item">
		            <a href="/MiniProject/login/login_form.jsp" class="menu__link">
		                <span class="menu__title">
		                    <span class="menu__first-word" data-hover="Log">
		                        Log
		                    </span>
		                    <span class="menu__second-word" data-hover="In">
		                        In
		                    </span>
		                </span>
		            </a>
		        </li>
		        
		    </ul>
   		</c:when>
   		
		<c:otherwise> <!-- 로그인을 했으면 -->
		
			<ul class="menu">
			    	<li class="menu__item">
			            <a href="/MiniProject/Homejsp/HP_HOME.jsp" class="menu__link">
			                <span class="menu__title">
			                    <span class="menu__first-word" data-hover="HO">
			                        HO
			                    </span>
			                    <span class="menu__second-word" data-hover="ME">
			                        ME
			                    </span>
			                </span>
			            </a>
			        </li>
			    
			        <li class="menu__item">
			            <a href="/MiniProject/Homejsp/about_us.jsp" class="menu__link">
			                <span class="menu__title">
			                    <span class="menu__first-word" data-hover="About">
			                        About
			                    </span>
			                    <span class="menu__second-word" data-hover="Us">
			                        Us
			                    </span>
			                </span>
			            </a>
			        </li>
			
			        <li class="menu__item">
			            <a href="/MiniProject/boardMenu.jsp" class="menu__link">
			                <span class="menu__title">
			                    <span class="menu__first-word" data-hover="On">
			                        On
			                    </span>
			                    <span class="menu__second-word" data-hover="Board">
			                        Board
			                    </span>
			                </span>
			            </a>
			        </li>
			
			        <li class="menu__item">
			            <a href="/MiniProject/foundjsp/found_friend_form.jsp" class="menu__link">
			                <span class="menu__title">
			                    <span class="menu__first-word" data-hover="Find">
			                        Find
			                    </span>
			                    <span class="menu__second-word" data-hover="Friend">
			                        Friend
			                    </span>
			                </span>
			            </a>
			        </li>
			
			        <li class="menu__item">
			            <a href="/MiniProject/mini/msg/select_receive" class="menu__link">
			                <span class="menu__title">
			                    <span class="menu__first-word" data-hover="Manage">
			                        Manage
			                    </span>
			                    <span class="menu__second-word" data-hover="Message">
			                        Message
			                    </span>
			                </span>
			            </a>
			        </li>
			
			        <li class="menu__item">
			            <a href="/MiniProject/Homejsp/contact_us.jsp" class="menu__link">
			                <span class="menu__title">
			                    <span class="menu__first-word" data-hover="Contact">
			                        Contact
			                    </span>
			                    <span class="menu__second-word" data-hover="Us">
			                        Us
			                    </span>
			                </span>
			            </a>
			        </li>
			        
			         <li class="menu__item">
			            <a href="/MiniProject/myInfoManager.jsp" class="menu__link">
			                <span class="menu__title">
			                    <span class="menu__first-word" data-hover="My">
			                        My
			                    </span>
			                    <span class="menu__second-word" data-hover="Page">
			                        Page
			                    </span>
			                </span>
			            </a>
			        </li>
			    </ul>
		
		</c:otherwise>
	</c:choose>
