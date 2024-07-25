<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Scenarios</title>
    <link rel="stylesheet" href="../styles/main.css">
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="scenarios">Scenarios</a></li>
            <li><a href="add-scenario.jsp">Add Scenario</a></li>
            <li><a href="about.jsp">About</a></li>
            <li><a href="contact.jsp">Contact</a></li>
        </ul>
    </nav>
</header>

<main>
    <h1>Scenarios</h1>
    <ul>
        <c:forEach var="scenario" items="${scenarios}">
            <li>${scenario.title} - ${scenario.description}</li>
        </c:forEach>
    </ul>
</main>

<footer>
    <p>&copy; 2024 Paramedic Scenario Repository</p>
</footer>
</body>
</html>
