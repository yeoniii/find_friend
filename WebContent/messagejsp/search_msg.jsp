<%@ page contentType="text/html;charset=UTF-8"%>

	<form action="/MiniProject/mini/msg/search">
		<select name="search_opt">
			<option value="name">보낸사람</option>
			<option value="title">제목</option>
			<option value="content">내용</option>
		</select>
		<input type="text" name="search">
		<input type="submit" value="검색">
		
	</form>
