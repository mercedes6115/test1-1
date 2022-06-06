package com.example.board.service;

import com.example.board.domain.dao.TestDAO;
import com.example.board.domain.vo.TestVO;
import com.example.board.mapper.TestMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class OriginTest {

    @Autowired
    private TestService testService;



    @Test
    public void listTest(){
        TestVO testVO = testService.getTest(2l);
        log.info("!@#!@#!@#!@#!@#"+testVO.toString());
        testVO.setTestName("수정");
        testVO.setTestAge("수정");
        testVO.setTestGender("수정");
        testService.update(testVO);
    }
}
