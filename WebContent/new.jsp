<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>課題</title>
</head>
<body>
<h1>人物情報</h1>
<form method="post" action="<%= request.getContextPath() %>/new">
	<p>NAME:<input type="text" name="name" value=""></p>
	<p>AGE:<input type="text" name="age" value=""></p>
	<input type="submit" value="登録する">
</form>
</body>
</html>