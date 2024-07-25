<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Paramedic Scenario Repository</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/webapp/styles/main.css">
</head>
<body>
<h1>Welcome to the Paramedic Scenario Repository</h1>
<p>This is the home page of the Paramedic Scenario Repository application.</p>

<h2>Scenarios</h2>
<table border="1">
    <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Date Created</th>
        <th>Difficulty Level</th>
        <th>Student</th>
    </tr>
    <c:forEach var="scenario" items="${scenarios}">
        <tr>
            <td>${scenario.title}</td>
            <td>${scenario.description}</td>
            <td>${scenario.dateCreated}</td>
            <td>${scenario.difficultyLevel}</td>
            <td>${scenario.student.name}</td>
        </tr>
    </c:forEach>
</table>

<h2>Add a New Scenario</h2>
<form action="${pageContext.request.contextPath}/scenarios" method="post">
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" required><br><br>

    <label for="description">Description:</label>
    <textarea id="description" name="description" required></textarea><br><br>

    <label for="difficultyLevel">Difficulty Level:</label>
    <input type="text" id="difficultyLevel" name="difficultyLevel" required><br><br>

    <label for="studentId">Student ID:</label>
    <input type="text" id="studentId" name="studentId" required><br><br>

    <input type="submit" value="Add Scenario">
</form>
</body>
</html>