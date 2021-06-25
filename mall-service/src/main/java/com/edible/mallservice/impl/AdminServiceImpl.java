package com.edible.mallservice.impl;

import com.edible.malldao.AdminDao;
import com.edible.mallmodel.Admin;
import com.edible.mallservice.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin login(String username, String password) {
        return adminDao.login(username, password);
    }
}
