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
	<div class="row">
		<img class=" well col-sm-6 col-md-4" alt=""
			src="http://sou.gohorseprocess.com.br/wp-content/uploads/2017/05/horse21.png">
	</div>
	<div class="page-header well">
		<h1>Cadastro</h1>
		<h3>User form</h3>
	</div>
	<c:choose>
		<c:when test="${user.id>0 }">
			<c:set var="formMethod" value="PUT"></c:set>
			<c:url var="formAction" value="/user/${user.id}"></c:url>
		</c:when>
		<c:otherwise>
			<c:set var="formMethod" value="POST"></c:set>
			<c:url var="formAction" value="/user"></c:url>

		</c:otherwise>
	</c:choose>
	<div class="container well panel panel-default">
		<form:form modelAttribute="user" action="${formAction}"
			method="${formMethod}">
			<div class="form-group row">
				<label>Name:</label>
				<form:input class="form-control" path="nome" id="nome" type="text" />
			</div>
			<div class="form-group row">
				<label>Last Name:</label>
				<form:input class="form-control" path="sobrenome" id="sobrenome"
					type="text" />
			</div>
			<div class="form-group row">
				<label>Address:</label>
				<form:input class="form-control" path="endereco" id="endereco"
					type="text" />
			</div>
			<div class="form-group row">
				<label>Birthdate:</label>
				<form:input class="form-control" path="datanasc" id="datanasc"
					type="date" />
			</div>
			<div class="form-group row">
				<label>Social Security ID:</label>
				<form:input class="form-control" path="cpf" id="cpf" type="text" />
			</div>
			<div class="form-group row">
				<button class="btn btn-primary" type="submit" value="send">
					<i class="fa fa-floppy-o" aria-hidden="true"></i> Salvar
				</button>
			</div>

		</form:form>

		<h2>List user</h2>
		<table class="table table-striped">
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
					<td><a
						href="${pageContext.request.contextPath}/user/${user.id}">Edit</a></td>

				</tr>

			</c:forEach>
		</table>
	</div>
</body>
</html>