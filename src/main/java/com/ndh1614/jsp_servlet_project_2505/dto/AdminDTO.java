package com.ndh1614.jsp_servlet_project_2505.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {
    private String adminId;
    private String password;
    private String name;
}
