package com.ndh1614.jsp_servlet_project_2505.dao;


import com.ndh1614.jsp_servlet_project_2505.domain.MemberVO;
import lombok.Builder;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
class MemberDAOTest {
 MemberDAO memberDAO = new MemberDAO();
    @Test
    void insertMember() {
        MemberVO memberVO = MemberVO.builder()
                .carId("42")
                .name("ㅁㄴㅇㄹ")
                .password("123456")
                .phone("1888888888")
                .type("일반")
                .monthPay(true)
                .build();
        memberDAO.insertMember(memberVO);
        log.info(memberVO);
    }
}