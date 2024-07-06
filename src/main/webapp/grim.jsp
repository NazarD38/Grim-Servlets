<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Grim</title>
    <link rel="stylesheet" type="text/css" href="css/grim.css">
</head>
<body>

<video id="background-video" autoplay loop muted>
    <source src="videos/grim-search.mp4" type="video/mp4">
</video>

<div class="content">
    <h1 id="animated-heading">Grim Information</h1>

    <form action="grim-servlet" method="get">
        Show all Grims :
        <input type="submit" value="Show">
    </form>

    <form action="grim-search" method="get">
        Search Grim :
        <input type="text" name="name" placeholder="Name">
        <input type="text" name="surname" placeholder="Surname">
        <input type="text" name="country" placeholder="Country">
        <input type="text" name="status" placeholder="Live or Dead">
        <button type="submit">Search</button>
    </form>

    <form action="grim-creature" method="get">
        Show Kills by Grim :
        <input type="text" name="grimName" placeholder="id">
        <button type="submit">Search</button>
    </form>

    <c:if test="${not empty error}">
        <div class="error-message">
            <p>${error}</p>
        </div>
    </c:if>

    <div class="table-container">
        <table border="1">
            <tr>
                <th>Grim Name</th>
                <th>Creature Name</th>
                <th>Creature Type</th>
            </tr>
            <c:forEach var="grimCreature" items="${grimCreatures}">
                <tr>
                    <td>${grimCreature.grim.person.name}</td>
                    <td>${grimCreature.creature.person.name}</td>
                    <td>${grimCreature.creature.type}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <form action="grim-search" method="get">
        Sort by:
        <select name="sort">
            <option value="killsASC">Kills(A-Z)</option>
            <option value="killsDESC">Kills(Z-A)</option>
        </select>
        <button type="submit">Show</button>
    </form>

    <div class="table-container">
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Birthday</th>
                <th>Country</th>
                <th>Status</th>
                <th>Killed</th>
            </tr>
            <c:forEach var="grim" items="${grims}">
                <tr>
                    <td>${grim.id}</td>
                    <td>${grim.person.name}</td>
                    <td>${grim.person.surname}</td>
                    <td>${grim.person.birthday}</td>
                    <td>${grim.country}</td>
                    <td>${grim.person.status}</td>
                    <td>${grim.killed}</td>
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
