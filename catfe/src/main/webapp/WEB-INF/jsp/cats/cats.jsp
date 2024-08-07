<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>
<section class="header">
    <h1 class="title">Cats</h1>
    <div class="title-hr"></div>
</section>

<section class="container cats-container">
    <c:forEach items="${cats}" var = "cat">
        <div class="cat-container">
            <div class="image-container circle-grow">
                <a href="/cats/${cat.id}"><img src=${cat.imageURL} alt="" class = "cat-image"></a>
            </div>
            <div class="text-container">
                <h2>${cat.name}</h2>
            </div>
        </div>
    </c:forEach>


</section>


<jsp:include page="../include/footer.jsp"/>