<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>用户中心</title>
    <link href="/js/themes/insdep/easyui.css" rel="stylesheet" type="text/css">
    <link href="/js/themes/insdep/default_theme.css" rel="stylesheet" type="text/css">
    <link href="/js/themes/insdep/master.css" rel="stylesheet" type="text/css"/>
    <link href="/css/site_main.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/js/themes/insdep/jquery.insdep-extend.min.js"></script>
    <script type="text/javascript" src="/script/user/user.js"></script>
    <script type="text/javascript" src="/script/site_easyui.js"></script>
    <style type="text/css">
        .layout-panel-west {
            border-right: 1px solid #c5c5c5;
        }
    </style>
</head>
<body>
<div id="master-layout">
    <div data-options="region:'north',border:false,bodyCls:'theme-header-layout'">
        <div class="theme-navigate">
            <div class="left">
                <a href="#" class="easyui-menubutton theme-navigate-user-button"
                   data-options="menu:'.theme-navigate-user-panel'">${sessionScope.user.username}</a>
                <a href="#" class="easyui-menubutton" data-options="menu:'#mm3',hasDownArrow:false">消息<span
                        class="badge color-default">15</span></a>

                <select id="cc1" class="easyui-combobox theme-navigate-combobox" name="dept" style="width:120px;">
                    <option>选择样式</option>
                    <option>Insdep</option>
                    <option>Bootstrap</option>
                    <option>Gray</option>
                    <option>Metro</option>
                    <option>Material</option>
                </select>

                <div id="mm3" class="theme-navigate-menu-panel" style="width:180px;">
                    <div>产品消息<span class="badge color-success">5</span></div>
                    <div>安全消息<span class="badge color-important">10</span></div>
                    <div class="menu-sep"></div>
                    <div>查看历史消息</div>
                    <div class="menu-sep"></div>
                    <div>清除消息提示</div>
                </div>

                <div class="theme-navigate-user-panel">
                    <dl>
                        <dd>
                            <img src="/js/themes/insdep/images/portrait86x86.png" width="86" height="86">
                            <b class="badge-prompt">${sessionScope.user.username}<i class="badge color-important">10</i></b>
                            <span>${sessionScope.user.email}</span>
                            <p>手机号码：<i class="text-success">${sessionScope.user.phone}</i></p>
                        </dd>
                        <dt>
                            <a class="theme-navigate-user-modify">修改资料</a>
                            <a class="theme-navigate-user-logout">注销</a>
                        </dt>
                    </dl>
                </div>
            </div>
            <div class="right">
                <select id="cc2" class="easyui-combobox theme-navigate-combobox" name="dept" style="width:180px;">
                    <option>Choose a language</option>
                    <option>Chinese</option>
                    <option>English</option>
                    <option>Korean</option>
                    <option>Japanese</option>
                    <option>Arabic</option>
                </select>
                <input class="easyui-searchbox theme-navigate-search"
                       data-options="prompt:'输入搜索的关键词..',menu:'#mm',searcher:doSearch" style="width:300px"></input>
                <a href="#" class="easyui-menubutton theme-navigate-more-button"
                   data-options="menu:'#more',hasDownArrow:false"></a>
                <div id="more" class="theme-navigate-more-panel">
                    <div>联系我们</div>
                    <div>参与改进计划</div>
                    <div>检测更新</div>
                    <div>关于</div>
                </div>
                <div id="mm" class="theme-navigate-menu-panel">
                    <div data-options="name:'all'">全部内容</div>
                    <div data-options="name:'sports'">标题</div>
                    <div data-options="name:'sports'">作者</div>
                    <div data-options="name:'sports'">内容</div>
                </div>
            </div>
        </div>

    </div>

    <div data-options="region:'west',split:true,title:'功能菜单'" class="west" style="width: 200px;">
        <div class="easyui-accordion" data-options="border:false" style="width: 200px;">
            <div title="用户管理" class="site_menu">
                <ul class="easyui-tree">
                    <li>
                        <div class="tree-node">
                            <span class="tree-title">
                                <p>
                                    <a href="javascript:;" onclick="addTab('所有用户','/user/list_page');">所有用户</a>
                                </p>
                            </span>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div id="mainPanle" data-options="region:'center',border:true">
        <div id="tabs" class="easyui-tabs" data-options="fit:true,border:false">
            <div title="主页">

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

        $(".theme-navigate-user-modify").on("click", function () {
            $('.theme-navigate-user-panel').menu('hide');
            $.insdep.window({id: "personal-set-window", href: "userInfoPage", title: "修改资料"});

        });
        //$.insdep.control("list.html");


        var cc1 = $('#cc1').combo('panel');
        cc1.panel({cls: "theme-navigate-combobox-panel"});
        var cc2 = $('#cc2').combo('panel');
        cc2.panel({cls: "theme-navigate-combobox-panel"});


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
<script src="/js/plugin/justgage/raphael-2.1.4.min.js"></script>
<script src="/js/plugin/justgage/justgage.js"></script>
<script src="/js/plugin/Highcharts/highcharts.js"></script>
<script type="text/javascript" src="/js/plugin/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="/js/plugin/ueditor/ueditor.all.min.js"></script>
<link href="/js/plugin/cropper/cropper.min.css" rel="stylesheet" type="text/css">
<script src="/js/plugin/cropper/cropper.min.js"></script>
<!--第三方插件加载结束-->
</body>
</html>
