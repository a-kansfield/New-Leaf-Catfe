<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section class="header">
    <h1 class="title">Sign Up</h1>
    <div class="title-hr"></div>
</section>


<section class="container login-form-container">
    <div class="form-container">
        <form action="/account/sign-up" id="login-form" method = "post">
            <div class="form-group">
                <label for="email" class="form-label">Email</label>
                <input type="text" id="email" name="email" class="form-control" value="${form.email}">
            </div>
            <div class="form-group">
                <label for="password" class="form-label">Password</label>
                <input type="password" id="password" name="password" class="form-control" value="${form.password}">
            </div>
            <div class="separator">

            </div>
            <div class="form-group">
                <label for="firstName" class="form-label">First Name</label>
                <input type="text" id="firstName" name="firstName" class="form-control" value="${form.firstName}">
            </div>

            <div class="form-group">
                <label for="lastName" class="form-label">Last Name</label>
                <input type="text" id="lastName" name="lastName" class="form-control" value="${form.lastName}">
            </div>



            <button type="submit" class="btn">Submit</button>
        </form>
    </div>
    <div class="first-name-container">

    </div>
</section>

<jsp:include page="../include/footer.jsp"/>