<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<link href="css/registration_login.css" rel="stylesheet">

<body>
<form:form modelAttribute="category" action="saveCategory" method="post" class="wrap" >
	<fieldset>
		<legend><h3>Category</h3></legend>
		<form:input class="input" path="name" placeholder="Name of category" />
		<form:input class="input" path="description" placeholder="Description"/>
		<form:button class="butt" >Add</form:button>
	</fieldset>
</form:form>
</body>
	Category:
	<br>
	<c:forEach var="category" items="${categories}">
	
		${category.name}
		<a href="deleteCategory/${category.id}"> <button>Delete</button> </a>
		<br>
	
	</c:forEach>