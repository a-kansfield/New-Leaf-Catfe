<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include/header.jsp"/>
<section class="header">
    <h1 class="title">Events</h1>
    <div class="title-hr"></div>
</section>

<section class="container event-container">
<c:forEach items="${events}" var="event">

    <div class="event-object-container">
        <div class="image-container">
            <img class="event-image" src=${event.imageURL} alt="">
        </div>
        <div class="text-container">
            <h2 class="event-title">${event.title}</h2>

            <div class="text-body">
                <p>
                    ${event.description}
                </p>

            </div>

            <div class="btn-date-row">

                <div class="event-date"><p><fmt:formatDate value="${event.startDate}" pattern="MMMM dd, h:mm a" /></p></div>
                <button type="button" class="rsvp-button">
                    <a href="/events/${event.id}">RSVP <img src="../../../pub/assets/imgs/arrow-circle-right-svgrepo-com.svg" alt=""></a></button>

            </div>

        </div>
    </div>

</c:forEach>
</section>
<section class="event-container"></section>


<script event="" src="../../../pub/js/events.js"></script>
<jsp:include page="../include/footer.jsp"/>
