package com.hope.galaxy.support.sso.vo;

import lombok.Data;

@Data
public class UserVO {
    private String userName;
    private String password;
    private String salt;
    private String credentialsSalt;
}
