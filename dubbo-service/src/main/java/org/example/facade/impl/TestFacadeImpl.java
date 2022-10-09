package org.example.facade.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.a.facade.TestFacade;
import org.example.a.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService
public class TestFacadeImpl implements TestFacade {
    @Autowired
    private TestService testService;

    @Override
    public Long get() {
        return testService.get();
    }
}
