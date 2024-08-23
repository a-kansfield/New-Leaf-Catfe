<jsp:include page="../include/header.jsp"/>

<section class="header">
    <h1 class="title">Menu</h1>
    <div class="title-hr"></div>
</section>

<section class="container">
    <div class="menu-board">
        <div class="menu-board-center menu-grid">
            <div class="menu-title-container">
                <h2 class="menu-title">Menu</h2>
            </div>
            <div class="flex-row">
                <div class="drink-img-container">
                    <img class="drink-img" id="coffee-img" src="../../../pub/assets/imgs/menu/coffee-sm.png" alt="">
                </div>
                <div class="text-container drink-name-container">
                    <ul class="drink-name">
                        <li>Coffee</li>
                        <li>Macchiato</li>
                        <li>Latte</li>
                        <li>Cappuccino</li>
                    </ul>
                </div>
                <div class="text-container">
                    <ul class="price">
                        <li>$3.25</li>
                        <li>$4.25</li>
                        <li>$4.99</li>
                        <li>$3.99</li>
                    </ul>
                </div>
            </div>
            <div class="flex-row">
                <div class="text-container drink-name-container expand flex-right">
                    <ul class="drink-name">
                        <li>Black Tea</li>
                        <li>Chai</li>
                        <li>Earl Grey</li>
                        <li>Catnip Tea</li>
                    </ul>
                </div>
                <div class="text-container">
                    <ul class="price">
                        <li>$3.25</li>
                        <li>$4.99</li>
                        <li>$3.25</li>
                        <li>$3.99</li>
                    </ul>
                </div>
                <div class="drink-img-container">
                    <img class="drink-img" id="tea-img" src="../../../pub/assets/imgs/menu/tea-sm.png" alt="">
                </div>
            </div>
            <div class="flex-row">
                <div class="menu-subtitle-container">
                    <h2 class="menu-subtitle">Flavors</h2>
                </div>
            </div>
            <div class="flex-row bottom">
                <div class="drink-img-container">
                    <img class="drink-img" id="iced-coffee-img" src="../../../pub/assets/imgs/menu/iced-coffee-sm.png" alt="">
                </div>
                <div class="text-container drink-name-container">
                    <ul class="drink-name">
                        <li>Mocha</li>
                        <li>Caramel</li>
                        <li>Lavender</li>
                    </ul>
                </div>
                <div class="text-container drink-name-container">
                    <ul class="drink-name">
                        <li>Peppermint</li>
                        <li>Vanilla</li>
                        <li>Hazelnut</li>
                    </ul>
                </div>
                <div class="text-container expand flex-right" style="transform: rotate(10deg)">
                    Enjoy hot or iced!
                    <br>
                    Add for only $0.99
                </div>
            </div>

<%--            <div class="menu-text">--%>
<%--                <p> Coffee </p>--%>
<%--            </div>--%>


        </div>
    </div>
</section>
<jsp:include page="../include/footer.jsp"/>
