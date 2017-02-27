var contentPath = '';

//账号登陆
function login() {
    $.post(contentPath + "/user/userLogin", $("#login_form").serialize(), function (data) {
        if (data.result == "success") {
            window.location.href = contentPath + "/user/userHome";
        } else {
            $("#errMsg").html(data.message);
        }
    });
}

//账号注销
function logout() {
    $.post(contentPath + "/user/userLogout", function (data) {
        if (data.result == "success") {
            window.location.href = contentPath + "/user/loginPager";
        }
    });
}

//修改密码
function changePwd() {
    $.post(contentPath + "/user/changePwd", $("#pwd").serialize(), function (data) {
        if (data.result == "success") {
            window.location.href = contentPath + "/user/loginPager";
        } else {
            $("#errMsg").html(data.message);
        }
    });
}

//注册用户账号
function userRegister() {
    $.post(contentPath + "/user/userRegister", $("#register_form").serialize(), function (data) {
        if (data.result == "success") {
            alert(data.message);
            window.location.href = contentPath + "/user/loginPager";
        } else {
            alert(data.message);
        }
    });
}

//修改账号信息
function editInfo() {
    if ($("#editForm").form("validate")) {
        $.post(contentPath + "/user/editInfo", $("#editForm").serialize(), function (data) {
            if (data.resutl == "success") {
                $("#editWin").window("close");
                $.messager.alert("提示", "修改商品成功", "info");
            } else {

            }
        });
    }
}

function userInfoPage() {
    window.location.href = contentPath + "/user/userInfoPage";
}


function doSearch(value, name) {
    alert('You input: ' + value + '(' + name + ')');
}

/**
 * login页面的输入验证
 */
$(function () {

    $(".QRcode").on("click", function () {
        $(".QRcode-layout").removeClass("hide");

    });
    $(".QRcode-layout-close").on("click", function () {
        $(".QRcode-layout").addClass("hide");
    });

    $.extend($.fn.validatebox.defaults.tipOptions, {
        onShow: function () {
            $(this).tooltip("tip").css({backgroundColor: "#ff7e00", border: "none", color: "#fff"});

        }
    })

    /*布局部分*/
    $('#theme-login-layout').layout({
        fit: true/*布局框架全屏*/
    });

    // /*表单定义*/
    // $('#theme-login-select').combobox({
    //     /*通过ajax取数据
    //      url:'userclass.json',
    //      valueField:'id',
    //      textField:'text'
    //      */
    //     editable: false /*不允许用户通过输入选择*/
    //
    // });
    // var selects = $('#theme-login-select').combobox('panel');
    // selects.panel({cls: "theme-login-select-panel"});
    //
    // $('#mail').textbox({
    //     prompt: 'mail',
    //     required: true,
    //     missingMessage: "请输入邮箱名称"
    // });
    //
    // $('#mail-add').combobox({
    //     /*通过ajax取数据
    //      url:'userclass.json',
    //      valueField:'id',
    //      textField:'text'
    //      */
    //     editable: false /*不允许用户通过输入选择*/
    //
    // });
    // var mailselect = $('#mail-add').combobox('panel');
    // mailselect.panel({cls: "theme-mail-select-panel"});

    $('#username').textbox({
        prompt: '用户名或者账号',
        required: true,
        missingMessage: "请输入用户名"
    });
    $('#password').textbox({
        type: "password",
        prompt: '输入你的密码',
        required: true,
        missingMessage: "请输入密码"
    });
    $('#code').textbox({
        prompt: '验证码',
        required: true,
        missingMessage: "请输入验证码"
    })

    $('#smscode').textbox({
        required: true,
        missingMessage: "请输入短信验证码",
        buttonText: '获取短信验证码',
        prompt: '短信验证码'
    });

    $('.submit').linkbutton({});

    /*验证码tooltip*/


    $('#form').form({
        url: "http://www.insdep.com/",
        onSubmit: function () {
            var res = $(this).form('enableValidation').form('validate');
            res ? $.messager.progress() : "";
            return res;
        },
        success: function (data) {
            $.messager.progress('close');
            try {
                var data = eval('(' + data + ')');
                if (!data.success) {
                    $.messager.alert('提示', data.message, 'error', function () {
                        $('#username,#password').textbox('clear');
                    });
                } else {
                    window.location.reload();
                }
            }
            catch (e) {
                $.insdep.error(data);
            }

        }
    });

    /*验证码tooltip*/
})


/**
 * 更换皮肤的js
 */
function changeTheme() {
    var str = ($('#cc1').combobox('getValue'));
    alert(str);
};


