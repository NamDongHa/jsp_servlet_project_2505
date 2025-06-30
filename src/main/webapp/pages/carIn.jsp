<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../admin/header.jsp" %>
<%@ include file="../admin/sidebar.jsp" %>

<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <h2><i class="fas fa-sign-in-alt"></i> 🚘 차량 입차 등록</h2>
        </div>
    </section>

    <section class="content">
        <div class="container-fluid">
            <div class="card card-primary">
                <div class="card-header">
                    <h3 class="card-title">입차 정보 입력</h3>
                </div>
                <form action="CarInServlet" method="post">
                    <div class="card-body">
                        <div class="form-group">
                            <label for="carNumber">차량번호</label>
                            <input type="text" class="form-control" id="carNumber" name="carNumber"
                                   placeholder="예: 12가3456" required>
                        </div>
                        <div class="form-group">
                            <label for="driverName">운전자명</label>
                            <input type="text" class="form-control" id="driverName" name="driverName" required>
                        </div>
                        <div class="form-group">
                            <label for="contact">연락처</label>
                            <input type="text" class="form-control" id="contact" name="contact"
                                   placeholder="010-0000-0000">
                        </div>
                        <div class="form-group">
                            <label for="carType">차량 유형</label>
                            <select class="form-control" name="carType" id="carType">
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
                        <button type="submit" class="btn btn-primary">입차 등록</button>
                    </div>
                </form>
            </div>
        </div>
    </section>
</div>
<%@ include file="../admin/footer.jsp" %>

