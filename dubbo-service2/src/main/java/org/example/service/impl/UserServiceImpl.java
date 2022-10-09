package org.example.service.impl;

import org.example.a.service.TestService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lvliuzhong
 * @date 2022/10/9 10:27
 * @see
 * @since
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TestService testService;
    
    @Override
    public Long get() {
        return testService.get();
    }
}
