<%-- 
    Document   : shoppingList
    Created on : 16-Oct-2022, 4:12:52 PM
    Author     : puppi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <p>Hello, ${username}</p>
        <p><a href="ShoppingList?action=logout">logout</a></p>
        
        <h4>Your Shopping list: </h4>
        <form action="" method="post">
            Add items: <input type="text" name="items">
    </body>
</html>
