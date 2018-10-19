<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Attendance Management </title>
</head>
<body>
	<center>
		<h1>Attendance Management</h1>
        <h2>
        	<a href="new">Add New Entry</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List Student Attendance</a>
        	
        </h2>
	</center>
    <div align="center">
		<c:if test="${attendance != null}">
			<%--update--%>
            <form action="update" method="post">
                <input type="hidden" name="rno" value="<c:out value='${attendance.rno}' />" />
                <table border="1" cellpadding="5">
                    <tr>
                        <th>Days Present: </th>
                        <td>
                            <input type="text" name="pdays" size="45"
                                   value="<c:out value='${attendance.pdays}' />"
                            />
                        </td>
                    </tr>
                    <tr>
                        <th>Author: </th>
                        <td>
                            <input type="text" name="adays" size="45"
                                   value="<c:out value='${attendance.adays}' />"
                            />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Save" />
                        </td>
                    </tr>
                </table>
            </form>
        </c:if>
        <c:if test="${attendance == null}">
			<%--insert--%>
        <form action="insert" method="post">
            <table border="1" cellpadding="5">
                <tr>
                    <th>Roll Number: </th>
                    <td>
                        <input type="text" name="rno" size="45"
                               value="<c:out value='${attendance.rno}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Subject Name: </th>
                    <td>
                        <input type="text" name="subname" size="45"
                               value="<c:out value='${attendance.subname}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Name: </th>
                    <td>
                        <input type="text" name="name" size="5"
                               value="<c:out value='${attendance.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Days Present: </th>
                    <td>
                        <input type="text" name="pdays" size="5"
                               value="<c:out value='${attendance.pdays}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Days Absent: </th>
                    <td>
                        <input type="text" name="adays" size="5"
                               value="<c:out value='${attendance.adays}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Total Days: </th>
                    <td>
                        <input type="text" name="totdays" size="5"
                               value="<c:out value='${attendance.totdays}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
        </c:if>
    </div>	
</body>
</html>
