<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../admin/header.jsp" %>
<%@ include file="../admin/sidebar.jsp" %>

<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <h2><i class="fas fa-coins"></i> 💰 기본 요금 설정</h2>
        </div>
    </section>

    <section class="content">
        <div class="container-fluid">
            <div class="card card-success">
                <div class="card-header">
                    <h3 class="card-title">기본 요금 설정</h3>
                </div>
                <form action="FeeBasicServlet" method="post">
                    <div class="card-body">
                        <div class="form-group">
                            <label for="baseFee">1시간 기본 요금</label>
                            <div class="input-group">
                                <input type="number" class="form-control" id="baseFee" name="baseFee" value="2000" min="0" required>
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
