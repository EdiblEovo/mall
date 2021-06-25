package com.edible.mallservice.impl;

import com.edible.malldao.MemberDao;
import com.edible.mallmodel.Member;
import com.edible.mallservice.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public Member login(String username, String password) {
        return login(username, password);
    }

    @Override
    public int register(Member member) {
        return memberDao.insert(member);
    }

    @Override
    public boolean checkEmail(String email) {
        return (memberDao.selectByEmail(email)!=null);
    }

    @Override
    public boolean checkUsername(String username) {
        return (memberDao.selectByUsername(username)!=null);
    }

    @Override
    public int updateMember(Member member) {
        return memberDao.updateByPrimaryKey(member);
    }

    @Override
    public int deleteMember(Member member) {
        return memberDao.deleteByPrimaryKey(member.getMemberId());
    }

    @Override
    public int banMember(Member member) {
        member.setStatus(0);
        return memberDao.updateByPrimaryKey(member);
    }
}
