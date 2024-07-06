<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of Persons</title>
    <link rel="stylesheet" type="text/css" href="css/person.css">
</head>
<body>

<video id="background-video" autoplay loop muted>
    <source src="videos/person.mp4" type="video/mp4">
</video>

<div class="content">
    <!-- Форма для поиска -->
    <form action="person-search" method="get">
        <div>
            <label for="status-input">Status:</label>
            <input id="status-input" type="text" name="status" placeholder="Live or Dead">
        </div>
        <div>
            <label for="name-input">Name:</label>
            <input id="name-input" type="text" name="name" placeholder="Name">
        </div>
        <div>
            <label for="surname-input">Surname:</label>
            <input id="surname-input" type="text" name="surname" placeholder="Surname">
        </div>
        <button type="submit">Search</button>
    </form>


    <div class="table-container">
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Birth Day</th>
                <th>Status</th>
            </tr>
            <c:forEach var="person" items="${persons}">
                <tr>
                    <td>${person.id}</td>
                    <td>${person.name}</td>
                    <td>${person.surname}</td>
                    <td>${person.birthday}</td>
                    <td>${person.status}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <a href="index.jsp" class="back-button">Back</a>
</div>

<script>
    function animateTextColor(element, colors, interval) {
        let index = 0;
        setInterval(() => {
            index = (index + 1) % colors.length;
            element.style.color = colors[index];
        }, interval);
    }

    const heading = document.getElementById('animated-heading');
    animateTextColor(heading, ['#228B22', '#32CD32'], 400);
</script>

</body>
</html>
