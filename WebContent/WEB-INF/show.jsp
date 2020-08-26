<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Person"%>
<% Person selectPerson = (Person) request.getAttribute("person"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>課題</title>
</head>
<body>
<h1>人物情報</h1>
<form method="post" action="<%= request.getContextPath()%>/update">
<input type="hidden" name="id" value="<%= selectPerson.getId() %>">
	<p>ID:<%= selectPerson.getId() %></p>
	<p>NAME:<input type="text" name="name" value="<%= selectPerson.getName()%>"></p>
	<p>AGE:<input type="text" name="age" value="<%= selectPerson.getAge()%>"></p>
	<input type="submit" value="更新">
</form>
<br>
<a href="<%= request.getContextPath()%>/delete?id=<%= selectPerson.getId() %>">削除する</a>
</body>
</html>