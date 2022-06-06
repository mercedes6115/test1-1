package com.example.board.service;

import com.example.board.domain.dao.TestDAO;
import com.example.board.domain.vo.TestVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.ResolverUtil;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TestService {
    private final TestDAO testDAO;

    public List<TestVO> getList(){
        return testDAO.getList();
    }

    public TestVO getTest(Long testTno){
        return testDAO.getTest(testTno);
    }

    public String update(TestVO testVO){
        return testDAO.update(testVO);
    }

}
