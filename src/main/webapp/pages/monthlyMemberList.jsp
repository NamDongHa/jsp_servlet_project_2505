<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../admin/header.jsp" %>
<%@ include file="../admin/sidebar.jsp" %>

<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <h2><i class="fas fa-list"></i> 📄 월정액 회원 목록</h2>
        </div>
    </section>

    <section class="content">
        <div class="container-fluid">
            <div class="card card-secondary">
                <div class="card-header">
                    <h3 class="card-title">회원 목록</h3>
                </div>
                <div class="card-body">
                    <table class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>회원 번호</th>
                            <th>이름</th>
                            <th>연락처</th>
                            <th>차량번호</th>
                            <th>등록일</th>
                            <th>관리</th>
                        </tr>
                        </thead>
                        <tbody>
                        <!-- 예시 데이터 -->
                        <tr>
                            <td>1</td>
                            <td>홍길동</td>
                            <td>010-1234-5678</td>
                            <td>12가3456</td>
                            <td>2025-06-01</td>
                            <td>
                                <a href="MemberEditServlet?id=1" class="btn btn-sm btn-info">수정</a>
                                <a href="MemberDeleteServlet?id=1" class="btn btn-sm btn-danger" onclick="return confirm('정말 삭제하시겠습니까?');">삭제</a>
                            </td>
                        </tr>
                        <!-- 실제 회원 데이터 반복 출력 필요 -->
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>
</div>

<%@ include file="../admin/footer.jsp" %>
