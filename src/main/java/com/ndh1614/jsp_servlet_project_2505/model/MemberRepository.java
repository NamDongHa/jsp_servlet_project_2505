package com.ndh1614.jsp_servlet_project_2505.model;

import com.ndh1614.jsp_servlet_project_2505.dto.MemberDTO;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;


@Getter
@Log4j2
public class MemberRepository {
    public List<MemberDTO> members = new ArrayList<>();
    private static MemberRepository instance = new MemberRepository();
    public static MemberRepository getInstance() {
        if(instance.members.isEmpty()) {
            instance.members.add(MemberDTO.builder()
                            .carId("test")
                            .password("1234")
                            .name("테스트사용자")
                            .phone("123")
                    .build());
        }
        return instance;
    }
    public MemberDTO getMemberById(String carId) {
        log.info(members);
        for (MemberDTO member : members) {
            if (member.getCarId().equals(carId)) {
                return member;
            }
        }
        return null;
    }
    public void addMember(MemberDTO member) {
        members.add(member);
        log.info(members);
    }
}
