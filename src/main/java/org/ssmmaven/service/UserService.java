package org.ssmmaven.service;

import org.ssmmaven.bean.User;

public interface UserService {
    User checkLogin(String userName, String password);
}
