<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE HTML>

<html>
    <head>
        <title>Add Employee</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <h1 class="text-center mb-3">
            Add Employee
        </h1>
        <hr>

        <div class="container">
            <c:if test="${sessionScope.add == false}">
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <span>Employee already exits with same email</span>
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>
            <c:remove var="add" scope="session" />

            <form action="" method="post">
                <input class="form-control mb-3" type="text" name="name" placeholder="Enter name">
                
                <input class="form-control mb-3" type="email" name="email" placeholder="Enter email">
                
                <input class="form-control mb-3" type="text" name="phone" placeholder="Enter phone number">
                
                <input class="form-control mb-3" type="password" name="password" placeholder="Enter password">

                <textarea name="address" class="form-control mb-3" placeholder="Enter address" style="height: 200px;"></textarea>

                <input type="submit" value="Add Employee" class="btn btn-primary me-3">

                <a class="btn btn-danger" href="all-employees">Cancel</a>
            </form>
        </div>
    </body>
</html>