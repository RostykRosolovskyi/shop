<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Bucket</title>
</head>
<body>
<form action="../logoff">
    <button type="submit">Log off</button>
</form>
<h3>${sessionScope.loggedInUser.name}, welcome to your bucket</h3>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Delete</th>
    </tr>
    <tr>
        <td>${item.name}</td>
        <td>${item.price}</td>
        <td><a href="deleteFromBucket?item_id=${item.id}">Delete</a></td>
    </tr>
    <c:forEach var="item" items="${bucket.items}">
    </c:forEach>
    <tr>
        <td>Total</td>
        <td>${totalCost}</td>
        <td><a href="completeOrder">Buy</a></td>
    </tr>
</table>
<br>
<a href="../shop">Return to the shop</a>
</body>
</html>