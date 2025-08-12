<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Edit User</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
</head>
<body>
    <h1>Edit User</h1>
    <form:form modelAttribute="user" action="${pageContext.request.contextPath}/edit" method="post">
        <form:hidden path="id"/>
        <form:label path="username">Username:</form:label><br>
        <form:input path="username"/><br><br>
        <form:label path="name">Name:</form:label><br>
        <form:input path="name"/><br><br>
        <form:label path="email">Email:</form:label><br>
        <form:input path="email"/><br><br>
        <form:label path="password">Password:</form:label><br>
        <form:input type="password" path="password"/><br><br>
        <input type="submit" value="Update"/>
    </form:form>
    <a href="${pageContext.request.contextPath}/">Back to List</a>
</body>
</html>