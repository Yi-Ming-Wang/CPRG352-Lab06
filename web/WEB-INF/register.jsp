<%-- 
    Document   : register
    Created on : 25-Oct-2021, 10:50:05 AM
    Author     : adamw
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="Style/main.css" type="text/css"/>    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>${MESSAGE}</p>
        <form action="" method="post">
            <p> Username: </p>
            <input type="text" name="USER" value="">
            <input type="hidden" name="action" value="register">
            <br>
            <input type="submit" value="Register name">
        </form>
    </body>
</html>
