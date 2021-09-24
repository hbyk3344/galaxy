package com.hope.galaxy.support.sso.service;

import com.hope.galaxy.support.sso.vo.UserVO;

public interface UserService {
    boolean checkUser(UserVO userVO);
    UserVO getUser(String userName);
    boolean save(UserVO userVO);
}
