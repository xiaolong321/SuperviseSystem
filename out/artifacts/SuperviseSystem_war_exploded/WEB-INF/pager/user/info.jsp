<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>用户中心</title>
    <link href="<%=path%>/js/themes/insdep/easyui.css" rel="stylesheet" type="text/css">
    <link href="<%=path%>/js/themes/insdep/master.css" rel="stylesheet" type="text/css">
    <link href="<%=path%>/js/themes/insdep/icon.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=path%>/script/user/user.js"></script>
    <script type="text/javascript" src="<%=path%>/js/themes/insdep/jquery.insdep-extend.min.js"></script>
</head>
<body>
<div class="panel theme-panel-red theme-header-unheight"
     style="display: block; width: 680px;">
    <div class="panel-header" style="width: 680px;">
        <div class="panel-title">用户信息<span>在这里修改你的信息</span></div>
        <div class="panel-tool"></div>
    </div>
    <div id="p" class="easyui-panel panel-body" title="" width: 680px; height: 100%;
         data-options="cls:'theme-panel-red theme-header-unheight'">
        <form class="form-layout">
            <input type="file" class="preview-file" id="preview-file" name="preview-file">
            <div class="preview-set-panel" style="width:680px;">
                <div class="left">
                    <img id="image" src="/images/headicon/headicon.jpg"
                         onerror="javascript:this.src=''" alt="Picture">
                </div>
                <div class="right">
                    <div class="preview-caption">预览</div>
                    <div class="preview-content">
                        <div class="preview-cut preview-129"></div>
                        <div class="preview-cut preview-86"></div>
                        <div class="preview-cut preview-43"></div>
                    </div>
                </div>
            </div>
            <a class="easyui-linkbutton button-danger l-btn l-btn-small" href="javascript:void(0)" onclick="onfile()" group="" id="">
                <span class="l-btn-left">
                    <span class="l-btn-text">重新选择图片</span>
                </span>
            </a>
        </form>
    </div>
</div>
<script>
    $(function(){

        var ImgOptions = {
            aspectRatio: 1 / 1,
            preview: '.preview-cut',
            minCanvasWidth:129,//类型：Number，默认值200。容器的最小宽度。
            minCanvasHeight:129,//类型：Number，默认值100。容器的最小高度。
            crop: function (e) {
                /*
                 $dataX.val(Math.round(e.x));
                 $dataY.val(Math.round(e.y));
                 $dataHeight.val(Math.round(e.height));
                 $dataWidth.val(Math.round(e.width));
                 $dataRotate.val(e.rotate);
                 $dataScaleX.val(e.scaleX);
                 $dataScaleY.val(e.scaleY);*/
            }
        };

        var $image = $('#image');
        var URL = window.URL || window.webkitURL;
        /*
         var blobURL=(($("#portrait-set-window").window("options")).queryParams).blobURL;
         var $image = $('#image');
         var URL = window.URL || window.webkitURL;
         $image.cropper.setDefaults(ImgOptions);
         $image.one('built.cropper', function () {
         URL.revokeObjectURL(blobURL);
         }).cropper('reset').cropper('replace', blobURL);

         */


        // Keyboard
        $(document.body).on('keydown', function (e) {

            if (!$image.data('cropper') || this.scrollTop > 300) {
                return;
            }

            switch (e.which) {
                case 37:
                    e.preventDefault();
                    $image.cropper('move', -1, 0);
                    break;

                case 38:
                    e.preventDefault();
                    $image.cropper('move', 0, -1);
                    break;

                case 39:
                    e.preventDefault();
                    $image.cropper('move', 1, 0);
                    break;

                case 40:
                    e.preventDefault();
                    $image.cropper('move', 0, 1);
                    break;
            }

        });

        $image.on({
            'build.cropper': function (e) {
                console.log(e.type);
            },
            'built.cropper': function (e) {
                console.log(e.type);
            },
            'cropstart.cropper': function (e) {
                console.log(e.type, e.action);
            },
            'cropmove.cropper': function (e) {
                console.log(e.type, e.action);
            },
            'cropend.cropper': function (e) {
                console.log(e.type, e.action);
            },
            'crop.cropper': function (e) {
                console.log(e.type, e.x, e.y, e.width, e.height, e.rotate, e.scaleX, e.scaleY);
            },
            'zoom.cropper': function (e) {
                console.log(e.type, e.ratio);
            }
        }).cropper(ImgOptions);




    });

    function onfile(){
        //模拟file控件
        var ie = navigator.appName == "Microsoft Internet Explorer" ? true : false;
        if(ie){
            document.getElementById('preview-file').click();
        }else{
            var mouseobj = document.createEvent("MouseEvents");
            mouseobj.initEvent("click", true, true);
            document.getElementById('preview-file').dispatchEvent(mouseobj);
        }
        var previewFile=$('#preview-file');
        previewFile.on("change",function(){
            var files = this.files;
            var file;
            if (files && files.length) {
                file = files[0];
                if (/^image\/\w+$/.test(file.type)) {
                    blobURL = URL.createObjectURL(file);

                    $('#image').one('built.cropper', function () {
                        URL.revokeObjectURL(blobURL);
                    }).cropper('reset').cropper('replace', blobURL);

                    previewFile.val('');
                } else {
                    alert('请选择一个图像文件.');
                }
            }
        });
    }
</script>
</body>
</html>