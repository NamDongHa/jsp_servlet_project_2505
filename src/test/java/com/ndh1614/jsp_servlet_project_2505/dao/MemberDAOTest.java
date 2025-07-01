package com.ndh1614.jsp_servlet_project_2505.dao;


import com.ndh1614.jsp_servlet_project_2505.domain.MemberVO;
import com.ndh1614.jsp_servlet_project_2505.dto.MemberDTO;
import lombok.Builder;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
class MemberDAOTest {
    MemberDAO memberDAO = MemberDAO.getInstance();

    @Test
    void insertMember() {
        MemberVO memberVO = MemberVO.builder()
                .carId("44")
                .name("ㅁㄴㅇㄹ")
                .password("123456")
                .phone("1888888888")
                .type("일반")
                .build();
        memberDAO.insertMember(memberVO);
        log.info(memberVO);
    }

    @Test
    void getMonthPayMember() {
        boolean month = true;
        List<MemberVO> members = memberDAO.selectMonthPayMembers(month);
        for (MemberVO m : members) {
            log.info("{}", m);
        }
    }
    @Test
    void getMemberById() {

    }
}