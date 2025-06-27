<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../admin/header.jsp" %>
<%@ include file="../admin/sidebar.jsp" %>

<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <h2><i class="fas fa-calculator"></i> 🧮 요금 계산 테스트</h2>
        </div>
    </section>

    <section class="content">
        <div class="container-fluid">
            <div class="card card-primary">
                <div class="card-header">
                    <h3 class="card-title">테스트 입력</h3>
                </div>
                <form action="FeeTestServlet" method="get">
                    <div class="card-body">
                        <div class="form-group">
                            <label for="inTime">입차 시간</label>
                            <input type="datetime-local" class="form-control" id="inTime" name="inTime" required>
                        </div>
                        <div class="form-group">
                            <label for="outTime">출차 시간</label>
                            <input type="datetime-local" class="form-control" id="outTime" name="outTime" required>
                        </div>
                        <div class="form-group">
                            <label for="carType">차량 유형</label>
                            <select class="form-control" id="carType" name="carType">
                                <option value="일반">일반</option>
                                <option value="경차">경차</option>
                                <option value="장애인">장애인</option>
                            </select>
                        </div>
                        <div class="form-check">
                            <input type="checkbox" class="form-check-input" id="isMonthly" name="isMonthly">
                            <label class="form-check-label" for="isMonthly">월정액 회원 여부</label>
                        </div>
                    </div>
                    <div class="card-footer">
                        <button type="submit" class="btn btn-primary">요금 계산</button>
                    </div>
                </form>
            </div>
        </div>
    </section>
</div>

<%@ include file="../admin/footer.jsp" %>
