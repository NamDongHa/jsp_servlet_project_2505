package com.ndh1614.jsp_servlet_project_2505.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    void setUp() {
        memberService = MemberService.INSTANCE;
    }

    @Test
    void isRightMemberTest() {
        String carId = "42";
        String name = "ㅁㄴㅇㄹ";
        String phone = "111";
        String type = "장애인";
        boolean monthPay = true;

        log.info(memberService.isRightMember(carId, name, phone, type, monthPay));
    }
}