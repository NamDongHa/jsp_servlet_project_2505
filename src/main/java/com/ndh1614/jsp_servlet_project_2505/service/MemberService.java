package com.ndh1614.jsp_servlet_project_2505.service;

import com.ndh1614.jsp_servlet_project_2505.dto.MemberDTO;
import com.ndh1614.jsp_servlet_project_2505.dao.MemberDAO;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class MemberService {
    static final MemberDAO memberDAO = MemberDAO.getInstance();
    private static MemberService instance;
    private MemberService() {

    }
    public static MemberService getInstance() {
        if (instance == null) {
            instance = new MemberService();
        }
        return instance;
    }
    public boolean isMember(String carId, String password){
        log.info("isMember()");
        log.info("memberId: " + carId + " password: " + password);
        return memberDAO.selectMemberWithPasswd(carId, password) != null;
    }
    public MemberDTO getMember(String carId){
        log.info("getMember()");
        log.info("memberId: " + carId);
        return memberDAO.selectMemberById(carId);
    }
    public void modifyMember(MemberDTO member, String oldCarId){
        log.info("modifyMember()");
        log.info("memberId: " + member.getCarId());
        memberDAO.updateMember(member, oldCarId);

    }
}
