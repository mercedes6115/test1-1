package com.example.board.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
@Data

public class TestVO {

    private long testTno;
    private String testName;
    private String testAge;
    private String testGender;

}
