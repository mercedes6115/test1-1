package com.example.board.controller;

import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;
import com.example.board.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

/*
 * REST(Representational State Transfer)
 *   하나의 URI는 하나의 고유한 리소스(데이터)를 대표하도록 설계된다.
 *   예)/board/123 : 게시글 중 123번 게시글의 전체 정보
 * */

@RestController // view resolver가 전혀 관여하지 않는다 그래서 요청한 곳으로 리턴값을 전달하는게 가능
@Slf4j
@RequestMapping("/test/*")
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;

    //    댓글 등록
//    브라우저에서 JSON타입으로 데이터를 전송하고 서버에서는 댓글의 처리 결과에 따라 문자열로 결과를 리턴한다.
//    consumes : 전달받은 데이터의 타입
//    produces : 콜백함수로 결과를 전달할 때의 타입
//    @RequestBody : 전달받은 데이터를 알맞는 매개변수로 주입할 때 사용
//    ResponseEntity : 서버의 상태코드, 응답 메세지 등을 담을 수 있는 타입
    @PostMapping(value = "/new", consumes = "application/json", produces = "text/plain; charset=utf-8")
    public ResponseEntity<String> create(@RequestBody ReplyVO replyVO) throws UnsupportedEncodingException { // 객체를 받을경우 reQuestBody사용
        log.info("replyVO : " + replyVO);
        replyService.register(replyVO);
        return new ResponseEntity<>(new String("댓글 등록 성공".getBytes(), "UTF-8") ,HttpStatus.OK);
    }

    // 댓글 1개 조회
    @GetMapping("/read/{rno}") // rno를 replyNumber에 넣는 어노테이션
    public ReplyVO read(@PathVariable("rno") Long replyNumber){
        log.info("read..........." + replyNumber);
        return replyService.read(replyNumber);
    }

    // 하나의 게시물에 대한 댓글 전체
    @GetMapping("/list/{bno}/{page}") // rno를 replyNumber에 넣는 어노테이션  PathVariable은 여러개 사용 가능
    public List<ReplyVO> getList(@PathVariable("bno") Long boardBno,@PathVariable("page") int pageNum){
        log.info("read..........." + boardBno);
        return replyService.getList(new Criteria(pageNum,10),boardBno);
    }


    @GetMapping("/remove/{bno}") // rno를 replyNumber에 넣는 어노테이션
    public boolean remove(@PathVariable("bno") Long boardBno){
        Criteria criteria = new Criteria();
        log.info("read..........." + boardBno);
        return replyService.remove(boardBno);
    }

    @DeleteMapping("/delete/{rno}")
    public String delete(@PathVariable("rno") Long replyNumber){
        replyService.remove(replyNumber);
        return "댓글 삭제 성공";
    }

    @GetMapping("/update/{bno}") // rno를 replyNumber에 넣는 어노테이션
    public boolean update(@PathVariable("bno") Long replyNumber){
        ReplyVO replyVO = new ReplyVO();
        replyVO.setReplyNumber(replyNumber);
        replyVO.setReplyContent("수정된거지롱");
        replyVO.setReplyContent("누구면 알아서 뭐해?");
        log.info("read..........." + replyNumber);
        return replyService.modify(replyVO);
    }

    @PostMapping("/update1") // rno를 replyNumber에 넣는 어노테이션
    public boolean update1(@RequestBody ReplyVO replyVO){
        log.info("read..........." + replyVO);
        return replyService.modify(replyVO);
    }

    // put : 자원의 전체 수정 자원내 모든 필드를 수정해야함  일부만 전달할 경우 오류
    // patch : 자원의 일부만 수정 수정할 필드만 전송(자동 주입이 아닌 부분만 수정하는 쿼리문에서 사용

    @PatchMapping(value = "/{rno}",consumes ="application/json")
    public String update2(@PathVariable("rno") Long replyNumber,@RequestBody ReplyVO replyVO){
        replyVO.setReplyNumber(replyNumber);
        log.info("update2======================="+replyVO);
        log.info("update2======================="+replyNumber);
        if (replyVO.getReplyWriter()==null){
            replyVO.setReplyWriter(Optional.ofNullable(replyVO.getReplyWriter()).orElse("anonymous"));
        }
        replyService.modify(replyVO);
        return "댓글 수정 성공";

    }
/*
    매개변수 없고 리턴은 문자열
    매개변수 있고 리턴은 문자열
    매개변수 없고 리턴은 JSON Object
    매개변수 있고 리턴은 JSON Object
    매개변수 여러 개 있고 리턴은 JSON Array
 */
   @GetMapping("/test1")
   public String test1(){

       return "테스트1 통과";
   }

    @GetMapping("/test2/{bno}")
    public String test2(@PathVariable("bno") Long replyNumber){

        return "테스트2 통과"+replyNumber ;
    }

    @GetMapping("/test3")
    public ReplyVO test3(){
        return replyService.read(90l);
    }

    @GetMapping("/test4/{rno}/{bno}")
    public ReplyVO test4(@PathVariable("rno") Long replyNumber){

        return replyService.read(replyNumber);
    }


    @GetMapping("/test5/{bno}/{page}")
    public List<ReplyVO> test5(@PathVariable("bno") Long boardBno,@PathVariable("page") int pageNum){

        return replyService.getList(new Criteria(pageNum,10),boardBno);
    }





}

















