package com.ndh1614.jsp_servlet_project_2505.dto;

import com.ndh1614.jsp_servlet_project_2505.domain.MemberVO;
import com.ndh1614.jsp_servlet_project_2505.domain.ParkingVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ParkingStatusDTO {
    private ParkingDTO parkingDTO;
    private MemberDTO memberDTO;
}
