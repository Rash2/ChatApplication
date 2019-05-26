<%--
  Created by IntelliJ IDEA.
  User: codru
  Date: 5/23/2019
  Time: 3:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <style>
        label,form,h1 {
            font-family: sans-serif;
        }
    </style>
</head>
<body>
<h1 style="top: 2%;left: 37%;position: absolute;">Sign up to chat with others!</h1>
<div style="border-left: 3px solid black;width: 200px;height: 530px;margin: 0 auto;background-color: beige;margin-top: 8%">
    <form action="/submit" style="width: 165px;margin: 0 auto;position: absolute;top: 20%;left: 45%;" method="post">
        <label for="firstname">First Name:</label>
        <br>
        <input type="text" name="firstname" id="firstname">
        <br><br>
        <label for="lastname">Last Name:</label>
        <br>
        <input type="text" name="lastname" id="lastname">
        <br><br>
        <fieldset>
            <legend>Gender:</legend>
            Male
            <input type="radio" name="gender" value="Male"><br>
            Female
            <input type="radio" name="gender" value="Female">
        </fieldset>
        <br>
        <label for="birthdate">Birthdate:</label>
        <br>
        <input type="date" name="birthdate" id="birthdate">
        <br><br>
        <label for="email">E-mail address:</label>
        <br>
        <input type="text" name="email" id="email">
        <br><br>
        <label for="password">Password:</label>
        <br>
        <input type="password" name="password" id="password">
        <br><br>
        <label for="confirm_password">Confirm password:</label>
        <br>
        <input type="password" name="confirm_password" id="confirm_password">
        <br><br>
        <input type="submit" value="Sign Up">
    </form>
</div>
</body>
</html>