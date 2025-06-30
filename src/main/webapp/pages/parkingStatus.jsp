<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../admin/header.jsp" %>
<%@ include file="../admin/sidebar.jsp" %>

<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <h2><i class="fas fa-parking"></i> 📍 실시간 주차 현황</h2>
        </div>
    </section>

    <section class="content">
        <div class="container-fluid">
            <div class="card card-info">
                <div class="card-header">
                    <h3 class="card-title">현재 주차 차량 목록</h3>
                </div>
                <div class="card-body">
                    <!-- 실시간 주차 차량 리스트 테이블 -->
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>주차공간번호</th>
                            <th>차량번호</th>
                            <th>입차 시간</th>
                            <th>차량 유형</th>
                            <th>회원 여부</th>
                        </tr>
                        </thead>
                        <tbody>
                        <!-- 예시 데이터 -->
                        <tr>
                            <td>1</td>
                            <td>12가3456</td>
                            <td>2025-06-27 10:00</td>
                            <td>일반</td>
                            <td>비회원</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>34나7890</td>
                            <td>2025-06-27 09:30</td>
                            <td>경차</td>
                            <td>월정액 회원</td>
                        </tr>
                        <!-- 실제 DB 데이터 반복 출력 -->
                        <tr>
                            <td>1</td>
                            <td>12가3456</td>
                            <td>2025-06-27 10:00</td>
                            <td>일반</td>
                            <td>비회원</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>34나7890</td>
                            <td>2025-06-27 09:30</td>
                            <td>경차</td>
                            <td>월정액 회원</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>12가3456</td>
                            <td>2025-06-27 10:00</td>
                            <td>일반</td>
                            <td>비회원</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>34나7890</td>
                            <td>2025-06-27 09:30</td>
                            <td>경차</td>
                            <td>월정액 회원</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>12가3456</td>
                            <td>2025-06-27 10:00</td>
                            <td>일반</td>
                            <td>비회원</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>34나7890</td>
                            <td>2025-06-27 09:30</td>
                            <td>경차</td>
                            <td>월정액 회원</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>12가3456</td>
                            <td>2025-06-27 10:00</td>
                            <td>일반</td>
                            <td>비회원</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>34나7890</td>
                            <td>2025-06-27 09:30</td>
                            <td>경차</td>
                            <td>월정액 회원</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>
</div>

<%@ include file="../admin/footer.jsp" %>
