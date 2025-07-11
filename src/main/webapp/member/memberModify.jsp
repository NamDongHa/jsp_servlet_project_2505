<%@ page import="com.ndh1614.jsp_servlet_project_2505.domain.MemberVO" %>
<%@ page import="com.ndh1614.jsp_servlet_project_2505.dao.MemberDAO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../admin/header.jsp" %>
<%@ include file="../admin/sidebar.jsp" %>
<%
    String monthPayParam = request.getParameter("monthPay");
    MemberDAO dao = MemberDAO.getInstance();
    List<MemberVO> memberList;

    if ("true".equals(monthPayParam)) {
        memberList = dao.selectMonthPayMembers(true);   // 월정액 회원만
    } else if ("false".equals(monthPayParam)) {
        memberList = dao.selectMonthPayMembers(false);  // 비월정액 회원만
    } else {
        memberList = dao.selectAllMembers();       // 전체
    }
%>

<div class="content-wrapper">
    <section class="content-header">
        <form method="get" action="memberList.jsp" class="form-inline mt-2">
            <label for="monthPay" class="mr-2">월정액 여부:</label>
            <select name="monthPay" id="monthPay" class="form-control mr-2" onchange="this.form.submit()">
                <option value="">전체</option>
                <option value="true" <%= "true".equals(request.getParameter("monthPay")) ? "selected" : "" %>>월정액</option>
                <option value="false" <%= "false".equals(request.getParameter("monthPay")) ? "selected" : "" %>>비월정액</option>
            </select>
        </form>

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
                            <th>차량 번호</th>
                            <th>이름</th>
                            <th>연락처</th>
                            <th>유형</th>
                            <th>월정액 여부</th>
                            <th>관리</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for (MemberVO member : memberList) {
                        %>
                        <!-- 예시 데이터 -->
                        <form method="post" action="<%= request.getContextPath() %>/memberModify">
                            <input type="hidden" name="oldCarId" value="<%= member.getCarId() %>">
                            <input type="hidden" name="password" value="<%= member.getPassword() %>" />
                            <tr>
                                <td><input type="text" name="carId" value="<%= member.getCarId() %>" class="form-control" /></td>
                                <td><input type="text" name="name" value="<%= member.getName() %>" class="form-control" /></td>
                                <td><input type="text" name="phone" value="<%= member.getPhone() %>" class="form-control" /></td>
                                <td>
                                    <select name="type" class="form-control">
                                        <option value="일반" <%= member.getType().equals("일반") ? "selected" : "" %>>일반</option>
                                        <option value="경차" <%= member.getType().equals("경차") ? "selected" : "" %>>경차</option>
                                        <option value="장애인" <%= member.getType().equals("장애인") ? "selected" : "" %>>장애인</option>
                                    </select>
                                </td>
                                <td>
                                    <input type="checkbox" name="monthPay" value="true" <%= member.isMonthPay() ? "checked" : "" %> />
                                </td>
                                <td>
                                    <button type="submit" class="btn btn-sm btn-primary">수정</button>
                                </td>
                            </tr>
                        </form>

                        <!-- 실제 회원 데이터 반복 출력 필요 -->
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>
</div>

<%@ include file="../admin/footer.jsp" %>