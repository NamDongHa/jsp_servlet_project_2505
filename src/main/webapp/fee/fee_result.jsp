<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../admin/header.jsp" %>
<%@ include file="../admin/sidebar.jsp" %>

<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <h2>요금 계산 결과</h2>
        </div>
    </section>
    <section class="content">
        <div class="container-fluid">
            <div class="card card-primary">
                <div class="card-body">
                    <h3>계산된 주차 요금: <strong><%= request.getAttribute("calculatedFee") %></strong> 원</h3>
                    <a href="feeTest.jsp" class="btn btn-secondary mt-3">다시 계산하기</a>
                </div>
            </div>
        </div>
    </section>
</div>

<%@ include file="../admin/footer.jsp" %>
