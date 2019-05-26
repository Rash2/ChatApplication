<%--
  Created by IntelliJ IDEA.
  User: codru
  Date: 5/23/2019
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>
  <style>
    label,a,h1 {
      font-family: sans-serif;
    }
  </style>
</head>
<body>
<h1 style="position: absolute;top: 5%;left: 45%">Welcome!</h1>
<div style="border-left: 3px solid black;width: 200px;height: 250px;margin: 0 auto;margin-top: 10%;background-color: beige">
  <form action="/login" method="post" style="width: 165px;margin: 0 auto;position: absolute;top: 25%;left: 45%;">
    <label for="emailAddress">Email:</label>
    <br>
    <input type="text" name="emailAddress" id="emailAddress">
    <br><br>
    <label for="password">Password:</label>
    <br>
    <input type="password" name="password" id="password">
    <br>
    <input type="submit" value="Login">
  </form>
  <a href="SignUpPage.jsp" style="margin: 0 auto;position: absolute;top: 43%;left: 45%;">No account? Click here</a>
  <a href="" style="margin: 0 auto;position: absolute;top: 48%;left: 45%;">Forgot password?</a>
</div>
</body>
</html>
