<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Attendance Management System</title>
</head>
<body>
<center>
    <h1>Attendance Management</h1>
    <h2>
        <a href="new">Add Student</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list">List Attendance of Student</a>

    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Student Attendance</h2></caption>
        <tr>
            <th>Roll Number</th>
            <th>SubName</th>
            <th>Name</th>
            <th>Days Present</th>
            <th>Days Absent</th>
            <th>Total Days</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="attendance" items="${listattend}">
            <tr>
                <td><c:out value="${attendance.rno}" /></td>
                <td><c:out value="${attendance.subname}" /></td>
                <td><c:out value="${attendance.name}" /></td>
                <td><c:out value="${attendance.pdays}" /></td>
                <td><c:out value="${attendance.adays}" /></td>
                <td><c:out value="${attendance.totdays}" /></td>
                <td>
                    <a href="edit?rno=<c:out value='${attendance.rno}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?rno=<c:out value='${attendance.rno}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>
