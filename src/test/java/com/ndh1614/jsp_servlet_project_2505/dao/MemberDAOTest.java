package com.ndh1614.jsp_servlet_project_2505.dao;


import com.ndh1614.jsp_servlet_project_2505.domain.MemberVO;
import com.ndh1614.jsp_servlet_project_2505.dto.MemberDTO;
import lombok.Builder;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
class MemberDAOTest {
 MemberDAO memberDAO = MemberDAO.getInstance();
    @Test
    void insertMember() {
        MemberDTO memberDTO = MemberDTO.builder()
                .carId("55")
                .name("ㅁㄴㅇㄹ")
                .password("123456")
                .phone("1888888888")
                .type("일반")
                .build();
        memberDAO.insertMember(memberDTO);
        log.info(memberDTO);
    }
}