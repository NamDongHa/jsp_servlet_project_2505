<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../admin/header.jsp" %>
<%@ include file="../admin/sidebar.jsp" %>

<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <h2><i class="fas fa-user-plus"></i> 👤 월정액 회원 등록</h2>
        </div>
    </section>

    <section class="content">
        <div class="container-fluid">
            <div class="card card-primary">
                <div class="card-header">
                    <h3 class="card-title">회원 정보 입력</h3>
                </div>
                <form action="MemberRegisterServlet" method="post">
                    <div class="card-body">
                        <div class="form-group">
                            <label for="name">이름</label>
                            <input type="text" class="form-control" id="name" name="name" placeholder="이름 입력" required>
                        </div>
                        <div class="form-group">
                            <label for="contact">연락처</label>
                            <input type="text" class="form-control" id="contact" name="contact" placeholder="010-0000-0000" required>
                        </div>
                        <div class="form-group">
                            <label for="carNumber">차량번호</label>
                            <input type="text" class="form-control" id="carNumber" name="carNumber" placeholder="예: 12가3456" required>
                        </div>
                    </div>
                    <div class="card-footer">
                        <button type="submit" class="btn btn-primary">등록</button>
                    </div>
                </form>
            </div>
        </div>
    </section>
</div>

<%@ include file="../admin/footer.jsp" %>
