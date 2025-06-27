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
                <h2>🎫 할인 정책 설정</h2>
                <form action="DiscountServlet" method="post">
                    장애인 할인율 (%): <input type="number" name="disabledRate" value="50" /><br />
                    경차 할인율 (%): <input type="number" name="compactRate" value="30" /><br />
                    <input type="submit" value="저장" />
                </form>
            </div>
        </section>
    </div>

</div>
<%@ include file="../admin/footer.jsp" %>
</body>
</html>
