<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section class="header">
    <h1 class="title">Cats</h1>
    <div class="title-hr"></div>
</section>
<section class="container">
    <a href="cats/new">[+]</a>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Age</th>
            <th scope="col" class="description-column">Description</th>
<%--            <th scope="col">Adoption Status</th>--%>
            <th scope="col">Gender</th>
            <th scope="col">Edit</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${cats}" var="cat">
            <tr>
                <td>
                    <div class="center"><p>${cat.id}</p></div>
                </td>
                <td>${cat.name}</td>
                <td>${cat.age}</td>
                <td class="description-row">${cat.description}</td>
<%--                <td>${cat.adoptionStatus}</td>--%>
                <td>${cat.gender}</td>
                <td><a href="cats/${cat.id}/edit">Edit</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>

<jsp:include page="../include/footer.jsp"/>