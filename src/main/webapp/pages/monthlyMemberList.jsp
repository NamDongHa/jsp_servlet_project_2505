<%@ page import="com.ndh1614.jsp_servlet_project_2505.domain.MemberVO" %>
<%@ page import="com.ndh1614.jsp_servlet_project_2505.dao.MemberDAO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../admin/header.jsp" %>
<%@ include file="../admin/sidebar.jsp" %>

<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <h2><i class="fas fa-list"></i> 📄 월정액 회원 목록</h2>
        </div>
    </section>
    <%
        MemberDAO dao = MemberDAO.getInstance();
        List<MemberVO> memberList = dao.selectAllMembers();
    %>
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
                        <%
                            for (MemberVO member : memberList) {
                        %>
                        <!-- 예시 데이터 -->
                        <tr>
                            <td><%= member.getCarId() %></td>
                            <td><%= member.getName() %></td>
                            <td><%= member.getPhone() %></td>
                            <td><%= member.getCarId() %></td>
                            <td><%= member.getType() %></td>
                            <td>
                                <a href="MemberEditServlet?id=<%= member.getId() %>" class="btn btn-sm btn-info">수정</a>
                                <a href="MemberDeleteServlet?id=<%= member.getId() %>" class="btn btn-sm btn-danger" onclick="return confirm('정말 삭제하시겠습니까?');">삭제</a>
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
