<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

	Order_C
	<br>
	<br>
	
	<c:forEach var="order_C" items="${order_Cs}">
	
		${order_C.name} ${order_C.price}
		<a href="deleteOrder_C/${order_C.id}"><button>Delete</button></a>
		<br>
	
	</c:forEach>
	
	<br>
	<form:form modelAttribute="order_C" action="saveOrder_C" method="post">
	
		<form:input path="name" placeholder="Name"/>
		<form:input path="amountOfCommodities" placeholder="Amount of commodities"/>
		<form:input path="price" placeholder="Price"/>
		<form:input path="paymentMethod" placeholder="Payment method"/>
		<form:select path="idCommodity">
			<c:forEach var="commodity" items="${commodities}">
				<option value="${commodity.id}">${commodity.name} ${commodity.description}</option>
			</c:forEach>
		</form:select>
		<button>Save</button>
	
	</form:form>
	<br>