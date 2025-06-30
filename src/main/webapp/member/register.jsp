<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>스마트주차 시스템 | 회원가입</title>

    <!-- Google Font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="../../plugins/fontawesome-free/css/all.min.css">
    <!-- icheck bootstrap -->
    <link rel="stylesheet" href="../../plugins/icheck-bootstrap/icheck-bootstrap.min.css">
    <!-- AdminLTE -->
    <link rel="stylesheet" href="../../dist/css/adminlte.min.css">
</head>
<body class="hold-transition register-page">
<div class="register-box">
    <div class="card card-outline card-primary">
        <div class="card-header text-center">
            <a href="#" class="h1"><b>스마트주차</b> 시스템</a>
        </div>
        <div class="card-body">
            <p class="login-box-msg">회원가입을 진행해주세요</p>

            <form action="../../RegisterServlet" method="post">
                <div class="input-group mb-3">
                    <input type="text" name="carNumber" class="form-control" placeholder="차량번호 (예: 12가3456)" required>
                    <div class="input-group-append">
                        <div class="input-group-text"><span class="fas fa-car"></span></div>
                    </div>
                </div>

                <div class="input-group mb-3">
                    <input type="password" name="password" class="form-control" placeholder="비밀번호" required>
                    <div class="input-group-append">
                        <div class="input-group-text"><span class="fas fa-lock"></span></div>
                    </div>
                </div>

                <div class="input-group mb-3">
                    <input type="text" name="name" class="form-control" placeholder="이름" required>
                    <div class="input-group-append">
                        <div class="input-group-text"><span class="fas fa-id-card"></span></div>
                    </div>
                </div>

                <div class="input-group mb-3">
                    <input type="text" name="phone" class="form-control" placeholder="연락처 (010-0000-0000)" required>
                    <div class="input-group-append">
                        <div class="input-group-text"><span class="fas fa-phone"></span></div>
                    </div>
                </div>

                <!-- 차량 유형 선택 -->
                <div class="input-group mb-3">
                    <select name="carType" class="form-control" required>
                        <option value="">-- 차량 유형 선택 --</option>
                        <option value="일반">일반</option>
                        <option value="경차">경차</option>
                        <option value="장애인">장애인</option>
                    </select>
                    <div class="input-group-append">
                        <div class="input-group-text"><span class="fas fa-tags"></span></div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-8">
                        <a href="login.jsp" class="text-center">이미 계정이 있나요?</a>
                    </div>
                    <div class="col-4">
                        <button type="submit" class="btn btn-primary btn-block">가입</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- JS -->
<script src="../../plugins/jquery/jquery.min.js"></script>
<script src="../../plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="../../dist/js/adminlte.min.js"></script>
</body>
</html>