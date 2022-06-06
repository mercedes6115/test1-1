package com.example.board.mapper;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyMapper {

    public List<ReplyVO> getList(@Param("criteria")Criteria criteria,@Param("boardBno")Long boardBno);

    public void insert(ReplyVO replyVO);

    //    댓글 수정
    public int update(ReplyVO replyVO);

    //   댓글 삭제
    public int delete(Long replyNUmber);

    // 댓글 1개 가져오기
    public ReplyVO getReply(Long replyNumber);



}
