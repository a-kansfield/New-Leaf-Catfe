<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section class="header">
    <h1 class="title">Events</h1>
    <div class="title-hr"></div>
</section>
<section class="container">
    <table>
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Title</th>
            <th scope="col">Capacity</th>
            <th scope="col">Description</th>
            <th scope="col">Start</th>
            <th scope="col">End</th>
            <th scope="col">Edit</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${events}" var="event">
            <tr>
                <td>
                    <div class="center"><p>${event.id}</p></div>
                </td>
                <td>${event.title}</td>
                <td>${event.capacity}</td>
                <td class="description-column">${event.description}</td>
                <td>${event.startDate}</td>
                <td>${event.endDate}</td>
                <td>Edit</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

<jsp:include page="../include/footer.jsp"/>