<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
%>
<html>
<head>
    <title>管理员首页</title>
    <link href="<%=path%>/js/themes/insdep/easyui.css" rel="stylesheet" type="text/css">
    <link href="<%=path%>/js/themes/insdep/master.css" rel="stylesheet" type="text/css">
    <link href="<%=path%>/js/themes/insdep/icon.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=path%>/js/themes/insdep/jquery.insdep-extend.min.js"></script>
    <style type="text/css">
        .layout-panel-west {
            border-right: 1px solid #c5c5c5;
        }
    </style>
</head>
<body>
<div id="master-layout">
    <div data-options="region:'north',border:false,bodyCls:'master-header-layout'">
        <div class="navigate">
            <div class="left">
                <a href="#" class="easyui-menubutton navigate-user-button"
                   data-options="menu:'.navigate-user-panel'">匿名</a>
                <a href="#" class="easyui-menubutton" data-options="menu:'#mm1',hasDownArrow:false">文件</a>
                <a href="#" class="easyui-menubutton" data-options="menu:'#mm2',hasDownArrow:false">编辑</a>
                <a href="#" class="easyui-menubutton" data-options="menu:'#mm3',hasDownArrow:false">消息<span
                        class="badge color-default">15</span></a>
                <select id="cc1" class="easyui-combobox navigate-combobox" name="dept" style="width:120px;">
                    <option>选择样式</option>
                    <option>Insdep</option>
                    <option>Bootstrap</option>
                    <option>Gray</option>
                    <option>Metro</option>
                    <option>Material</option>
                </select>

                <div id="mm1" class="navigate-menu-panel">
                    <div>新建</div>
                    <div>打开</div>
                    <div>
                        <span>打开最近文件</span>
                        <div>
                            <div>1 index.html</div>
                            <div>2 calendar-custom.html</div>
                            <div>3 combo-animation.html</div>
                            <div>4 datebox-restrict.html</div>
                            <div>5 datetimespinner-icon.html</div>
                            <div>6 filebox-button-align.html</div>
                            <div>7 menubutton-alignment.html</div>
                            <div>8 messager-interactive.html</div>
                            <div>9 propertygrid-group-format.html</div>
                            <div class="menu-sep"></div>
                            <div>启动时重新打开文件</div>
                        </div>
                    </div>
                    <div>关闭</div>
                    <div>全部关闭</div>
                    <div class="menu-sep"></div>
                    <div data-options="disabled:true,iconCls:'icon-save'">保存</div>
                    <div>另存为</div>
                    <div data-options="disabled:true">保存为全部</div>
                    <div class="menu-sep"></div>
                    <div>
                        <span>导入</span>
                        <div>
                            <div>XML 到模板</div>
                            <div>表格式数据</div>
                            <div data-options="disabled:true">Word 文档</div>
                            <div data-options="disabled:true">Excel 文档</div>
                        </div>
                    </div>
                    <div>
                        <span>导出</span>
                        <div>
                            <div>表格</div>
                        </div>
                    </div>
                    <div class="menu-sep"></div>
                    <div>退出</div>
                </div>

                <div id="mm2" class="navigate-menu-panel">
                    <div>撤销</div>
                    <div data-options="disabled:true">重做</div>
                    <div class="menu-sep"></div>
                    <div>剪切</div>
                    <div>复制</div>
                    <div data-options="disabled:true">粘贴</div>
                    <div data-options="disabled:true">选择性粘贴</div>
                    <div data-options="disabled:true">清除</div>
                    <div class="menu-sep"></div>
                    <div>全选</div>
                    <div>选择父标签</div>
                    <div>选择子标签</div>
                    <div class="menu-sep"></div>
                    <div>查找和替换</div>
                    <div>查找所选</div>
                    <div>查找下一个</div>
                    <div class="menu-sep"></div>
                    <div>快捷键</div>
                    <div>首选项</div>
                </div>

                <div id="mm3" class="navigate-menu-panel" style="width:180px;">
                    <div>产品消息<span class="badge color-success">5</span></div>
                    <div>安全消息<span class="badge color-important">10</span></div>
                    <div>服务消息</div>
                    <div class="menu-sep"></div>
                    <div>查看历史消息</div>
                    <div class="menu-sep"></div>
                    <div>清除消息提示</div>
                </div>


                <div class="navigate-user-panel">
                    <dl>
                        <dd>
                            <img src="../themes/insdep/images/portrait86x86.png" width="86" height="86">
                            <b class="badge-prompt">匿名<i class="badge color-important">10</i></b>
                            <span>examples@insdep.com</span>
                            <p>安全等级：<i class="text-success">高</i></p>
                        </dd>
                        <dt>
                            <a class="navigate-user-modify">修改资料</a>
                            <a class="navigate-user-logout">注销</a>
                        </dt>
                    </dl>
                </div>
            </div>
            <div class="right">
                <select id="cc2" class="easyui-combobox navigate-combobox" name="dept" style="width:180px;">
                    <option>Choose a language</option>
                    <option>Chinese</option>
                    <option>English</option>
                    <option>Korean</option>
                    <option>Japanese</option>
                    <option>Arabic</option>
                </select>
                <input class="easyui-searchbox navigate-search"
                       data-options="prompt:'输入搜索的关键词..',menu:'#mm',searcher:doSearch" style="width:300px"></input>
                <a href="#" class="easyui-menubutton navigate-more-button"
                   data-options="menu:'#more',hasDownArrow:false"></a>
                <div id="more" class="navigate-more-panel">
                    <div>联系我们</div>
                    <div>参与改进计划</div>
                    <div>检测更新</div>
                    <div>关于</div>
                </div>
                <div id="mm" class="navigate-menu-panel">
                    <div data-options="name:'all'">全部内容</div>
                    <div data-options="name:'sports'">标题</div>
                    <div data-options="name:'sports'">作者</div>
                    <div data-options="name:'sports'">内容</div>
                </div>
            </div>
        </div>

    </div>
</div>
</div>
<script>
    $(function () {

        /*布局部分*/
        $('#master-layout').layout({
            fit: true/*布局框架全屏*/
        });

        $(".navigate-user-modify").on("click", function () {
            $('.navigate-user-panel').menu('hide');
            $.insdep.window({id: "personal-set-window", href: "user.html", title: "修改资料"});

        });
        //$.insdep.control("list.html");


        var cc1 = $('#cc1').combo('panel');
        cc1.panel({cls: "navigate-combobox-panel"});
        var cc2 = $('#cc2').combo('panel');
        cc2.panel({cls: "navigate-combobox-panel"});


        /*$("#open-layout").on("click",function(){
         var option = {
         "region":"west",
         "split":true,
         "title":"title",
         "width":180
         };
         $('#master-layout').layout('add', option);

         });*/


    });
    function doSearch(value, name) {
        alert('You input: ' + value + '(' + name + ')');
    }

</script>


<!--第三方插件加载-->
<script src="plugin/justgage-1.2.2/raphael-2.1.4.min.js"></script>
<script src="plugin/justgage-1.2.2/justgage.js"></script>
<script src="plugin/Highcharts-5.0.0/js/highcharts.js"></script>
<script type="text/javascript" src="plugin/ueditor-1.4.3.3/ueditor.config.js"></script>
<script type="text/javascript" src="plugin/ueditor-1.4.3.3/ueditor.all.min.js"></script>
<link href="plugin/cropper-2.3.4/dist/cropper.min.css" rel="stylesheet" type="text/css">
<script src="plugin/cropper-2.3.4/dist/cropper.min.js"></script>
<!--第三方插件加载结束-->

<script>
    var _hmt = _hmt || [];
    (function () {
        var hm = document.createElement("script");
        hm.src = "//hm.baidu.com/hm.js?76386f607e79e997458a326997f1be87";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>

</body>
</html>