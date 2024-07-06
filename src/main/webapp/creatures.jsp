<%--
  Created by IntelliJ IDEA.
  User: diduk
  Date: 5/30/2024
  Time: 6:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Creatures</title>
    <link rel="stylesheet" type="text/css" href="css/creature.css">
</head>
<body>

<video id="background-video" autoplay loop muted>
    <source src="videos/creature.mp4" type="video/mp4">
</video>

<h1 id="animated-heading">Wesen Information</h1>

<div class="form-container">
    <!-- Форма для поиска по всем полям кроме danger_level -->
    <form action="creature-search" method="get">
        <label for="search">Search Wasen :</label>
        <input id="search" type="text" name="name_parameter" placeholder="Name">
        <input type="text" name="surname_parameter" placeholder="Surname">
        <input type="text" name="country_parameter" placeholder="Country">
        <input type="text" name="status_parameter" placeholder="Status">
        <input type="text" name="type_parameter" placeholder="Type">
        <button type="submit">Search</button>
    </form>

    <!-- Форма для поиска по danger_level -->
    <form action="creature-search" method="get">
        <label for="danger_level">Enter danger level (1-5): </label>
        <input type="number" id="danger_level" name="danger_level" min="1" max="5" required>
        <button type="submit">Search by Danger Level</button>
    </form>
</div>

<div class="table-container">
    <table border="1">
        <tr>
            <th>Level</th>
            <th>Safety</th>
        </tr>
        <c:forEach var="i" begin="1" end="5">
            <tr>
                <td>${i}</td>
                <td>
                    <c:choose>
                        <c:when test="${i == 1}">Safe</c:when>
                        <c:when test="${i == 2}">Low risk</c:when>
                        <c:when test="${i == 3}">Moderate risk</c:when>
                        <c:when test="${i == 4}">High risk</c:when>
                        <c:when test="${i == 5}">Dangerous</c:when>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<div class="table-container">
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Birthday</th>
            <th>Country</th>
            <th>Status</th>
            <th>Type</th>
            <th>Danger Level</th>
        </tr>
        <c:forEach var="creature" items="${creatures}">
            <tr>
                <td>${creature.id}</td>
                <td>${creature.person.name}</td>
                <td>${creature.person.surname}</td>
                <td>${creature.person.birthday}</td>
                <td>${creature.country}</td>
                <td>${creature.person.status}</td>
                <td>${creature.type}</td>
                <td>${creature.dangerLevel.id} - ${creature.dangerLevel.description}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<a href="index.jsp" class="back-button">Back</a>

<script>
    function animateTextColor(element, colors, interval) {
        let index = 0;
        setInterval(() => {
            index = (index + 1) % colors.length;
            element.style.color = colors[index];
        }, interval);
    }

    // Вызываем функцию анимации
    const heading = document.getElementById('animated-heading');
    animateTextColor(heading, ['Red', '#32CD32'], 400);
</script>

</body>
</html>
