<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../admin/header.jsp" %>
<%@ include file="../admin/sidebar.jsp" %>

<div class="content-wrapper">
    <section class="content-header">
        <div class="container-fluid">
            <h2><i class="fas fa-coins"></i> 💰 기본 요금 설정</h2>
        </div>
    </section>

    <section class="content">
        <div class="container-fluid">
            <div class="card card-success">
                <div class="card-header">
                    <h3 class="card-title">기본 요금 설정</h3>
                </div>
                <form action="${pageContext.request.contextPath}/fee/insert" method="post" class="form-horizontal">
                    <div class="card-body">
                        <!-- 시간대 -->
                        <div class="form-group row">
                            <label for="timeType" class="col-sm-2 col-form-label">시간대</label>
                            <div class="col-sm-10">
                                <select class="form-control" id="timeType" name="timeType" required>
                                    <option value="주간">주간</option>
                                    <option value="야간">야간</option>
                                </select>
                            </div>
                        </div>

                        <!-- 기본 시간 -->
                        <div class="form-group row">
                            <label for="baseTime" class="col-sm-2 col-form-label">기본 시간 (분)</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" id="baseTime" name="baseTime" placeholder="기본 시간 입력" required>
                            </div>
                        </div>

                        <!-- 기본 요금 -->
                        <div class="form-group row">
                            <label for="baseFee" class="col-sm-2 col-form-label">기본 요금 (원)</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" id="baseFee" name="baseFee" placeholder="기본 요금 입력" required>
                            </div>
                        </div>

                        <!-- 추가 시간 단위 -->
                        <div class="form-group row">
                            <label for="unitTime" class="col-sm-2 col-form-label">추가 시간 단위 (분)</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" id="unitTime" name="unitTime" placeholder="추가 시간 단위 입력" required>
                            </div>
                        </div>

                        <!-- 추가 요금 -->
                        <div class="form-group row">
                            <label for="unitFee" class="col-sm-2 col-form-label">추가 요금 (원)</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" id="unitFee" name="unitFee" placeholder="추가 요금 입력" required>
                            </div>
                        </div>

                        <!-- 일일 최대 요금 -->
                        <div class="form-group row">
                            <label for="dailyMaxFee" class="col-sm-2 col-form-label">일일 최대 요금 (원)</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" id="dailyMaxFee" name="dailyMaxFee" placeholder="일일 최대 요금 입력" required>
                            </div>
                        </div>

                        <!-- 장애인 할인율 -->
                        <div class="form-group row">
                            <label for="discountDisabled" class="col-sm-2 col-form-label">장애인 할인율 (%)</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" id="discountDisabled" name="discountDisabled" placeholder="장애인 할인율 입력" required>
                            </div>
                        </div>

                        <!-- 경차 할인율 -->
                        <div class="form-group row">
                            <label for="discountCompact" class="col-sm-2 col-form-label">경차 할인율 (%)</label>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" id="discountCompact" name="discountCompact" placeholder="경차 할인율 입력" required>
                            </div>
                        </div>
                    </div>

                    <div class="card-footer">
                        <button type="submit" class="btn btn-success float-right">등록</button>
                    </div>
                </form>


            </div>
        </div>
    </section>
</div>

<%@ include file="../admin/footer.jsp" %>
