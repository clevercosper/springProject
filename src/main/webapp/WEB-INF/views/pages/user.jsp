<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
		<a href="${pageContext.request.contextPath}/user?myLocale=en_US">English</a>
		<a href="${pageContext.request.contextPath}/user?myLocale=pt_BR">Portugues</a>

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
				<label><spring:message code="user.firstName" />:</label>
				<form:input class="form-control" path="nome" id="nome" type="text" />
			</div>
			<div class="form-group row">
				<label><spring:message code="user.lastName" />:</label>
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
				<label><spring:message code="user.CPF" />:</label>
				<form:input class="form-control" path="cpf" id="cpf" type="text" />
			</div>
			<div class="form-group row">
				<button class="btn btn-primary" type="submit" value="send">
					<i class="fa fa-floppy-o" aria-hidden="true"></i> Salvar
				</button>
			</div>

		</form:form>

		<h2>List user</h2>
		<form class="form-inline"
			action="${pageContext.request.contextPath}/user/find-by">
			<div class="input-group">
				<input type="text" class="form-control" name="lastName"
					placeholder="Digite um nome">
			</div>
			<div class="input-group">
				<input type="text" class="form-control" name="firstName"
					placeholder="Digite um nome">
			</div>
			<div class="input-group">
				<input type="text" class="form-control" name="cpf" placeholder="cpf">
			</div>
			<button type="submit" class="btn btn-primary">Pesquisar</button>
		</form>
		<table class="table table-striped">
			<tr>
				<td>Last Name</td>
				<td>First Name</td>
				<td>CPF</td>
				<td>Birthdate</td>
				<td>Address</td>
				<td>Edit</td>
				<td>Delete</td>

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
					<td><a href="#myModal_${user.id}" role="button"
						class="btn btn-danger" data-toggle="modal">Delete<i
							class="fa fa-trash-o"></i></a></td>
				</tr>
				<div id="myModal_${user.id}" class="modal fade">
					<div class="modal-dialog">
						<div class="modal-header">
							<h4 class="modal-title">Confirm delete</h4>
						</div>
						<div class="modal-body">
							<button class="btn btn-default" data-dismiss="modal">Close</button>
							<a href="${pageContext.request.contextPath}/user/delete/${user.id}"
							class= "btn btn-danger">Delete</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</table>
	</div>
</body>
</html>