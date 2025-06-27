<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../admin/header.jsp" %>
<%@ include file="../admin/sidebar.jsp" %>

<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <h2><i class="fas fa-clock"></i> 🕒 장기 주차 차량 조회</h2>
            <p>48시간 이상 주차된 차량 목록</p>
        </div>
    </section>

    <section class="content">
        <div class="container-fluid">
            <div class="card card-info">
                <div class="card-header">
                    <h3 class="card-title">장기 주차 차량 리스트</h3>
                </div>
                <div class="card-body">
                    <!-- 나중에 DB에서 받아온 리스트를 테이블 형태로 출력 -->
                    <!-- 예시 테이블 구조 -->
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>차량번호</th>
                            <th>입차 시간</th>
                            <th>주차 시간 (시간)</th>
                            <th>회원 여부</th>
                        </tr>
                        </thead>
                        <tbody>
                        <!-- 예시 데이터 -->
                        <tr>
                            <td>12가3456</td>
                            <td>2025-06-20 08:00</td>
                            <td>72</td>
                            <td>월정액 회원</td>
                        </tr>
                        <tr>
                            <td>34나7890</td>
                            <td>2025-06-21 09:30</td>
                            <td>50</td>
                            <td>비회원</td>
                        </tr>
                        <!-- 실제 데이터 반복 출력 -->
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>
</div>

<%@ include file="../admin/footer.jsp" %>
