<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>
<section class="header">
    <h1 class="title">${cat.name}</h1>
    <div class="title-hr"></div>
</section>

<section class="container">
    <div class="cat-card">
        <div class="container-1">
            <div class="cat-page-image-container">
                <img src="${cat.imageURL}" alt="" class="cat-image">
            </div>
            <div class="container-row">
                <div>
                <c:choose>
                    <c:when test="${cat.gender == 'female'}">
                        Lady<br>&female;
                    </c:when>
                    <c:when test="${cat.gender == 'male'}">
                        Lad<br>&male;
                    </c:when>
                </c:choose></div>
                <div>Age<br>${cat.age}</div>
            </div>
        </div>
        <div class="container-2">
            <h2>${cat.description}</h2>
        </div>
        <div class="container-3">
            <div class="container-title">
                <h2>Events</h2>
            </div>
            <div class="events-list">
                <c:forEach items="${events}" var="event">
                    <a href="../events/${event.id}"><div>${event.title}</div></a>
                </c:forEach>
            </div>

        </div>
    </div>

</section>
