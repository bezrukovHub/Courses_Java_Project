<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 

${customer.name} ${customer.email} ${customer.phoneNumber}
<br>

	<form:form action="./saveImage?${_csrf.parameterName}=${_csrf.token}" method="post" 
	enctype="multipart/form-data">
   		<input type="file" name="image">
  		<button>save image</button>
	</form:form>
	