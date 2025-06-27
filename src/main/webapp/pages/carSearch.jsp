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
                <h2>🔍 차량 정보 검색</h2>
                <form action="CarSearchServlet" method="get">
                    차량번호: <input type="text" name="carNumber" />
                    <input type="submit" value="검색" />
                </form>
            </div>
        </section>
    </div>

</div>
<%@ include file="../admin/footer.jsp" %>
</body>
</html>
