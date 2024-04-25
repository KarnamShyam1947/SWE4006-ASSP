<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE HTML>

<html>
    <head>
        <title>Edit Student</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <h1 class="text-center mb-3">
            Edit Student
        </h1>
        <hr>

        <div class="container">
            <form action="" method="post" onsubmit="return confirm('Are you sure?')">
                <input class="form-control mb-3" type="text" name="regNo" value="${student.regNo}" readonly>
                <input class="form-control mb-3" type="text" name="username" value="${student.username}">
                <input class="form-control mb-3" type="email" name="email" value="${student.email}">
                <input class="form-control mb-3" type="text" name="phone" value="${student.phone}">
                <input type="hidden" name="id" value="${student.id}">
                <input class="btn btn-primary me-3" type="submit" value="Edit Student" > 
                <a class="btn btn-danger" href="all-students">Cancel</a>
            </form>
        </div>
    </body>
</html>