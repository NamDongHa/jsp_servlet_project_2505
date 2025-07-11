package com.ndh1614.jsp_servlet_project_2505.service;

import com.ndh1614.jsp_servlet_project_2505.dao.AdminDAO;
import com.ndh1614.jsp_servlet_project_2505.domain.AdminVO;
import com.ndh1614.jsp_servlet_project_2505.dto.AdminDTO;
import com.ndh1614.jsp_servlet_project_2505.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

@Log4j2
public enum AdminService {
    INSTANCE;

    private final AdminDAO adminDAO;
    private final ModelMapper modelMapper;

    AdminService() {
        adminDAO = AdminDAO.getInstance();
        modelMapper = MapperUtil.INSTANCE.getInstance();
    }

    // 관리자 로그인
    public AdminDTO login(String adminId, String password) {
        log.info("Admin login attempt: id={}, pw={}", adminId, password);
        AdminVO adminVO = adminDAO.selectMemberWithPasswdInAdmin(adminId, password);
        if (adminVO != null) {
            return modelMapper.map(adminVO, AdminDTO.class);
        }
        return null;
    }

    // 관리자 정보 업데이트
    public void updateAdmin(AdminDTO adminDTO, String oldAdminId) {
        log.info("Updating admin: oldId={}, newInfo={}", oldAdminId, adminDTO);
        AdminVO adminVO = modelMapper.map(adminDTO, AdminVO.class);
        adminDAO.updateAdmin(adminVO, oldAdminId);
    }
}
