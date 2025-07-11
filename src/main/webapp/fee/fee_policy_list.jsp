<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../admin/header.jsp" %>
<%@ include file="../admin/sidebar.jsp" %>

<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <h2><i class="fas fa-list"></i> 📋 요금 정책 목록</h2>
        </div>
    </section>

    <section class="content">
        <div class="container-fluid">
            <div class="card card-info">
                <div class="card-header">
                    <h3 class="card-title">등록된 요금 정책 목록</h3>
                </div>
                <div class="card-body table-responsive p-0">
                    <table class="table table-hover text-nowrap">
                        <thead>
                        <tr>
                            <th>주간/야간</th>
                            <th>기본시간 (분)</th>
                            <th>기본요금 (원)</th>
                            <th>단위시간 (분)</th>
                            <th>단위요금 (원)</th>
                            <th>일일최대요금 (원)</th>
                            <th>장애인 할인 (%)</th>
                            <th>경차 할인 (%)</th>
                            <th>차종</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:choose>
                            <c:when test="${not empty feePolicyList}">
                                <c:forEach var="policy" items="${feePolicyList}">
                                    <tr>
                                        <td>${policy.timeType}</td>
                                        <td>${policy.baseTime}</td>
                                        <td>${policy.baseFee}</td>
                                        <td>${policy.unitTime}</td>
                                        <td>${policy.unitFee}</td>
                                        <td>${policy.dailyMaxFee}</td>
                                        <td>${policy.discountDisabled}</td>
                                        <td>${policy.discountCompact}</td>
                                        <td>${policy.carType}</td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td colspan="7" style="text-align:center;">등록된 요금 정책이 없습니다.</td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>
</div>

<%@ include file="../admin/footer.jsp" %>
