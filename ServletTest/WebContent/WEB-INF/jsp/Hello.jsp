<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<p>Hello <%=request.getAttribute("name") %> !</p>
	<form action="">
		<input type="submit" value="back to home page"/>
	</form>
	<p>
		線上人數: <%=request.getAttribute("count")%> 人</p>
</body>
</html>