<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Person" %>
<%@ page import="java.util.List" %>
<% List<Person> personList = (List<Person>) request.getAttribute("personList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>課題</title>
</head>
<body>
<table border="1">
	<tr>
		<th>ID</th>
		<th>氏名</th>
		<th>年齢</th>
	</tr>
	<% for(int i = 0; i < personList.size(); i++){
		Person person = personList.get(i);
		%>
	<tr>
		<td><a href="<%= request.getContextPath()%>/show?id=<%= person.getId() %>"><%= person.getId() %></a></td>
		<td><%= person.getName() %></td>
		<td><%= person.getAge() %></td>
	</tr>
	<% } %>
</table>
<br>
<a href="<%= request.getContextPath()%>/new.jsp">登録する</a>
</body>
</html>