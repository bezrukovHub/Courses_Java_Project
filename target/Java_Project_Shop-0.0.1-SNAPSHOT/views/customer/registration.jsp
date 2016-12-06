<%--
  Created by IntelliJ IDEA.
  User: OlehB9
  Date: 04.12.2016
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link href='http://fonts.googleapis.com/css?family=Didact+Gothic' rel='stylesheet' type='text/css'>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<link href="css/registration_login.css" rel="stylesheet">

<body>
<form:form modelAttribute="customer" action="saveCustomer" method="post" class="wrap" >
            <fieldset>
                <legend><h3>Sign Up</h3></legend>
                <div style="text-align: center; color: red; margin: 5px">
                    <label for="name">${exception}</label>
                </div>
                <form:input class="input" path="name" placeholder="Name"/>
                <form:input class="input" path="surname" placeholder="Surname"/>
                <form:input class="input" path="login" placeholder="Login"/>
                <form:input class="input" path="password" placeholder="Password"/>
                <form:input class="input" path="phoneNumber" placeholder="Phone Number"/>
                <form:input class="input" path="email" placeholder="Email"/>
                <form:input class="input" path="city" placeholder="City"/>
                <form:input class="input" path="address" placeholder="Address"/>
                <form:button class="butt" >Save</form:button>
            </fieldset>
</form:form>
</body>