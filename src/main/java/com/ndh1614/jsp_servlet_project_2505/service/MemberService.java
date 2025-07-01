package com.ndh1614.jsp_servlet_project_2505.service;

import com.ndh1614.jsp_servlet_project_2505.domain.MemberVO;
import com.ndh1614.jsp_servlet_project_2505.dto.MemberDTO;
import com.ndh1614.jsp_servlet_project_2505.dao.MemberDAO;
import com.ndh1614.jsp_servlet_project_2505.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

@Log4j2
public enum MemberService {
    INSTANCE;
    private MemberDAO memberDAO;
    private ModelMapper modelMapper;
    MemberService() {
        modelMapper = MapperUtil.INSTANCE.getInstance();
        memberDAO = MemberDAO.getInstance();
    }
    public boolean isMember(String carId, String password){
        log.info("isMember()");
        log.info("memberId: " + carId + " password: " + password);
        return memberDAO.selectMemberWithPasswd(carId, password) != null;
    }
    public MemberDTO getMember(String carId){
        log.info("getMember()");
        log.info("memberId: " + carId);
        MemberVO memberVO = memberDAO.selectMember(carId);
        MemberDTO memberDTO = null;
        if (memberVO != null) {
            memberDTO = modelMapper.map(memberVO, MemberDTO.class);
            log.info("memberDTO: " + memberDTO);
        }
        return memberDTO;
    }
    public void modifyMember(MemberVO member, String oldCarId){
        log.info("modifyMember()");
        log.info("memberId: " + member.getCarId());
        memberDAO.updateMember(member, oldCarId);

    }
}
