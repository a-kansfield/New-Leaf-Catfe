<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../include/header.jsp"/>
<section class="header">
    <h1 class="title">Event Sign Up</h1>
    <div class="title-hr"></div>
</section>

<section class=" container rsvp-container">


    <div class="rsvp-event-info">
        <div class="image-container">
            <img class="event-image" src=${eventDetails.image_url} alt="">
        </div>
        <div class="text-container ">
            <div class="rsvp-date">
                <fmt:formatDate value="${event.startDate}" pattern="MMMM dd" /> <br>
                <div id="time"><fmt:formatDate value="${event.startDate}" pattern="h:mm a" /> - <fmt:formatDate value="${event.endDate}" pattern="h:mm a" /></div>
            </div>
        </div>
        <div class="text-container">
            <div class="rsvp-event-info-txt">
               ${eventDetails.description}
            </div>
        </div>
    </div>

    <div class="rsvp-form-container">
        <div class="rsvp-title-container">
            <h2>${eventDetails.title}</h2>
            <h3>RSVP</h3>
        </div>
        <form id="event-form" action="/events/${id}" method="post">
            <div id="form-first-name-container form-group">
                <label for="form-first-name" class="form-label">First Name</label>
                <input id="form-first-name" name="firstname" class="form-control" type="text" value="${form.firstName}">
            </div>

            <div id="form-last-name-container form-group">
                <label for="form-last-name" class="form-label">Last Name</label>
                <input id="form-last-name"  name="lastname" class="form-control" type="text" value="${form.lastName}">
            </div>

            <div id="form-email-container form-group">
                <label for="form-email" class="form-label">Email</label>
                <input id="form-email"  name="email" class="form-control" type="text" value="${form.email}">
            </div>

            <div id="form-adoption-container">
                <h3>Are you interested in adopting during this event?</h3>
                <div class="row form-group">
                    <div class="form-check col">
                        <input id="form-adoption1"  class="form-check-input" type="radio" name="adoption-interest" value="${form.adoptionInterest}">
                        <label for="form-adoption1" class="form-label form-check-label">Yes</label>

                    </div>
                    <div class="form-check col">
                        <input id="form-adoption2"  class="form-check-input" type="radio" name="adoption-interest" value="${form.adoptionInterest}">
                        <label for="form-adoption2" class="form-label form-check-label">No</label>

                    </div>
                    <div class="form-check col">
                        <input id="form-adoption3"  class="form-check-input" type="radio" name="adoption-interest" value="${form.adoptionInterest}">
                        <label for="form-adoption3" class="form-label form-check-label">Undecided</label>
                    </div>
                </div>
            </div>

            <c:if test="${3 == 3}"> <%-- Test will later check to see if the event in the db is a 21+ event--%>
                <div id="alcohol-event" class="hidden">
                    <div id="alcohol-notice" class="form-text">Note: This event serves alcohol.</div>
                    <div class="alcohol-notice-check">
                        <input id="is-over-twenty-one" type="checkbox" class="form-container">
                        <label for="is-over-twenty-one" class="form-label">I confirm I am at least 21 years old.</label>
                    </div>
                </div>
            </c:if>
            <div class="submit">
                <button type="submit" class="btn">Submit</button>
            </div>

        </form>
    </div>

    <%--Cat Panel--%>
    <div class="rsvp-cat-info">
        <div class="image-container">
            <img src=${eventDetails.cat_image_url} alt="" class="cat-image">
        </div>
        <div class="text-container spotlight-container">
            <div class="rsvp-cat-name" id="spotlight-title">Kitty Spotlight</div>
        </div>
        <div class="text-container" id="cat-name-container">
            <div class="rsvp-cat-name">
                ${eventDetails.name}
            </div>
        </div>
        <div class="text-container ">
            <div class="info-txt">
                ${eventDetails.cat_description}
            </div>
        </div>
    </div>


</section>

<jsp:include page="../include/footer.jsp"/>