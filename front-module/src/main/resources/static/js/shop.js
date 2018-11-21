// var TT = TAOTAO = {
// 	checkLogin : function(){
// 		// var _ticket = $.cookie("TT_TOKEN");
//         // 		// if(!_ticket){
//         // 		// 	return ;
//         // 		// }
//         window.localStorage.getItem('token')
// 		$.ajax({
// 			url : "http://localhost:8777/user/token/" ,
// 			data: window.localStorage.getItem('token'),
// 			type: "Post",
// 			success : function(data){
// 				if(data.status == 200){
// 					var username = data.data.username;
// 					var html = username + "，欢迎来到shop！<a href=\"http://www.shop.com/user/logout.html\" class=\"link-logout\">[退出]</a>";
// 					$("#loginbar").html(html);
// 				}
// 			}
// 		});
// 	}
// }

$(function () {
    // 查看是否已经登录，如果已经登录查询登录信息
    // TT.checkLogin();
    var token = window.localStorage.getItem('token')
    var username = window.localStorage.getItem('username', username);
    var html = "";
    if (token != null) {
        html = username + "，欢迎来到shop！<input id='logout' type='button' value='退出'/>";
    }else {
        html = "您好！欢迎来到shop！<a href=\"javascript:login()\">[登录]</a>&nbsp;<a href=\"javascript:regist()\">[免费注册]</a>"
    }



        $("#loginbar").html(html);


});