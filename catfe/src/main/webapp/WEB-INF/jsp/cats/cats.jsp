<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>
<section class="header">
    <h1 class="title">Cats</h1>
    <div class="title-hr"></div>
</section>


<%--</style>--%>

<!-- Swiper -->
<section class="container swiper-container">
    <div class="swiper mySwiper">
        <div class="swiper-wrapper">
            <c:forEach items="${cats}" var = "cat">
                <div class="swiper-slide">
                    <div class="image-container circle-grow">
                        <a href="/cats/${cat.id}">
                            <img class="swiper-slide-img" src="${cat.imageURL}" alt="">
                        </a>
                    </div>
                    <div class="text-container">
                            ${cat.name}
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="swiper-button-next"></div>
        <div class="swiper-button-prev"></div>
    </div>
    <div class="swiper-btns">

    </div>

</section>


<!-- Swiper JS -->
<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>

<!-- Initialize Swiper -->
<script>
    let swiper = new Swiper(".mySwiper", {
        slidesPerView:4,
        centeredSlides: true,
        spaceBetween: 100,
        loop: true,
        effect: 'coverflow',
        coverflowEffect: {
            rotate: 0,
            stretch: 0,
            depth:400,
            slideShadows: false,
        },
        navigation: {
            nextEl: ".swiper-button-next",
            prevEl: ".swiper-button-prev",
        },
    });
</script>


<%--<section class="container cats-container">--%>
<%--    <c:forEach items="${cats}" var = "cat">--%>
<%--        <div class="cat-container">--%>
<%--            <div class="image-container circle-grow">--%>
<%--                <a href="/cats/${cat.id}"><img src=${cat.imageURL} alt="" class = "cat-image"></a>--%>
<%--            </div>--%>
<%--            <div class="text-container">--%>
<%--                <h2>${cat.name}</h2>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </c:forEach>--%>

<%--str1 eq str2--%>

<%--</section>--%>


<jsp:include page="../include/footer.jsp"/>