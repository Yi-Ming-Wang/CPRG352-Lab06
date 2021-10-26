<%-- 
    Document   : shoppingList
    Created on : 25-Oct-2021, 10:50:35 AM
    Author     : adamw
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <p>Hello, ${USER}</p>
        <p><a href="/ShoppingList?action=logout"/>Logout</a></p>

    <form action="" method="post">
        <lable>Add item: </lable>
        <input type="text" name="ADDITEM">
        <input type="submit" value="Add">
        <input type="hidden" name="action" value="add">
    </form>
    <br>
    <form action="" method="post">
        <c:forEach var="ITEM" items="${ITEMS}" >
            <input type="radio" name="REMOVE" value="${ITEM}">${ITEM} <br>
        </c:forEach>
            <input type="submit" value="Delete" >
            <input type="hidden" name="action" value="delete">
    </form>
    </body>
</html>
