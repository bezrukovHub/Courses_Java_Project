<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link href="css/registration_login.css" rel="stylesheet">

<body>
<form:form  modelAttribute="commodity" action="saveCommodity" method="post" class="wrap" >
	<fieldset>
		<legend><h3>Commodity</h3></legend>
		<form:input class="input" path="name" placeholder="Name of commodity"/>
		<form:input class="input" path="description" placeholder="Description"/>
		<form:input class="input" path="price" placeholder="Price"/>
		<form:button class="butt" >Add</form:button>
	</fieldset>
</form:form>
</body>

Commodity:
<br>
<c:forEach var="commodity" items="${commodities}">

	${commodity.name} ${commodity.description} ${commodity.price}
	<a href="deleteCommodity/${commodity.id}"><button>Delete</button></a>
	<br>

</c:forEach>
<br>