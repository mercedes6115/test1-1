let testService = (function(){

    function test1(test,callback,error){ // 객체(매개변수 여러개)를 보내고 문자열을 반환받아 콘솔에 출력
        console.log("test1--------");
        $.ajax({
            url:"/test/test1",
            type:"patch",
            data:JSON.stringify(test),
            contentType:"application/json",
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
    function test2(callback,error){ // 매개변수 없고 객체를 리턴타입으로 반환받음
        console.log("test2--------");
        $.ajax({
            url:"/test/test2/",
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
    function test3(test,callback,error){
        console.log("test3--------");
        $.ajax({
            url:"/test/test3",
            type:"get",
            data:test,
            dataType:"json",
            contentType:"application/json",
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
    return {test1:test1,test2:test2,test3:test3,test4:test4,test5:test5}
})();