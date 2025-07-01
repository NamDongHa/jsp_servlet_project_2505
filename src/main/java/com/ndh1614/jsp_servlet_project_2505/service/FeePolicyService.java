package com.ndh1614.jsp_servlet_project_2505.service;

import com.ndh1614.jsp_servlet_project_2505.dao.FeePolicyDAO;
import com.ndh1614.jsp_servlet_project_2505.domain.FeePolicyVO;

import java.util.List;

public enum FeePolicyService {
    INSTANCE;

    private final FeePolicyDAO feePolicyDAO;

    FeePolicyService() {
        feePolicyDAO = new FeePolicyDAO();
    }

    public List<FeePolicyVO> getFeePolicies() {
        return feePolicyDAO.selectFeePolicies();
    }

    public boolean registerPolicy(FeePolicyVO feePolicyVO) {
        return feePolicyDAO.insertPolicy(feePolicyVO);
    }
}
