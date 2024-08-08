<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section class="header">
    <h1 class="title">Create Event</h1>
    <div class="title-hr"></div>
</section>
<section class="container">

    <form action="../../../admin/events/new" method="post">

        <input type="hidden" name="id" value="${form.id}">
        <div class="row">
            <div class="col-12">
                <div class="form-group">
                    <label for="title">Title</label>
                    <input type="text" id="title" name="title" value="${form.title}"
                           placeholder="Event Title" class="form-control">
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description"
                          value="${form.description}"
                          placeholder="Event Description" class="form-control">${form.description}</textarea>
            </div>
        </div>

        <div class="row">

            <div class="col-6">
                <div class="form-group">
                    <label for="startDate">Start Date</label>
                    <input type="datetime-local" id="startDate" name="startDate" value="${form.startDate}" class="form-control">
                </div>
            </div>
            <div class="col-6">
                <div class="form-group">
                    <label for="endDate">End Date</label>
                    <input type="datetime-local" id="endDate" name="endDate" value="${form.endDate}" class="form-control">
                </div>
            </div>

        </div> <%-- End Row --%>

        <div class="row">
            <div class="col-4">
                <div class="form-group">
                    <label for="capacity">Capacity</label>
                    <input type="number" id="capacity" name="capacity" value="${form.capacity}" class="form-control">
                </div>
            </div>
            <div class="col-4">
                <div class="form-group">
                    <label for="imageURL">Image URL</label>
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text">../../../pub/assets/imgs/events/</span>
                        </div>
                        <input type="text" id="imageURL" name="imageURL" value="${form.imageURL}" class="form-control">
                    </div>

                </div>
            </div>
            <div class="col-4">

                <div class="form-group">
                    <label for="featuredCat">Featured Cat</label>
                    <select id="featuredCat" name="featuredCat" value="${form.featuredCat}" placeholder="Featured Cat" class="form-select">

                        <option disabled selected value>-- Select a Cat --</option>
                        <c:forEach items="${cats}" var="cat">
                            <option value="${cat.id}"
                                    <c:if test="${cat.id.toString() == eventCatId.toString()} ">
                                        selected="selected"
                                    </c:if>
                            >${cat.name}
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </div> <%-- End Row --%>

        <div class="row">
            <div class="form-check">
                <input type="checkbox" id="servesAlcohol" name="servesAlcohol" value="servesAlcohol" <c:if test="${form.servesAlcohol}">checked</c:if> class="form-check-input">
                <label for="servesAlcohol" class="form-check-label">Serves Alcohol</label>
            </div>
        </div>
        <div class="row">
            <div class="submit">
                <button type="submit" class="btn submit-btn">Submit</button>
            </div>
        </div>

    </form>

</section>


<jsp:include page="../include/footer.jsp"/>