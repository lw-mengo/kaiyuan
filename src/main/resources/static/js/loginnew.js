
function btn() {
    var uname=$('#_login-inputPhone').val();
    var pass=$('#_login-inputPwd').val();

    $.ajax({
        type: 'post',
        url: '/api/loginAction',
        data:{"userName":uname,"password":pass},
        dataType:'json',
        contentType:'application/x-www-form-urlencoded',
        success: function (data) {
            console.info(data);
            if (data['status'] == 'success') {
                console.log(data['status']);
                $(location).attr('href', '/addTask');
            } else if (data['status'] == 'user_error') {
                $("#yhm").html("用户名错误").show();
            } else {
                console.log(data['status']);
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