<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<%@ include file="../admin/header.jsp" %>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">

    <%@ include file="../admin/sidebar.jsp" %>

    <div class="content-wrapper">
        <section class="content">
            <div class="container-fluid">
                <h2>🧮 요금 계산 테스트</h2>
                <form action="FeeTestServlet" method="get">
                    입차 시간: <input type="datetime-local" name="inTime" /><br />
                    출차 시간: <input type="datetime-local" name="outTime" /><br />
                    차량 유형:
                    <select name="carType">
                        <option value="일반">일반</option>
                        <option value="경차">경차</option>
                        <option value="장애인">장애인</option>
                    </select><br />
                    월정액 회원 여부:
                    <input type="checkbox" name="isMonthly" /><br />
                    <input type="submit" value="요금 계산" />
                </form>
            </div>
        </section>
    </div>

</div>
<%@ include file="../admin/footer.jsp" %>
</body>
</html>
