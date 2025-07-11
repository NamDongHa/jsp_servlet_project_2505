package com.ndh1614.jsp_servlet_project_2505.service;

import com.ndh1614.jsp_servlet_project_2505.dao.MemberDAO;
import com.ndh1614.jsp_servlet_project_2505.domain.MemberVO;
import com.ndh1614.jsp_servlet_project_2505.dto.MemberDTO;
import com.ndh1614.jsp_servlet_project_2505.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public enum MemberService {
    INSTANCE;

    private final MemberDAO memberDAO;
    private final ModelMapper modelMapper;

    MemberService() {
        memberDAO = MemberDAO.getInstance();
        modelMapper = MapperUtil.INSTANCE.getInstance();
    }

    // 로그인 처리
    public MemberDTO login(String carId, String password) {
        log.info("login() - carId: {}, password: {}", carId, password);
        MemberVO memberVO = memberDAO.selectMemberWithPasswd(carId, password);
        if (memberVO != null) {
            return modelMapper.map(memberVO, MemberDTO.class);
        }
        return null;
    }

    // 회원 등록
    public void register(MemberDTO dto) {
        log.info("register() - {}", dto);
        MemberVO vo = modelMapper.map(dto, MemberVO.class);
        memberDAO.insertMember(vo);
    }

    // 회원 조회
    public MemberDTO getMember(String carId) {
        log.info("getMember() - carId: {}", carId);
        MemberVO vo = memberDAO.selectMemberById(carId);
        if (vo != null) {
            return modelMapper.map(vo, MemberDTO.class);
        }
        return null;
    }

    // 회원 정보 수정
    public void update(MemberDTO dto, String oldCarId) {
        log.info("update() - oldCarId: {}, newInfo: {}", oldCarId, dto);
        MemberVO vo = modelMapper.map(dto, MemberVO.class);
        memberDAO.updateMember(vo, oldCarId);
    }

    // 전체 회원 조회
    public List<MemberDTO> getAllMembers() {
        log.info("getAllMembers()");
        List<MemberVO> voList = memberDAO.selectAllMembers();
        return voList.stream()
                .map(vo -> modelMapper.map(vo, MemberDTO.class))
                .collect(Collectors.toList());
    }

    // 월 정기 결제 회원만 조회
    public List<MemberDTO> getMonthPayMembers(boolean monthPay) {
        log.info("getMonthPayMembers() - monthPay: {}", monthPay);
        List<MemberVO> voList = memberDAO.selectMonthPayMembers(monthPay);
        return voList.stream()
                .map(vo -> modelMapper.map(vo, MemberDTO.class))
                .collect(Collectors.toList());
    }

    // 회원 일치 확인
    public boolean isMatching(String carId, String name, String phone, String type, boolean monthPay) {
        log.info("isMatching() - {}, {}, {}, {}, {}", carId, name, phone, type, monthPay);
        return memberDAO.isMatchingMember(carId, name, phone, type, monthPay);
    }

    // 회원 삭제
    public void delete(String carId) {
        log.info("delete() - carId: {}", carId);
        memberDAO.deleteMember(carId);
    }
    public void updateInList(MemberDTO dto, String oldCarId) {
        log.info("updateInList() - carId: {}, oldCarId: {}", oldCarId, dto);
        MemberVO vo = modelMapper.map(dto, MemberVO.class);
        memberDAO.updateMemberInList(vo, oldCarId);
    }
}

