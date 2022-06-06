package com.example.board.controller;

import com.example.board.domain.vo.ReplyVO;
import com.example.board.domain.vo.TestVO;
import com.example.board.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/test/*")
public class TestController {
    private final TestService testService;


    @PatchMapping(value = "/test1",consumes ="application/json")
    public String test1(@RequestBody TestVO testVO){

        log.info("update2======================="+testVO);
        testService.update(testVO);
        return "댓글 수정 성공";

    }
    @GetMapping("/test2")
    public TestVO test2(){
        return testService.getTest(1l);
    }
    @PostMapping("/test3")
    public TestVO test3(@RequestBody TestVO testVO){
        log.info("!@#"+testVO.getTestTno());
        return testService.getTest(testVO.getTestTno());
    }
//    @GetMapping("/test4")
//    @GetMapping("/test5")
}
