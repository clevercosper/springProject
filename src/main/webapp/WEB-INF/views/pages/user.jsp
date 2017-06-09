<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<img alt=""
		src="http://sou.gohorseprocess.com.br/wp-content/uploads/2017/05/horse21.png">
	<h1>Cadastro</h1>
	<h3>User form</h3>
	<form:form modelAttribute="user" action="${pageContext.request.contextPath}/user" method="POST">
		<div>
			<label>Name:</label>
			<form:input path="nome" id="nome" type="text" />
		</div>
		<div>
			<label>Last Name:</label>
			<form:input path="sobrenome" id="sobrenome" type="text" />
		</div>
		<div>
			<label>Address:</label>
			<form:input path="endereco" id="endereco" type="text" />
		</div>
		<div>
			<label>Birthdate:</label>
			<form:input path="datanasc" id="datanasc" type="date" />
		</div>
		<div>
			<label>Social Security ID:</label>
			<form:input path="cpf" id="cpf" type="text" />
		</div>
		<div>
			<input type="submit" value="send">
		</div>

	</form:form>
	<h2>List user</h2>
	<table>
		<tr>
			<td>Last Name</td>
			<td>First Name</td>
			<td>CPF</td>
			<td>Birthdate</td>
			<td>Address</td>
			<td>Edit</td>
			
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.sobrenome}</td>
				<td>${user.nome}</td>
				<td>${user.cpf}</td>
				<td>${user.datanasc}</td>
				<td>${user.endereco}</td>
				<td><a href="${pageContext.request.contextPath}/user/${user.id}">Edit</a></td>
				
			</tr>

		</c:forEach>
	</table>
</body>
</html>