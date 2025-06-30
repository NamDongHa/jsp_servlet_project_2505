<%@ page import="com.ndh1614.jsp_servlet_project_2505.dto.MemberDTO" %>
<%@ page import="com.ndh1614.jsp_servlet_project_2505.dao.MemberDAO" %>
<%@ page import="com.ndh1614.jsp_servlet_project_2505.domain.MemberVO" %>
<%@ page import="org.modelmapper.ModelMapper" %>
<%@ page import="com.ndh1614.jsp_servlet_project_2505.model.MemberRepository"%>
<%
  request.setCharacterEncoding("UTF-8");

  MemberDTO memberDTO = new MemberDTO();
  memberDTO.setCarId(request.getParameter("carId"));
  memberDTO.setPassword(request.getParameter("password"));
  memberDTO.setName(request.getParameter("name"));
  memberDTO.setPhone(request.getParameter("phone"));
  memberDTO.setType(request.getParameter("carType"));

  MemberDAO dao = MemberDAO.getInstance();
  dao.insertMember(memberDTO);

  response.sendRedirect("../main/main.jsp");
%>
