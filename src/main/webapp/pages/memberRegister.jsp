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
                <h2>👤 월정액 회원 등록</h2>
                <form action="MemberRegisterServlet" method="post">
                    이름: <input type="text" name="name" /><br />
                    연락처: <input type="text" name="contact" /><br />
                    차량번호: <input type="text" name="carNumber" /><br />
                    <input type="submit" value="등록" />
                </form>
            </div>
        </section>
    </div>

</div>
<%@ include file="../admin/footer.jsp" %>
</body>
</html>
