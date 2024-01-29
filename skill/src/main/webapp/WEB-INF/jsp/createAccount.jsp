<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/styles.css" type="text/css"/>
    <meta charset="UTF-8">
    <title>User Registration</title>
</head>
<body>

    <h2>User Registration</h2>
    <form:form action="addUser" method="post" modelAttribute="user">

      

        <br/><br/>
<label>Username</label> <form:input path="userName" type="text" /><form:errors path="userName" cssClass="error"/><br/>
    			<label>Password</label> <form:input path="password" type="password" /><form:errors path="password" cssClass="error"/><br/>
    			<label>First Name</label> <form:input path="firstName" type="text" /><form:errors path="firstName" cssClass="error"/><br/>
    			<label>Last Name</label> <form:input path="lastName" type="text" /><form:errors path="lastName" cssClass="error"/><br/>
       

        <label for="email">Email:</label>
        <form:input  path="email" type="email" /><from:errors path="email" cssClass="error"/></br>

        <br/><br/>

        <br/><br/>

       <label for="address">Address</label>
       <form:textarea path="address" rows="4" cols="50"/>

            <%-- <label for="housePictures">House Pictures:</label>
           <form:input path="images" type="file" multiple="true"/> --%>
        </div>

        <br/><br/>

        <input type="submit" value="addUser">
</form:form>


</body>
</html>
