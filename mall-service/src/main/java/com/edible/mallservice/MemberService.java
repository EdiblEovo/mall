package com.edible.mallservice;

import com.edible.mallmodel.Member;

public interface MemberService {
    int register(Member member);

    boolean checkUsername(String username);

    boolean checkEmail(String email);

    Member login(String username, String password);

    int updateMember(Member member);

    int deleteMember(Member member);

    int banMember(Member member);
}
