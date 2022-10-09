package org.example.facade.impl;

import org.apache.dubbo.config.annotation.Service;
import org.example.b.facade.UserFacade;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserFacadeImpl implements UserFacade {
    @Autowired
    private UserService userService;

    @Override
    public Long get() {
        return userService.get();
    }
}
