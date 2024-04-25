<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Servlet Form</title>
    </head>
    <body>
        <h1>Servlet Form</h1>
        <hr>
        <form action="result" method="post">
            <table>
                <tr>
                    <td>
                        <label for="username">Enter username</label>
                    </td>
                    <td>
                        <input type="text" name="username" id="username">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="email">Enter email</label>
                    </td>
                    <td>
                        <input type="email" name="email" id="email">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="phone">Enter phone</label>
                    </td>
                    <td>
                        <input type="text" name="phone" id="phone">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="hob">Select Hobbies</label>
                    </td>
                    <td>
                        <input type="checkbox" value="Playing" name="hobbies" id="h1"> <label for="h1">Playing</label>
                        <input type="checkbox" value="Reading" name="hobbies" id="h2"> <label for="h2">Reading</label>
                        <input type="checkbox" value="Coding" name="hobbies" id="h3"> <label for="h3">Coding</label>
                        <input type="checkbox" value="Listening Songs" name="hobbies" id="h4"> <label for="h4">Listening Songs</label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="reset" value="reset">
                    </td>
                    <td>
                        <input type="submit" value="submit">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>