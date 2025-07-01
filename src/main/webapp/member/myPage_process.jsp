<%@ page import="com.ndh1614.jsp_servlet_project_2505.dto.MemberDTO" %>
<%@ page import="com.ndh1614.jsp_servlet_project_2505.dao.MemberDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    MemberDAO memberDAO = MemberDAO.getInstance();
    MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
    String oldCarId = memberDTO.getCarId();
    memberDTO = MemberDTO.builder()
            .carId(request.getParameter("carId"))
            .name(request.getParameter("name"))
            .type(request.getParameter("type"))
            .phone(request.getParameter("phone"))
            .monthPay(request.getParameter("monthPay") != null)
            .password(request.getParameter("password"))
            .build();
    memberDAO.updateMember(memberDTO, oldCarId);
    session.setAttribute("member", memberDTO);
    response.sendRedirect("../main/main.jsp");
%>
</body>
</html>
