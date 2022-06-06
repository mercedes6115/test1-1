package com.example.board.mapper;


import com.example.board.domain.vo.ReplyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Slf4j
public class ReplyMapperTests {
    @Autowired
    private ReplyMapper replyMapper;
    @Autowired
    private BoardMapper boardMapper;

//    @Test
//    public void replyTest(){
//        log.info("++++++++++++"+replyMapper);
//        log.info(replyMapper.getList().toString());
//    }


    @Test
    public void insertTest(){
        ReplyVO replyVO = new ReplyVO();

        Long array[] = {524296l,524933l,524934l,524935l,524936l};

        for(int j=0;j<2;j++) {
            for (int i = 0; i < 5; i++) {
                replyVO.setBoardBno(array[i]);
                replyVO.setReplyContent("새로운 댓글 내용231231" + array[i]);
                replyVO.setReplyWriter("bby1111" + array[i]);
                replyMapper.insert(replyVO);
            }


/*            IntStream.rangeClosed(1, 10).forEach(i -> {
                ReplyVO replyVO = new ReplyVO();
                replyVO.setBoardBno(arBno[i % 5]);
                replyVO.setReplyContent("새롭게 추가된 댓글" + i);
                replyVO.setReplyWriter("user" + i);
                replyMapper.insert(replyVO);
            });*/

        }

        log.info("게시글 번호 : " + replyVO.getBoardBno());
    }

    @Test
    public void updateTest(){
        Long boardBno = 524933L;
        ReplyVO replyVO = replyMapper.getReply(boardBno);
        replyVO.setReplyNumber(8l);

        replyVO.setReplyContent("수정된 게시글 제목");
        replyVO.setReplyWriter("테스터");


        log.info("UPDATE COUNT : " + replyMapper.update(replyVO));
    }

    @Test
    public void getTest(){
        log.info(replyMapper.getReply(5l).toString());
    }
    @Test
    public void deleteTest(){
        replyMapper.delete(3l);
    }

}
