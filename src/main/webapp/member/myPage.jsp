<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../admin/header.jsp" %>
<%@ include file="../admin/sidebar.jsp" %>
<%@ page import="com.ndh1614.jsp_servlet_project_2505.dto.MemberDTO" %>
<%@ page import="com.ndh1614.jsp_servlet_project_2505.dao.MemberDAO" %>
<%@ page import="java.util.Objects" %>
<%@ page import="com.ndh1614.jsp_servlet_project_2505.domain.MemberVO" %>
<%
    MemberVO member = (MemberVO) session.getAttribute("member");
%>

<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <h2><i class="fas fa-user-plus"></i> 👤 회원 정보 수정</h2>
        </div>
    </section>

    <section class="content">
        <div class="container-fluid">
            <div class="card card-primary">
                <div class="card-header">
                    <h3 class="card-title">회원 정보 수정</h3>
                </div>
                <form action="../member/myPage_process.jsp" method="post">
                    <div class="card-body">
                        <div class="form-group">
                            <label for="carId">차량번호</label>
                            <input type="text" class="form-control" id="carId" name="carId" value=<%=member.getCarId()%>>
                        </div>
                        <div class="form-group">
                            <label for="password">비밀번호</label>
                            <input type="password" class="form-control" id="password" name="password" value=<%=member.getPassword()%>>
                        </div>
                        <div class="form-group">
                            <label for="password2">비밀번호 확인</label>
                            <input type="password" class="form-control" id="password2" name="password2" value=<%=member.getPassword()%>>
                        </div>
                        <div class="form-group">
                            <label for="name">이름</label>
                            <input type="text" class="form-control" id="name" name="name" value=<%=member.getName()%>>
                        </div>
                        <div class="form-group">
                            <label for="phone">연락처</label>
                            <input type="text" class="form-control" id="phone" name="phone" value=<%=member.getPhone()%>>
                        </div>
                        <div class="form-group">
                            <label for="type">유형</label>
                            <select class="form-control" id="type" name="type">
                                <option value="일반" <%= member.getType().equals("일반") ? "selected" : "" %>>일반</option>
                                <option value="경차" <%= member.getType().equals("경차") ? "selected" : "" %>>경차</option>
                                <option value="장애인" <%= member.getType().equals("장애인") ? "selected" : "" %>>장애인</option>
                            </select>

                        </div>
                        <div class="form-group">
                            <label for="monthPay">월정액 여부</label>
                            <input type="checkbox" class="form-control" id="monthPay" name="monthPay"
                            <%=member.isMonthPay() ? "checked" : "" %>>
                        </div>
                    </div>
                    <div class="card-footer">
                        <button type="submit" class="btn btn-primary">수정</button>
                    </div>
                    <script>
                        document.addEventListener('DOMContentLoaded', function () {
                            const frm = document.querySelector('form[name=frmAddMember]');
                            const submit = document.querySelector('input[type=submit]');
                            submit.addEventListener('click', (e) => {
                                e.preventDefault();
                                if (frm.password.value !== frm.password2.value) {
                                    alert("비밀번호가 틀렸습니다")
                                    return;
                                }

                                frm.submit();
                            })
                        })
                    </script>
                </form>
            </div>
        </div>
    </section>
</div>

<%@ include file="../admin/footer.jsp" %>
