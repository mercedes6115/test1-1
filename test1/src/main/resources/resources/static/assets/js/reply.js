/*
*   reply module
*
* callback 함수 : 개발자는 단지 함수를 동록하기만 하고, 어떤 이벤트가 발생했거나 특정 시점에 도달했을 때 시스템에서 호출하는 함수를 말한다.
* */

console.log("Reply Module......");
let replyService = (function(){

    function add(reply, callback, error){
        console.log("add reply..........");
        $.ajax({
            url: "/test/new",   /*내가 보낼 url*/
            type: "post",        /*보낼 method 방식*/
            data: JSON.stringify(reply),  /* 보낼 데이터를 json타입으로 바꿔줌*/
            contentType: "application/json; charset=utf-8",
            success: function(result){ // 성공했을때
                if(callback){ // js는 함수도 파라미터로 받는다 0,undefined, null 다 false
                    // 외부에서 전달받은 값이 있다면 결과를 해당 함수의 매개변수로 전달함
                    callback(result); // 해다 컨트롤러의 매서드 리턴값
                }
            },
            error: function(xhr, status, err){ // 실패했을때 알아서 들어오는 매개변수들
                if(error){
                    error(err);
                }
            }
        });
    }
    function remove(rno,callback,error){
        console.log("remove reply......");
        $.ajax({
            url:"/test/delete/"+rno,
            type :"delete",
            data:rno,
            success :function(result){
                if(callback){
                    callback(result);
                }
            },
            error:function(xhr,status,err){
                if(error){
                    error(err);
                }
            }
        });
    }
    function modify(replyInfo, callback, error) {
        console.log("MODIFY reply........");
        $.ajax({
            url: "/test/" + replyInfo.replyNumber,
            type: "patch",
            data: JSON.stringify(replyInfo),
            contentType: "application/json; charset=utf-8",
            success: function (result) {
                if (callback) {
                    callback(result);
                }
            },
            error: function (xhr, status, err) {
                if (error) {
                    error(err);
                }
            }
        });
    }


    function get(rno,callback,error){
        console.log("get----------------");
        $.ajax({
            url : "/test/read/"+rno,
            type :"get",
            dataType: "json",
            success:function(reply){
                if(callback){
                    callback(reply);
                }
            },
            error: function (xhr, status, err) {
                if (error) {
                    error(err);
                }
            }
        })
    }

    function getList(params, callback, error) {
        console.log("list...........");
        console.log(params.boardBno);
        console.log(params.page);
        // let date = x | y : x가 없으면 y
        let page = params.page || 1;
        // get방식으로 요청 후 JSON으로 응답
        // $.getJSON(url, callback).fail(callback)
        // 리턴값을 json으로 바꿔줌
        $.ajax({
            url: "/test/list/" + params.boardBno + "/" + page,
            type: "get",
            dataType: "json",
            success: function (list) {
                if (callback) {
                    callback(list);
                }
            },
            error: function (xhr, status, err) {
                if (error) {
                    error(err);
                }
            }
        })
    }

    function remove2(rno,callback,error){
        console.log("get----------------");
        $.ajax({
            url : "/test/delete/"+rno,
            type :"delete",
            success:function(result){
                if(callback){
                    callback(result);
                }
            },
            error: function (xhr, status, err) {
                if (error) {
                    error(err);
                }
            }
        })
    }

    function update2(rno,reply,callback,error){
        console.log("update2-------------");
        $.ajax({
            url:"/test/" + rno,
            type:"patch",
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8",
            success:function(result){
                if(callback){
                    callback(result);
                }
            },
            error: function (xhr, status, err) {
                if (error) {
                    error(err);
                }
            }
        })

    }
    function allList(bno,paging,callback,error){
        console.log("update2-------------");
        $.ajax({
            url:"/test/list/" + bno+"/"+paging,
            type:"get",
            contentType: "application/json; charset=utf-8",
            dataType:"json",
            success:function(result){
                if(callback){
                    callback(result);
                }
            },
            error: function (xhr, status, err) {
                if (error) {
                    error(err);
                }
            }
        })

    }

    function test1(test,callback,error){
        console.log("test1--------");
        $.ajax({
            url:"/test/test1",
            type:"get",
            success:function(result){
                if(callback){
                    callback(result);
                }
            },
            error: function (xhr, status, err) {
                if (error) {
                    error(err);
                }
            }
        })
    }
    function test2(bno,callback,error){
        console.log("test2--------");
        $.ajax({
            url:"/test/test2/"+bno,
            type:"get",
            success:function(result){
                if(callback){
                    callback(result);
                }
            },
            error: function (xhr, status, err) {
                if (error) {
                    error(err);
                }
            }
        })
    }
    function test3(callback,error){
        console.log("test3--------");
        $.ajax({
            url:"/test/test3",
            type:"get",
            dataType:"json",
            success:function(result){
                if(callback){
                    callback(result);
                }
            },
            error: function (xhr, status, err) {
                if (error) {
                    error(err);
                }
            }
        })
    }
    function test4(params,callback,error){
        console.log("test4--------");
        $.ajax({
            url:"/test/test4/"+params.rno+"/"+params.bno,
            type:"get",
            data: JSON.stringify(params),
            dataType:"json",
            success:function(reply){
                if(callback){
                    callback(reply);
                }
            },
            error: function (xhr, status, err) {
                if (error) {
                    error(err);
                }
            }
        })
    }
    function test5(params,callback,error){
        console.log("test5--------");
        $.ajax({
            url:"/test/test5/"+params.bno+"/"+params.page,
            type:"get",
            dataType:"json",
            success:function(list){
                if(callback){
                    callback(list);
                }
            },
            error: function (xhr, status, err) {
                if (error) {
                    error(err);
                }
            }
        })
    }
    return {add: add, remove: remove, modify: modify, getList: getList,get:get,remove2:remove2,update2:update2, allList:allList
    ,test1:test1,test2:test2,test3:test3,test4:test4,test5:test5}
})();