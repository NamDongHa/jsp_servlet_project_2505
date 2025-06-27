<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../admin/header.jsp" %>
<%@ include file="../admin/sidebar.jsp" %>

<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <h2><i class="fas fa-plus"></i> ➕ 추가 요금 설정</h2>
        </div>
    </section>

    <section class="content">
        <div class="container-fluid">
            <div class="card card-success">
                <div class="card-header">
                    <h3 class="card-title">추가 요금 설정</h3>
                </div>
                <form action="FeeExtraServlet" method="post">
                    <div class="card-body">
                        <div class="form-group">
                            <label for="extraFee">30분 추가 요금</label>
                            <div class="input-group">
                                <input type="number" class="form-control" id="extraFee" name="extraFee" value="1000" min="0" required>
                                <div class="input-group-append">
                                    <span class="input-group-text">원</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card-footer">
                        <button type="submit" class="btn btn-success">저장</button>
                    </div>
                </form>
            </div>
        </div>
    </section>
</div>

<%@ include file="../admin/footer.jsp" %>
