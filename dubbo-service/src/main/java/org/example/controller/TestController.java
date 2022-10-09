package org.example.controller;

import org.example.a.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("/get")
    public Long get() {
        try {
            return testService.userGet();
        } catch (Exception e) {
            e.printStackTrace();
            return -1L;
        }
    }
}
