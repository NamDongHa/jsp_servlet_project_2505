<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../admin/header.jsp" %>
<%@ include file="../admin/sidebar.jsp" %>

<c:if test="${not empty error}">
  <div class="alert alert-danger">${error}</div>
</c:if>

<div class="content-wrapper">
  <section class="content-header">
    <div class="container-fluid">
      <h2><i class="fas fa-car"></i> 출차 완료</h2>
    </div>
  </section>

  <section class="content">
    <div class="container-fluid">
      <div class="card card-success">
        <div class="card-header">
          <h3 class="card-title">출차 결과</h3>
        </div>
        <div class="card-body">
          <p><strong>차량 번호:</strong> ${carId}</p>
          <p><strong>주차 요금:</strong> ${fee} 원</p>
        </div>
        <div class="card-footer">
          <a href="<%= request.getContextPath() %>/pages/carSearch.jsp" class="btn btn-primary">돌아가기</a>
        </div>
      </div>
    </div>
  </section>
</div>

<%@ include file="../admin/footer.jsp" %>
