<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside class="main-sidebar sidebar-dark-primary elevation-4">
    <a href="#" class="brand-link">
        <span class="brand-text font-weight-light">스마트주차 반월당점</span>
    </a>

    <div class="sidebar">
        <nav class="mt-2">
            <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">

                <!-- 📦 차량 관리 -->
                <li class="nav-item has-treeview">
                    <a href="#" class="nav-link">
                        <i class="nav-icon fas fa-car"></i>
                        <p>차량 관리<i class="right fas fa-angle-left"></i></p>
                    </a>
                    <ul class="nav nav-treeview pl-3">
                        <li class="nav-item">
                            <a href="../pages/carIn.jsp" class="nav-link">
                                <i class="fas fa-sign-in-alt nav-icon"></i>
                                <p>차량 입차 등록</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="../pages/carOut.jsp" class="nav-link">
                                <i class="fas fa-sign-out-alt nav-icon"></i>
                                <p>차량 출차 처리</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="../pages/carSearch.jsp" class="nav-link">
                                <i class="fas fa-search nav-icon"></i>
                                <p>차량 정보 검색</p>
                            </a>
                        </li>
                    </ul>
                </li>

                <!-- 📦 주차 현황 -->
                <li class="nav-item has-treeview">
                    <a href="#" class="nav-link">
                        <i class="nav-icon fas fa-parking"></i>
                        <p>주차 현황<i class="right fas fa-angle-left"></i></p>
                    </a>
                    <ul class="nav nav-treeview pl-3">
                        <li class="nav-item">
                            <a href="../pages/parkingStatus.jsp" class="nav-link">
                                <i class="fas fa-circle nav-icon"></i>
                                <p>실시간 주차 현황</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="../pages/longParking.jsp" class="nav-link">
                                <i class="fas fa-clock nav-icon"></i>
                                <p>장기 주차 차량 조회</p>
                            </a>
                        </li>
                    </ul>
                </li>

                <!-- 📦 요금/할인 설정 -->
                <li class="nav-item has-treeview">
                    <a href="#" class="nav-link">
                        <i class="../pages/nav-icon fas fa-won-sign"></i>
                        <p>요금/할인 설정<i class="right fas fa-angle-left"></i></p>
                    </a>
                    <ul class="nav nav-treeview pl-3">
                        <li class="nav-item">
                            <a href="../pages/feeBasic.jsp" class="nav-link">
                                <i class="fas fa-coins nav-icon"></i>
                                <p>기본 요금 설정</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="../pages/feeExtra.jsp" class="nav-link">
                                <i class="fas fa-plus nav-icon"></i>
                                <p>추가 요금 설정</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="../pages/discountPolicy.jsp" class="nav-link">
                                <i class="fas fa-ticket-alt nav-icon"></i>
                                <p>할인 정책 설정</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="../pages/feeTest.jsp" class="nav-link">
                                <i class="fas fa-calculator nav-icon"></i>
                                <p>요금 계산 테스트</p>
                            </a>
                        </li>
                    </ul>
                </li>

                <!-- 📦 회원 관리 -->
                <li class="nav-item has-treeview">
                    <a href="#" class="nav-link">
                        <i class="nav-icon fas fa-user"></i>
                        <p>회원 관리<i class="right fas fa-angle-left"></i></p>
                    </a>
                    <ul class="nav nav-treeview pl-3">
                        <li class="nav-item">
                            <a href="../pages/memberRegister.jsp" class="nav-link">
                                <i class="fas fa-user-plus nav-icon"></i>
                                <p>월정액 회원 등록</p>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a href="../pages/monthlyMemberList.jsp" class="nav-link">
                                <i class="fas fa-list nav-icon"></i>
                                <p>월정액 회원 목록</p>
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </nav>
    </div>
</aside>
