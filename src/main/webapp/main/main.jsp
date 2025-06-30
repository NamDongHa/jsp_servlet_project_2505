<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .background-video {
        position: fixed;
        right: 0;
        bottom: 0;
        min-width: 100%;
        min-height: 100%;
        z-index: -1;
        object-fit: cover;
    }

    .content-overlay {
        position: relative;
        z-index: 1;
    }
</style>
<head>
    <meta charset="UTF-8">
    <title>웹홈페이지</title>

    <!-- CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/fontawesome-free/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/adminlte.min.css">
</head>

<body class="hold-transition sidebar-mini">
<video class="background-video" autoplay muted loop>
    <source src="${pageContext.request.contextPath}/resource/3168cc75-de41-4034-b1a1-716bb9a1589c.mp4" type="video/mp4">
</video>

<div class="wrapper content-overlay">
    <%@ include file="../admin/sidebar.jsp" %>
    <%-- 본문 내용 --%>
</div>

<!-- JS -->
<script src="${pageContext.request.contextPath}/plugins/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/dist/js/adminlte.min.js"></script>
</body>