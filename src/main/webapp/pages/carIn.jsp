<%@ page import="com.ndh1614.jsp_servlet_project_2505.service.ParkingService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../admin/header.jsp" %>
<%@ include file="../admin/sidebar.jsp" %>
<%
    int useSpot = ParkingService.INSTANCE.countCar();
%>
<%
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage != null) {
%>
<script>
    alert("<%= errorMessage %>");
</script>
<%
    }
%>

<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <div class="d-flex justify-content-between align-items-center">
                <h2><i class="fas fa-sign-in-alt"></i> 🚘 차량 입차 등록</h2>
                <div class="d-flex" style="gap: 10px;">
                    <span class="badge badge-success" style="font-size: 1.1rem; padding: 10px 15px;">전체 10대</span>
                    <span class="badge badge-danger" style="font-size: 1.1rem; padding: 10px 15px;">
                    주차 가능 자리 <%= 10 - useSpot %>대
                </span>
                </div>
            </div>
        </div>
    </section>
    <section class="content">
        <div class="container-fluid">
            <div class="card card-primary">
                <div class="card-header">
                    <h3 class="card-title">입차 정보 입력</h3>
                </div>
                <form action="/pages/CarInServlet" method="post">
                    <div class="card-body">
                        <div class="form-group">
                            <label for="carId">차량번호</label>
                            <input type="text" class="form-control" id="carId" name="carId"
                                   placeholder="예: 12가3456" required>
                        </div>
                        <div class="form-group">
                            <label for="name">운전자명</label>
                            <input type="text" class="form-control" id="name" name="name" required>
                        </div>
                        <div class="form-group">
                            <label for="phone">연락처</label>
                            <input type="text" class="form-control" id="phone" name="phone"
                                   placeholder="010-0000-0000">
                        </div>
                        <div class="form-group">
                            <label for="type">차량 유형</label>
                            <select class="form-control" name="type" id="type">
                                <option value="일반">일반</option>
                                <option value="경차">경차</option>
                                <option value="장애인">장애인</option>
                            </select>
                        </div>
                        <div class="form-check">
                            <input type="checkbox" class="form-check-input" id="monthPay" name="monthPay">
                            <label class="form-check-label" for="monthPay">월정액 회원 여부</label>
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

