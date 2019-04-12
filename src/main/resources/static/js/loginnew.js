
function btn() {
    var uname=$('#_login-inputPhone').val();
    var pass=$('#_login-inputPwd').val();

    $.ajax({
        type: 'post',
        url: '/loginAction',
        data:{"name":uname,"password":pass},
        contentType: 'application/x-www-form-urlencoded',
        success: function (data) {
            console.info(data);
            if (data == 'success') {
                $(location).attr('href', '/');
            } else if (data == 'user_error') {
                $("#yhm").html("用户名已存在").show();
            } else {
                $("#mm").html("密码不正确").show();
            }

        },
    })
}
$(function (){

    $("input").blur(function(){
        $(this).next().hide();
        if($(this).val()==""){
            $(this).next().show();
        }
    });

});