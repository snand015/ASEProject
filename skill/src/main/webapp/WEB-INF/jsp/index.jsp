
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <link rel="stylesheet" href="css/style.css" type="text/css"/>
</head>
<body>
    <h2>Login</h2>
    <div class=signup>
    <span class="success">${dataSaved}</span>
    <form:form action="login" method="post" modelAttribute="login">
        <label for="username">Username:</label>
        <form:input type="text" id="username" path="userName" /><br/><br/>

        <label for="password">Password:</label>
        <form:input type="password" id="password" path="password" /><br/><br/>

        <form:button type="submit">Login</form:button><br/><br/>
    </form:form>

    <div>
        <a href="/forgot-password">Forgot Password?</a> |
        <a href="/register">New User? Register</a>
    </div>
    </div>
</body>
</html>