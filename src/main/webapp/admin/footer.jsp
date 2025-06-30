<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    body.main-page .main-footer {
        background-color: rgba(255, 255, 255, 0.7) !important;
        backdrop-filter: saturate(180%) blur(10px);
    }
</style>
<!-- ===== 푸터 영역 ===== -->
<footer class="main-footer">
    <strong>
        &copy; 2025 <a href="#">스마트주차 시스템</a>.
    </strong> All rights reserved.
    <div class="float-right d-none d-sm-inline-block">
        <b>버전</b> 1.0.0
    </div>  
</footer>

<!-- ===== JS 영역 ===== -->
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath}/dist/js/adminlte.min.js"></script>

<!-- 페이지별 추가 JS는 개별 JSP에서 작성 -->
