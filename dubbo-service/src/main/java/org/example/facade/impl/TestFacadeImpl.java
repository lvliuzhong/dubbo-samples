package org.example.facade.impl;

import org.apache.dubbo.config.annotation.Service;
import org.example.a.facade.TestFacade;
import org.example.a.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TestFacadeImpl implements TestFacade {
    @Autowired
    private TestService testService;

    @Override
    public Long get() {
        return testService.get();
    }
}
