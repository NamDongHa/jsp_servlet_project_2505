package com.ndh1614.jsp_servlet_project_2505.domain;


import lombok.*;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminVO {
    private String adminId;
    private String password;
    private String name;
}
