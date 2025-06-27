<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../admin/header.jsp" %>
<%@ include file="../admin/sidebar.jsp" %>

<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <h2><i class="fas fa-ticket-alt"></i> 🎫 할인 정책 설정</h2>
        </div>
    </section>

    <section class="content">
        <div class="container-fluid">
            <div class="card card-warning">
                <div class="card-header">
                    <h3 class="card-title">할인율 설정</h3>
                </div>
                <form action="DiscountServlet" method="post">
                    <div class="card-body">
                        <div class="form-group">
                            <label for="disabledRate">장애인 할인율 (%)</label>
                            <input type="number" class="form-control" id="disabledRate" name="disabledRate" value="50" min="0" max="100" required>
                        </div>
                        <div class="form-group">
                            <label for="compactRate">경차 할인율 (%)</label>
                            <input type="number" class="form-control" id="compactRate" name="compactRate" value="30" min="0" max="100" required>
                        </div>
                    </div>
                    <div class="card-footer">
                        <button type="submit" class="btn btn-warning">저장</button>
                    </div>
                </form>
            </div>
        </div>
    </section>
</div>

<%@ include file="../admin/footer.jsp" %>
