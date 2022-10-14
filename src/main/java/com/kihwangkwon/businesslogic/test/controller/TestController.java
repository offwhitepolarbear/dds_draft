package com.kihwangkwon.businesslogic.test.controller;

import com.kihwangkwon.businesslogic.test.domain.TestRequest;
import com.kihwangkwon.businesslogic.test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/rest/test")
public class TestController {

    private final TestService testService;

    @PostMapping("/testBid")
    public void bid(@RequestBody TestRequest testRequest){
        testService.test(testRequest);
    }
}
