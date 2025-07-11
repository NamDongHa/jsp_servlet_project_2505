<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../admin/header.jsp" %>
<%@ include file="../admin/sidebar.jsp" %>

<div class="content-wrapper">
    <section class="content-header">
        <h2>출차 완료</h2>
    </section>

    <section class="content">
        <p>차량번호: ${carId}</p>
        <p>최종 주차 요금: <strong>${fee}</strong> 원</p>
        <a href="../main/main.jsp" class="btn btn-primary">메인으로</a>
    </section>
</div>

<%@ include file="../admin/footer.jsp" %>