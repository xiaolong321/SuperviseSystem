var contentPath = '';

//账号登陆
function login() {
    $.post(contentPath + "/user/userLogin", $("#login_form").serialize(), function (data) {
        if (data.result == "success" && data.roleName == "admin") {
            window.location.href = contentPath + "/admin/adminHome";
        } else if (data.result == "success" && data.roleName == "user") {
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
    $.post(contentPath + "/user/changePwd", $("#updateForm").serialize(), function (data) {
        if (data.result == "success") {
            $.messager.alert("提示", data.message + ",请牢记，下次登录时需要输入修改的密码。", "info", function () {
                window.location.reload();
            });
        } else {
            $("#errMsg").html(data.message);
        }
    });
}

//注册用户账号
function userRegister() {
    $.post(contentPath + "/user/userRegister?", $("#register_form").serialize(), function (data) {
        if (data.result == "success") {
            $.messager.alert("提示", data.message, "info", function () {
                $.post(contentPath + "/user/giveUserRole?userId=" + data.roleName, function (data) {
                    if (data.result == "success") {
                        window.location.href = contentPath + "/user/loginPager";
                    }
                });
            });
        } else {
            $("#errMsg").html(data.message);
        }
    });
}

function sendRegisterCode() {
    var email = $("#email").val();
    if (email != null) {
        $.post(contentPath + "/user/sendRegisterCode?receiveMailAccount=" + email, function (data) {
            if (data.result == "success") {
                $.messager.alert("提示", data.message, "info");
            } else {
                $("#errMsg").html(data.message);
            }
        });
    } else {
        $("#errMsg").html("请输入你的邮箱再获取注册码");
    }
}

//修改账号信息
function editInfo() {
    toValidate("editForm");
    if (validateForm("editForm")) {
        $.post(contentPath + "/user/editInfo", $("#editForm").serialize(), function (data) {
                if (data.result == "success") {
                    $.messager.alert("提示", data.message, "info", function () {
                        window.location.reload();
                    });
                } else {
                    $("#errMsg").html(data.message);
                }
            }
        );
    }
}

//跳转到更新用户信息的页面
function userInfoPage() {
    window.location.href = contentPath + "/user/userInfoPage";
}


function doSearch(value, name) {
    alert('You input: ' + value + '(' + name + ')');
}

/**
 * 更换皮肤的js
 */
function changeTheme() {
    var str = ($('#cc1').combobox('getValue'));
    alert(str);
};




