function changeFrameHeight(){
    var ifm= document.getElementById("iframepage");
    ifm.height=document.documentElement.clientHeight;
}

window.onresize=function(){
     changeFrameHeight();
}

$(function () {
    $('#logout').click(function () {
        //ajax提交数据
        $.ajax({
            url: "/admin/logout",
            success: function (r) {
                if (r.resultCode == 200) {
                    window.location.href="/";
                } else {
                    alert(r.message);
                }
            }
        });
    });
})