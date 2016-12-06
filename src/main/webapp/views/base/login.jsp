<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<link href="css/registration_login.css" rel="stylesheet">

<body>
<form:form action="loginprocesing" method="post" class="wrap">
    <fieldset>
        <legend><h3>Sign In</h3></legend>
        <input name="username" type="text" placeholder="login" class="input"/>
        <input name="password" type="password" placeholder="password" class="input"/>
        <button class="butt">Login</button>
    </fieldset>
</form:form>
</body>