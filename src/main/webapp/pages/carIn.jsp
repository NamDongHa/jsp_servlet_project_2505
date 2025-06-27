<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<%@ include file="../admin/header.jsp" %>
<%@ include file="../admin/sidebar.jsp" %>

<div class="content-wrapper">
    <section class="content">
        <div class="container-fluid">
            <h2>🚘 차량 입차 등록</h2>
            <form action="CarInServlet" method="post">
                차량번호: <input type="text" name="carNumber" /><br />
                운전자명: <input type="text" name="driverName" /><br />
                연락처: <input type="text" name="contact" /><br />
                차량 유형:
                <select name="carType">
                    <option value="일반">일반</option>
                    <option value="경차">경차</option>
                    <option value="장애인">장애인</option>
                </select><br />
                월정액 회원 여부:
                <input type="checkbox" name="isMonthly" /><br />
                <input type="submit" value="입차 등록" />
            </form>
        </div>
    </section>
</div>

<%@ include file="../admin/footer.jsp" %>
