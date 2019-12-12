package com.example.shiro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author csh9016
 * @date 2019/11/28
 */
@Slf4j
//@CrossOrigin(value = "http://localhost:63342",allowCredentials = "true",maxAge = 3600)
@RestController
public class HomeController {

    @Autowired
    private List<Filter> filters;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public void login(@RequestBody LoginInfo loginInfo, HttpServletRequest request, HttpSession httpSession) {
        String remoteAddr = request.getRemoteAddr();
        httpSession.setAttribute("loginFlag",true);
        httpSession.setAttribute("loginIP",remoteAddr);
        httpSession.setAttribute("loginUser",loginInfo.getUsername());
        log.info("username:{},password:{},sessionId:{},ip:{}",loginInfo.getUsername(),loginInfo.getPassword(),httpSession.getId(),remoteAddr);
    }

    @RequestMapping(value = "/login1",method = RequestMethod.POST)
    public String login1(@RequestBody LoginInfo loginInfo, HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        return String.format("username:%s,password:%s,sessionId:%s,ip:%s", loginInfo.getUsername(), loginInfo.getPassword(), "qq", remoteAddr);
    }

    @RequestMapping(value = "/unauthorized")
    public String unauthorized() {
        return "UNAUTHORIZED";
    }

    @RequestMapping(value = "/success")
    public String success() {
        return "SUCCESS";
    }

}
