package com.ndh1614.jsp_servlet_project_2505.service;

import com.ndh1614.jsp_servlet_project_2505.dao.MemberDAO;
import com.ndh1614.jsp_servlet_project_2505.domain.MemberVO;
import com.ndh1614.jsp_servlet_project_2505.dto.MemberDTO;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

@Log4j2
public enum MemberService {
    INSTANCE;

    private MemberDAO memberDAO;
    private ModelMapper modelMapper;

    MemberService() {
        memberDAO = new MemberDAO();
        modelMapper = new ModelMapper();
    }

    public MemberDTO getMemberDAO(String carId) {

        MemberVO memberVO = memberDAO.selectMember(carId);

        MemberDTO memberDTO = null;
        if (memberVO != null) {
            memberDTO = modelMapper.map(memberVO, MemberDTO.class);
            log.info("memberDTO : " + memberDTO);
        }

        return memberDTO;
    }
}
