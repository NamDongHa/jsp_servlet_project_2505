<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../admin/header.jsp" %>
<%@ include file="../admin/sidebar.jsp" %>

<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <h2><i class="fas fa-search"></i> 🔍 차량 정보 검색</h2>
        </div>
    </section>

    <section class="content">
        <div class="container-fluid">
            <div class="card card-info">
                <div class="card-header">
                    <h3 class="card-title">차량번호로 검색</h3>
                </div>
                <form action="CarSearchServlet" method="get">
                    <div class="card-body">
                        <div class="form-group">
                            <label for="carNumber">차량번호</label>
                            <input type="text" class="form-control" id="carNumber" name="carNumber" placeholder="예: 12가3456" required>
                        </div>
                    </div>
                    <div class="card-footer">
                        <button type="submit" class="btn btn-info">검색</button>
                    </div>
                </form>
            </div>
        </div>
    </section>
</div>

<%@ include file="../admin/footer.jsp" %>
