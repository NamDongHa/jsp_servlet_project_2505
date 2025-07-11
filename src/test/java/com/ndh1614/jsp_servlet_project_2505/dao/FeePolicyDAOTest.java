package com.ndh1614.jsp_servlet_project_2505.dao;

import com.ndh1614.jsp_servlet_project_2505.domain.FeePolicyVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Log4j2
class FeePolicyDAOTest {
    private final FeePolicyDAO feePolicyDAO = new FeePolicyDAO();

    @Test
    void getFeePolicies() {
        List<FeePolicyVO>feePolicyVOS = feePolicyDAO.selectFeePolicies();
        feePolicyVOS.forEach(System.out::println);
        log.info("성공");
    }
    @Test
    void insertFeePolicy() {
        FeePolicyVO feePolicyVO = FeePolicyVO.builder()
                .baseFee(2000)
                .baseTime(2000)
                .unitTime(2000)
                .unitFee(2000)
                .dailyMaxFee(2000)
                .discountDisabled(4)
                .discountCompact(5)
                .carType("일반")
                .build();
        feePolicyDAO.insertPolicy(feePolicyVO);
        log.info(feePolicyVO);
    }
}