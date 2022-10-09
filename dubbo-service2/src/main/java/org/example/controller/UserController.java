package org.example.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.example.b.facade.UserFacade;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @DubboReference
    private UserFacade userFacade;

    @GetMapping("/get")
    public Long get() {
        try {
            userFacade.get();
            return userService.get();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }
}
