package com.example.board.domain.dao;

import com.example.board.domain.vo.TestVO;
import com.example.board.mapper.TestMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@Repository
@Slf4j
@RequiredArgsConstructor
public class TestDAO {
    private final TestMapper testMapper;

    public List<TestVO> getList(){
        return testMapper.getList();
    }


    public TestVO getTest(Long testTno){
        return testMapper.getTest(testTno);
    }

    public String update(TestVO testVO){
        if(testMapper.update(testVO)){
            return"테스트 수정 성공";
        }
        return "테스트는??";
    }
}
