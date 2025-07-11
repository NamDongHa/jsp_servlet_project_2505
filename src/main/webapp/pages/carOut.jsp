<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../admin/header.jsp" %>
<%@ include file="../admin/sidebar.jsp" %>
<%
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage != null) {
%>
<script>
    alert("<%= errorMessage.replace("\"", "\\\"").replace("\n", "\\n") %>");
    window.location.href = "<%= request.getContextPath() %>/pages/carOut.jsp";
</script>
<%
    }
%>

<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <h2><i class="fas fa-sign-out-alt"></i> 🚪 차량 출차 처리</h2>
        </div>
    </section>

    <section class="content">
        <div class="container-fluid">
            <div class="card card-danger">
                <div class="card-header">
                    <h3 class="card-title">출차 정보 입력</h3>
                </div>
                <form action="/checkout" method="post">
                    <div class="card-body">
                        <div class="form-group">
                            <label for="carId">차량번호</label>
                            <input type="text" class="form-control" id="carId" name="carId" placeholder="예: 12가3456" required>
                        </div>
                    </div>
                    <div class="card-footer">
                        <button type="submit" class="btn btn-danger">출차 처리</button>
                    </div>
                </form>
            </div>
        </div>
    </section>
</div>

<%@ include file="../admin/footer.jsp" %>
