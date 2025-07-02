<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="../admin/header.jsp" %>
<%@ include file="../admin/sidebar.jsp" %>

<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <h2><i class="fas fa-clock"></i> 🕒 장기 주차 차량 조회</h2>
            <p>48시간 이상 주차된 차량 목록</p>
        </div>
    </section>

    <section class="content">
        <div class="container-fluid">
            <div class="card card-info">
                <div class="card-header">
                    <h3 class="card-title">장기 주차 차량 리스트</h3>
                </div>
                <div class="card-body">
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>차량번호</th>
                            <th>입차 시간</th>
                            <th>주차 시간 (분)</th>
                            <th>회원 여부</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="status" items="${longTermList}">
                            <tr>
                                <td>${status.parkingDTO.carId}</td>
                                <td>${status.parkingDTO.carInTime}</td>
                                <td>${status.parkingMinute}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${status.memberDTO.monthPay}">월정액 회원</c:when>
                                        <c:otherwise>일반 회원</c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>
</div>

<%@ include file="../admin/footer.jsp" %>
