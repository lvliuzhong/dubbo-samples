package org.example.a.service.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.example.a.service.TestService;
import org.example.b.facade.UserFacade;
import org.springframework.stereotype.Service;

/**
 * @author lvliuzhong
 * @date 2022/10/9 10:27
 * @see
 * @since
 */
@Service
public class TestServiceImpl implements TestService {


//    @DubboReference(injvm = false)
//    private UserFacade userFacade;
    @DubboReference
    private UserFacade userFacade;

    @Override
    public Long get() {
        return System.currentTimeMillis();
    }

    @Override
    public Long userGet() {
        return userFacade.get();
    }
}
