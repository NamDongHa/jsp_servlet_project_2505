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
                <h2>➕ 추가 요금 설정</h2>
                <form action="FeeExtraServlet" method="post">
                    30분 추가 요금: <input type="number" name="extraFee" value="1000" /> 원<br />
                    <input type="submit" value="저장" />
                </form>
            </div>
        </section>
    </div>

</div>
<%@ include file="../admin/footer.jsp" %>
</body>
</html>
