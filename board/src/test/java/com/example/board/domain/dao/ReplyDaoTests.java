package com.example.board.domain.dao;


import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;
import com.example.board.mapper.BoardMapper;
import com.example.board.mapper.ReplyMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ReplyDaoTests {
    @Autowired
    private ReplyDAO replyDAO;



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
                replyDAO.register(replyVO);
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
        Long boardBno = 524936L;
        ReplyVO replyVO = replyDAO.read(boardBno);
        replyVO.setReplyNumber(20l);

        replyVO.setReplyContent("수정된 게시글 제목");
        replyVO.setReplyWriter("테스터");


        log.info("UPDATE COUNT : " + replyDAO.modify(replyVO));
    }

    @Test
    public void getTest(){
        log.info(replyDAO.read(9l).toString());
    }
    @Test
    public void deleteTest(){
        replyDAO.remove(9l);
    }

    @Test
    public void getListTest(){


        replyDAO.getList(new Criteria(2,10),524933l).stream().map(ReplyVO::toString).forEach(log::info);
    }
}
