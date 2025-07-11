-- auto-generated definition
create table admin
(
    adminId  varchar(50) not null
        primary key,
    password varchar(50) not null,
    name     varchar(50) not null
);

-- auto-generated definition
create table checkout
(
    carId      varchar(50)                not null,
    carOutTime datetime default curtime() not null
        primary key,
    parkingFee int                        null
);

-- auto-generated definition
create table feepolicy
(
    no          int auto_increment
        primary key,
    baseTime    int         not null,
    baseFee     int         not null,
    unitTime    int         not null,
    unitFee     int         not null,
    dailyMaxFee int         not null,
    discount    double      not null,
    timeType    varchar(10) null,
    carType     varchar(50) null,
    constraint chk_carType
        check (`carType` in ('경차', '일반', '장애인'))
);

-- auto-generated definition
create table member
(
    carId    varchar(50) not null
        primary key,
    name     varchar(50) not null,
    password varchar(50) not null,
    phone    varchar(50) not null,
    type     varchar(50) not null,
    monthPay tinyint(1)  not null
);

-- auto-generated definition
create table parking
(
    carId     varchar(50)                          not null
        primary key,
    carInTime datetime default current_timestamp() null
);

# 구현 해야할 기능
# 재욱
# 1. 차량 입차 등록
# 2. 차량 출차 관리
# 3. 차량 정보 검색
# 4. 실시간 주차 현황
# 5. 장기 주차 차량 조회
#
# 남동하
# 6. 기본 요금 설정
# 7. 추가 요금 설정
# 8. 할인 정책 설정
# 9. 출차 시 요금 계산
#
# 설현오
# 10. 월정액 회원 등록
# 11. 월정액 회원 목록
# 12. 주차장 기본 정보 설정
# 13. 회원가입
# 14. 로그인/로그아웃
