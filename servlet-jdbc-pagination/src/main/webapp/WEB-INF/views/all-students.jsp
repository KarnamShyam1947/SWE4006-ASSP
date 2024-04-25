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
            <c:choose>
                <c:when test="${empty studentPage}">
                    <h3 class="text-center">No Students Found in database</h3>
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
                            </tr>
                        </thead>
                        <c:forEach items="${studentPage}" var="student" varStatus="i">
                            <tbody>
                                <tr>
                                    <td>
                                        <c:out value="${i.index + 1}" />
                                    </td>
                                    <td>
                                        <c:out value="${student.regNo}" />
                                    </td>
                                    <td>
                                        <c:out value="${student.username}" />
                                    </td>
                                    <td>
                                        <c:out value="${student.email}" />
                                    </td>
                                    <td>
                                        <c:out value="${student.phone}" />
                                    </td>
                                </tr>
                            </tbody>
                        </c:forEach>
                    </table>

                    <nav>
                        <ul class="pagination">

                            <c:choose>
                                <c:when test="${requestScope.currentPage != 1}">
                                    <li class="page-item">
                                        <a href="?page=<c:out value='${requestScope.currentPage - 1}' />" class="page-link">Previous</a>
                                    </li>
                                </c:when>

                                <c:otherwise>
                                    <li class="page-item disabled">
                                        <a class="page-link">Previous</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                            
                            <c:forEach begin="1" end="${totalPages}" var="var">
                                <li class='page-item <c:if test="${requestScope.currentPage == var}">  <c:out value="active"/> </c:if>'>
                                    <a class="page-link" href="?page=<c:out value='${var}' />">${var}</a>
                                </li>
                            </c:forEach>

                            <c:choose>
                                <c:when test="${requestScope.currentPage != requestScope.totalPages}">
                                    <li class="page-item">
                                        <a href="?page=<c:out value='${requestScope.currentPage + 1}' />" class="page-link">Next</a>
                                    </li>
                                </c:when>

                                <c:otherwise>
                                    <li class="page-item disabled">
                                        <a class="page-link">Next</a>
                                    </li>
                                </c:otherwise>
                            </c:choose>

                        </ul>
                    </nav>
                    <p>
                        showing 
                        <c:out value="${requestScope.currentRecords}"/>
                        of 
                        <c:out value="${requestScope.totalRecords}"/>
                    </p>
                </c:otherwise>
            </c:choose>
    </div>
</body>

</html>