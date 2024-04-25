<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE HTML>

<html>
    <head>
        <title>All Students</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <h1 class="text-center">All Students</h1>
        <hr>

        <div class="container">
            <c:if test="${sessionScope.add == true}">
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    <span>Student added successfully</span>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>

            <c:if test="${sessionScope.edit == true}">
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    <span>Student details updated successfully</span>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>

            <c:if test="${sessionScope.edit == false}">
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <span>Failed to update student details</span>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>

            <c:if test="${sessionScope.delete == true}">
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    <span>Student details deleted successfully</span>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>
            
            <c:if test="${sessionScope.delete == false}">
                <div class="alert alert-dander alert-dismissible fade show" role="alert">
                    <span>Failed to delete Student details </span>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>

            <c:if test="${sessionScope.deleteTop == true}">
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    <span>Top Student record deleted successfully</span>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>

            <c:if test="${sessionScope.deleteTop == false}">
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <span>Failed to delete top Student record</span>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>
            <c:remove var="add" scope="session" />
            <c:remove var="edit" scope="session" />
            <c:remove var="delete" scope="session" />
            <c:remove var="deleteTop" scope="session" />

            <c:choose>
                <c:when test="${empty students}">
                    <h3 class="text-center">No Students Found in database</h3>
                    <a class="btn btn-success" href="add-student">Add Student</a>
                </c:when>
                <c:otherwise>
                    <table class="table table-striped table-hover">
                        <thead class="table-dark">
                            <tr>
                                <th>SL. NO.</th>
                                <th>Reg. No.</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Phone No.</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <c:forEach items="${students}" var="student" varStatus="i">
                            <tbody>
                                <tr>
                                    <td>
                                        <c:out value="${i.index + 1}"></c:out>
                                    </td>
                                    <td>
                                        <c:out value="${student.regNo}"></c:out>
                                    </td>
                                    <td>
                                        <c:out value="${student.username}"></c:out>
                                    </td>
                                    <td>
                                        <c:out value="${student.email}"></c:out>
                                    </td>
                                    <td>
                                        <c:out value="${student.phone}"></c:out>
                                    </td>
                                    <td>
                                        <a onclick="return confirm('Are you sure?')" class="btn btn-danger" href='delete-student?reg-no=<c:out value="${student.regNo}"></c:out>'>delete</a>
                                        <a class="btn btn-info" href='edit-student?reg-no=<c:out value="${student.regNo}"></c:out>'>edit</a>
                                    </td>
                                </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                    <a onclick="return confirm('Are you sure?')" class="btn btn-danger me-3" href="delete-top-student">Delete Top</a>
                    <a class="btn btn-success" href="add-student">Add Student</a>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>