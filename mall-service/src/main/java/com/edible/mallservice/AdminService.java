package com.edible.mallservice;

import com.edible.mallmodel.Admin;

public interface AdminService {
    Admin login(String username, String password);
}
