package com.example.jwt;

import lombok.Data;

/**
 * @author csh9016
 * @date 2019/12/6
 */
@Data
public class LoginInfo {

    private String username;
    private String password;
    private String code;
}
