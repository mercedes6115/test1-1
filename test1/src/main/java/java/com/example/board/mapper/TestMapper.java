package com.example.board.mapper;

import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;
import com.example.board.domain.vo.TestVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TestMapper {

    public List<TestVO> getList();

    public TestVO getTest(@Param("testTno")Long testTno);

    public boolean update(TestVO testVO);


}
