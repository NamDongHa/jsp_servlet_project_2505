<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../admin/header.jsp" %>
<%@ include file="../admin/sidebar.jsp" %>

<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <h2><i class="fas fa-tools"></i> 🛠 주차장 기본 정보 설정</h2>
        </div>
    </section>

    <section class="content">
        <div class="container-fluid">
            <div class="card card-warning">
                <div class="card-header">
                    <h3 class="card-title">기본 정보 입력</h3>
                </div>
                <form action="SettingServlet" method="post">
                    <div class="card-body">
                        <div class="form-group">
                            <label for="parkingName">주차장 이름</label>
                            <input type="text" class="form-control" id="parkingName" name="parkingName" placeholder="예: 스마트주차 반월당점" required>
                        </div>
                        <div class="form-group">
                            <label for="address">주소</label>
                            <input type="text" class="form-control" id="address" name="address" placeholder="예: 대구광역시 중구 반월당로 ..." required>
                        </div>
                        <div class="form-group">
                            <label for="phone">연락처</label>
                            <input type="text" class="form-control" id="phone" name="phone" placeholder="예: 053-123-4567" required>
                        </div>
                        <div class="form-group">
                            <label for="totalSpaces">총 주차 공간 수</label>
                            <input type="number" class="form-control" id="totalSpaces" name="totalSpaces" min="0" required>
                        </div>
                    </div>
                    <div class="card-footer">
                        <button type="submit" class="btn btn-warning">저장</button>
                    </div>
                </form>
            </div>
        </div>
    </section>
</div>

<%@ include file="../admin/footer.jsp" %>
