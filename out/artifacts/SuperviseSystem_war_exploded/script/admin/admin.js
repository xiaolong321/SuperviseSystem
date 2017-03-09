var contentPath = '';

function addAdmin() {
    $.post(contentPath + "/admin/addNewAdmin", $("#add_form").serialize(), function (data) {
        if (data.result == "success") {
            $.messager.alert("提示", data.message, "info", function () {
                $.post(contentPath + "/admin/giveAdminRole?adminId=" + data.roleName, function (data) {
                    if (data.result == "success") {
                        window.location.reload();
                    }
                });
            });
        }else{
            $("#errMsg").html(data.message);
        }
    })
}

function login() {
    $.post(contentPath + "/admin/adminLogin", $("#login_form").serialize(), function (data) {
        if (data.result == "success") {
            window.location.href = contentPath + "/admin/adminHome";
        } else {
            $("#errMsg").html(data.message);
        }
    });
}

//修改账号信息
function editInfo() {
    toValidate("editForm");
    if (validateForm("editForm")) {
        $.post(contentPath + "/admin/editInfo", $("#editForm").serialize(), function (data) {
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

//修改密码
function changePwd() {
    $.post(contentPath + "/admin/changePwd", $("#updateForm").serialize(), function (data) {
        if (data.result == "success") {
            $.messager.alert("提示", data.message + ",请牢记，下次登录时需要输入修改的密码。", "info", function () {
                window.location.reload();
            });
        } else {
            $("#errMsg").html(data.message);
        }
    });
}