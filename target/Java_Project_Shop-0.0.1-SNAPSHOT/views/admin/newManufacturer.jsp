<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<link href="css/registration_login.css" rel="stylesheet">

<body>
<form:form modelAttribute="manufacturer" action="saveManufacturer" method="post" class="wrap" >
	<fieldset>
		<legend><h3>Manufacturer</h3></legend>
		<form:input class="input" path="name" placeholder="Name of commodity"/>
		<form:button class="butt" >Add</form:button>
	</fieldset>
</form:form>
</body>
	
	Manufacturer:
	<br>
	<c:forEach var="manufacturer" items="${manufacturers}">
	
		${manufacturer.name} 
		<a href="deleteManufacturer/${manufacturer.id}"><button>Delete</button></a>
		<br>
	
	</c:forEach>
	<br>
