<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE HTML>

<html>
    <head>
        <title>All Employees</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <h1 class="text-center">All Employees</h1>
        <hr>

        <div class="container">
            <c:if test="${sessionScope.add == true}">
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    <span>Employee added successfully</span>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>
            <c:remove var="add" scope="session" />

            <c:choose>
                <c:when test="${empty employees}">
                    <h3 class="text-center">No employees Found in database</h3>
                    <a class="btn btn-success" href="add-employee">Add Employee</a>
                </c:when>
                <c:otherwise>
                    <table class="table table-striped table-hover">
                        <thead class="table-dark">
                            <tr>
                                <th>SL. NO.</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Phone No.</th>
                                <th>Address</th>
                            </tr>
                        </thead>
                        <c:forEach items="${employees}" var="employee" varStatus="i">
                            <tbody>
                                <tr>
                                    <td>
                                        <c:out value="${i.index + 1}"></c:out>
                                    </td>
                                    <td>
                                        <c:out value="${employee.name}"></c:out>
                                    </td>
                                    <td>
                                        <c:out value="${employee.email}"></c:out>
                                    </td>
                                    <td>
                                        <c:out value="${employee.phone}"></c:out>
                                    </td>
                                    <td>
                                        <c:out value="${employee.address}"></c:out>
                                    </td>
                                </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                    <a class="btn btn-success" href="add-employee">Add Employee</a>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>