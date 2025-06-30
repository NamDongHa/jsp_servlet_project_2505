<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <title>웹홈페이지</title>
    <!-- CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/fontawesome-free/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/adminlte.min.css">
    <style>
        .content-wrapper {
            position: relative;
            height: 100vh;
            overflow: hidden;
        }

        .background-video {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            object-fit: cover;
            z-index: 0;
        }

        .overlay {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
            z-index: 1;
        }

        .main-content {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            z-index: 2;
            text-align: center;
            color: white;
            width: 100%;
            padding: 0 1rem;
        }

        .main-content h1 {
            font-size: 3rem;
            margin-bottom: 1rem;
        }

        .main-content p {
            font-size: 1.25rem;
            margin-bottom: 2rem;
        }

        .main-content .btn {
            padding: 0.75rem 1.5rem;
            font-size: 1rem;
        }
    </style>
</head>

<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">
    <%@ include file="../admin/header.jsp" %>
    <%@ include file="../admin/sidebar.jsp" %>

    <div class="content-wrapper">
        <!-- 🎞 Video Background -->
        <video class="background-video" autoplay muted loop>
            <source src="${pageContext.request.contextPath}/resource/3168cc75-de41-4034-b1a1-716bb9a1589c.mp4" type="video/mp4">
        </video>

        <!-- 🔲 Dark Overlay -->
        <div class="overlay"></div>

        <!-- 🌟 Foreground Content (정중앙 배치 완료) -->
        <div class="main-content">
            <h1>스마트주차 시스템</h1>
            <p>편리하고 빠른 차량 관리 솔루션</p>
            <a href="carIn.jsp" class="btn btn-primary">
                <i class="fas fa-sign-in-alt"></i> 입차 등록 바로가기
            </a>
        </div>
    </div>

    <%@ include file="../admin/footer.jsp" %>
</div>
<%
    out.println("세션 ID: " + session.getId());
    out.println("isAuth: " + session.getAttribute("isAuth"));
%>

<!-- JS -->
<script src="${pageContext.request.contextPath}/plugins/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/dist/js/adminlte.min.js"></script>
</body>
</html>
