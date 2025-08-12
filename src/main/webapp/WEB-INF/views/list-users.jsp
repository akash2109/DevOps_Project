<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<html lang="en">
<head>
    <title>User List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
</head>
<body>
    <h1>User List</h1>
    <a href="${pageContext.request.contextPath}/add">Add User</a>

    <security:authorize access="isAuthenticated()">
        <p>Welcome, <security:authentication property='principal.username' />!</p>
        <form action="${pageContext.request.contextPath}/logout" method="post">
            <input type="submit" value="Logout"/>
        </form>
    </security:authorize>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/edit/${user.id}">Edit</a>
                        <a href="${pageContext.request.contextPath}/delete/${user.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>