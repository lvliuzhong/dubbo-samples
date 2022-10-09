package org.example.controller;

import org.apache.dubbo.config.annotation.Reference;
import org.example.a.facade.TestFacade;
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
    @Reference
    private UserFacade userFacade;

    @Reference
    private TestFacade testFacade;

    @Reference(injvm = false)
    private TestFacade testFacade2;

    @GetMapping("/get")
    public Long get() {
        try {
            testFacade.get();
            testFacade2.get();
            userFacade.get();
            return userService.get();
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }
}
