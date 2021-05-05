$(function () {
    $('#info').css("display", "none");

    //修改个人信息
    $('#login').click(function () {
    	// 拿到用户输入的内容
        var userName = $('#userName').val();
        var password = $('#password').val();
        var verifyCode = $('#verifyCode').val();
        // 前端js简单验证
        if (valid(userName, password,verifyCode)) {
            //ajax提交数据
            $.ajax({
                type: "POST",
                url: "/admin/login",
                data: {
                    userName: userName,
                    password: password,
                    verifyCode: verifyCode
                },
                success: function (r) {
                    if (r.resultCode == 200) {
                    	// 如果登录成功，则自动跳转到 main 主页面
                        window.top.location.href="/main.html";
                    } else {
                    	$('#info').css("display", "block");
                        $('#info').html(r.message);
                    }
                }
            });
        }
    });
})

/**
 * 验证
 */
function valid(userName, password,verifyCode) {
    if (isNull(userName) || userName.trim().length < 1) {
        $('#info').css("display", "block");
        $('#info').html("请输入登录名称！");
        return false;
    }
    if (isNull(password) || password.trim().length < 1) {
        $('#info').css("display", "block");
        $('#info').html("请输入密码！");
        return false;
    }
    if (isNull(verifyCode) || verifyCode.trim().length < 1) {
        $('#info').css("display", "block");
        $('#info').html("请输入验证码！");
        return false;
    }
    return true;
}

