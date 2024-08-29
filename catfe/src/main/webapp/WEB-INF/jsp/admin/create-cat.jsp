<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section class="header">
    <h1 class="title">Create Cat</h1>
    <div class="title-hr"></div>
</section>

<section class="container">

    <form action="../../../admin/cats/new" method="post">
        <input type="hidden" name="id" value="${form.id}">
        <div class="row">
            <div class="col-6">
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" id="name" name="name" value="${form.name}"
                           placeholder="Cat Name" class="form-control">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-4">
                <div class="form-group">
                    <label for="name">Age</label>
                    <input type="number" id="age" name="age" value="${form.age}"
                           placeholder="Cat Age" class="form-control">
                </div>
            </div>
            <div class="col-8">
                <div class="form-group">
                    <label for="imageURL">Image URL</label>
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text">../../../pub/assets/imgs/cats/</span>
                        </div>
                        <input type="text" id="imageURL" name="imageURL" value="${form.imageURL}" class="form-control">
                    </div>

                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-2">
                <p style="border-bottom: rgba(32,30,28,0.7) 1px solid;">Gender</p>
                <div class="form-check gender-radio">
                    <input type="radio" id="gender1" class="form-check-input" name="gender" value="male" >
                    <label for="gender1" class="form-check-label">Male</label>
                </div>
                <div class="form-check gender-radio">
                    <input type="radio" id="gender2" class="form-check-input" name="gender" value="female">
                    <label for="gender2" class="form-check-label">Female</label>
                </div>
                <div class="form-check gender-radio">
                    <input type="radio" id="gender3" class="form-check-input" name="gender" value="undetermined">
                    <label for="gender3" class="form-check-label">Undetermined</label>
                </div>
            </div>
            <div class="col-10">
                <div class="form-group" style="padding-left: 1rem;">
                    <label for="description">Description</label>
                    <textarea id="description" name="description"
                              value="${form.description}"
                              placeholder="Cat Description" class="form-control">${form.description}</textarea>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="submit">
                <button type="submit" class="btn submit-btn">Submit</button>
            </div>
        </div>
    </form>
    <c:if test="${form.id != null}">
        <form action="../../../admin/cats/delete" method="post">
            <input type="hidden" name="id" value="${form.id}">
            <button type="submit" class="btn submit-btn">Delete Cat</button>
        </form>
    </c:if>
</section>
<jsp:include page="../include/footer.jsp"/>