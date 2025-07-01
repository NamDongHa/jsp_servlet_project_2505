<%@ page import="com.ndh1614.jsp_servlet_project_2505.domain.ParkingStatusVO" %>
<%@ page import="com.ndh1614.jsp_servlet_project_2505.domain.ParkingVO" %>
<%@ page import="com.ndh1614.jsp_servlet_project_2505.service.ParkingService" %>
<%@ page import="com.ndh1614.jsp_servlet_project_2505.dto.ParkingStatusDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../admin/header.jsp" %>
<%@ include file="../admin/sidebar.jsp" %>

<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <h2><i class="fas fa-parking"></i> 🔍 차량 정보 검색 결과</h2>
        </div>
    </section>

    <section class="content">
        <div class="container-fluid">
            <div class="card card-info">
                <div class="card-header">
                    <h3 class="card-title">차량 조회 결과</h3>
                </div>
                <div class="card-body">
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>차량 번호</th>
                            <th>입차 시간</th>
                            <th>차량 유형</th>
                            <th>월정액</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>${parkingStatusDTO.parkingDTO.carId}</td>
                            <td>${parkingStatusDTO.parkingDTO.carInTime}</td>
                            <td>${parkingStatusDTO.memberDTO.type}</td>
                            <td>${parkingStatusDTO.memberDTO.monthPay == true ? "O" : "X"}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>
</div>

<%@ include file="../admin/footer.jsp" %>
