
var contentPath='';
function login(){
    $.post(contentPath+"/admin/userLogin",$("#login_form").serialize(),function (data) {
        if(data.result=="success"){
            window.location.href=contentPath+"admin/adminHome";
        }else{
            $("#errMsg").html(data.message);
        }
    });
}