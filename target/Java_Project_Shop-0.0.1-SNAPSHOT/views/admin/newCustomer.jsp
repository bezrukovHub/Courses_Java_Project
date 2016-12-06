<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

	Customer:
	<br>
	<c:forEach var="customer" items="${customers}">
	
		${customer.name} 
		<a href="deleteCustomer/${customer.id}"><button>Delete</button></a>
		<br>
	
	</c:forEach>
	<br>
	
	<form:form action="./saveImage?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
   		<input type="file" name="image">
  		<button>save image</button>
	</form:form>

	<form:form  modelAttribute="customer" action="saveCustomer" method="post">
				<form:input path="name" placeholder="Name">
				<form:input path="surname" placeholder="Surname">
				<form:input path="login" placeholder="Login">
				<form:input path="password" placeholder="Password">
				<form:input path="phoneNumber" placeholder="Phone Number">
				<form:input path="email" placeholder="Email">
				<form:input path="city" placeholder="City">
				<form:input path="address" placeholder="Address">
				<form:button>Save</form:button>
	</form:form>