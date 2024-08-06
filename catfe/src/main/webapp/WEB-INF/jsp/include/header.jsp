<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!---- Reset ------>
    <link rel="stylesheet" href="/pub/css/reset.css">

    <!------- BootStrap 5 ------->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">


    <!------- CSS ------->
    <link rel="stylesheet" href="/pub/css/fonts.css">
    <link rel="stylesheet" href="/pub/css/style.css">

    <link rel="stylesheet" href="/pub/css/nav.css">
    <link rel="stylesheet" href="/pub/css/landing.css">
    <link rel="stylesheet" href="/pub/css/events.css">
    <link rel="stylesheet" href="/pub/css/cats.css">
    <link rel="stylesheet" href="/pub/css/account.css">
    <link rel="stylesheet" href="/pub/css/table.css">
    <link rel="stylesheet" href="/pub/css/form.css">

    <!------- Fonts ------->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Comfortaa:wght@300..700&display=swap" rel="stylesheet">

    <title>New Leaf Catfe :: ${pageGroup}</title>
</head>
<body>
<nav class="navbar fixed-top navbar-expand-lg">

    <!-- Show on mobile to medium -->
    <a href="#" class="navbar-brand d-lg-none">
        New Leaf Catfe
    </a>

    <button
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarNav"
            class="navbar-toggler"
    >
        <span class="navbar-toggler-icon"></span>
    </button>

    <div id="nav-shine">
        <div class="hover-shape hover-sm"></div>
        <div class="hover-shape hover-lg"></div>
    </div>



    <div class="collapse navbar-collapse justify-content-between overflow-visible" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a href="/" class="nav-link active">
                    Home
                </a>
            </li>
            <li class="nav-item">
                <a href="/cats/" class="nav-link">
                    Cats
                </a>
            </li>
            <li class="nav-item">
                <a href="/menu/" class="nav-link">
                    Menu
                </a>
            </li>

        </ul>

        <a href="#" class="navbar-brand d-none d-lg-block" id="custom-logo-positioning">
            <img
                    class="d-inline-block align-top"
                    src="/pub/assets/logo/SVG/new-leaf-logo.svg" alt="" />
        </a>
        <ul class="navbar-nav">
            <sec:authorize access="hasAuthority('ADMIN')">
            <li class="nav-item">
                <div class="dropdown">
                    <button class="btn dropdown-toggle" type="button" id="admin-dropdown" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Admin
                    </button>
                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                        <a href="/admin/cats" class="dropdown-item">Cats</a>
                        <a href="/admin/events" class="dropdown-item">Events</a>
                    </div>
                </div>
            </li>
            </sec:authorize>
            <li class="nav-item">
                <a href="/events/" class="nav-link">
                    Events
                </a>
            </li>

<%--            <li class="nav-item">--%>
<%--                <a href="../home/index.html" class="nav-link">--%>
<%--                    Schedule--%>
<%--                </a>--%>
<%--            </li>--%>
            <li class="nav-item">
                <a href="/about" class="nav-link">
                    About
                </a>
            </li>


            <li class="nav-item login-container">
                <ul class="navbar-nav">
                    <sec:authorize access="!isAuthenticated()">
                        <li class="nav-item" id= "login-btn">
                            <a href="/account/login" class="nav-link" id="login-link">
                                Login
                            </a>
                        </li>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <li class="nav-item" id="login-btn">
                            <a href="/account/logout" class="nav-link">
                                Logout
                            </a>
                        </li>
                    </sec:authorize>
                    <li class="nav-item">
                        <div class="login-divider"></div>
                    </li>
                    <sec:authorize access="!isAuthenticated()">
                    <li class="nav-item" id="sign-up-btn">
                        <a href="/account/sign-up" class="nav-link" id="sign-up-link">
                            Sign Up
                        </a>
                    </li>
                    </sec:authorize>
                    <sec:authorize access="isAuthenticated()">
                        <li class="nav-item" id="username_email" >
                            <sec:authentication property="name"/>
                        </li>
                    </sec:authorize>
                </ul>
            </li>

        </ul>
    </div>
</nav>


<!-- END NAV -->