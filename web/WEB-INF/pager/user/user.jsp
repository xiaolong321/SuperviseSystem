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
    <script type="text/javascript" src="<%=path%>/js/themes/insdep/jquery.insdep-extend.min.js"></script>
    <script type="text/javascript" src="<%=path%>/script/user/user.js"></script>
    <style type="text/css">
        .layout-panel-west {
            border-right: 1px solid #c5c5c5;
        }
    </style>
</head>
<body class="panel-noscroll">
<div id="master-layout">
    <div data-options="region:'north',border:false,bodyCls:'master-header-layout'">
        <div class="navigate">
            <div class="left">
                <a href="#" class="easyui-menubutton navigate-user-button"
                   data-options="menu:'.navigate-user-panel'">${sessionScope.user.username}</a>
                <a href="#" class="easyui-menubutton" data-options="menu:'#mm1',hasDownArrow:false">文件</a>
                <a href="#" class="easyui-menubutton" data-options="menu:'#mm3',hasDownArrow:false">消息<span
                        class="badge color-default">15</span></a>
                <div id="mm1" class="navigate-menu-panel">
                    <div>
                        <span>导入</span>
                        <div>
                            <div>XML 到模板</div>
                            <div>表格式数据</div>
                        </div>
                    </div>
                    <div>
                        <span>导出</span>
                        <div>
                            <div>表格</div>
                        </div>
                    </div>
                </div>
                <div id="mm3" class="navigate-menu-panel" style="width:180px;">
                    <div>发布的消息<span class="badge color-success">5</span></div>
                    <div>系统提示<span class="badge color-important">10</span></div>
                    <div class="menu-sep"></div>
                    <div>查看历史消息</div>
                    <div class="menu-sep"></div>
                    <div>清除消息提示</div>
                </div>
                <div class="navigate-user-panel">
                    <dl>
                        <dd>
                            <img src="/uploads/images/headicon/headicon.jpg" width="86" height="86">
                            <b class="badge-prompt">${sessionScope.user.username}<i class="badge color-important">10</i></b>
                            <span>${sessionScope.user.email}</span>
                            <p>电话号码：<i class="text-success">${sessionScope.user.phone}</i></p>
                        </dd>
                        <dt>
                            <a class="navigate-user-modify">修改资料</a>
                            <a class="navigate-user-logout" onclick="logout()">注销</a>
                        </dt>
                    </dl>
                </div>
            </div>
            <div class="right">
                <input class="easyui-searchbox navigate-search"
                       data-options="prompt:'输入搜索的关键词..',menu:'#mm',searcher:doSearch" style="width:300px"></input>
                <div id="mm" class="navigate-menu-panel">
                    <div data-options="name:'all'">全部内容</div>
                    <div data-options="name:'sports'">标题</div>
                    <div data-options="name:'sports'">作者</div>
                    <div data-options="name:'sports'">内容</div>
                </div>
                <select id="cc1" class="easyui-combobox navigate-combobox" name="dept" style="width:120px;">
                    <option>选择样式</option>
                    <option>Insdep</option>
                    <option>Bootstrap</option>
                    <option>Gray</option>
                    <option>Metro</option>
                    <option>Material</option>
                </select>
            </div>
        </div>
    </div>
    <div data-options="region:'west',split:true,border:true" title="操作" style="width:240px;">
        <div title="用户管理">
            <ul class="easyui-tree">
                <li><span><a href="#">用户信息面板1</a></span>
                </li>
                <li><span><a href="#">用户信息面板2</a></span>
                </li>
                <li><span><a href="#">用户综合面板3</a></span>
                </li>
            </ul>
        </div>
        <div title="用户管理">
            <ul class="easyui-tree">
                <li><span><a href="#">用户信息面板1</a></span>
                </li>
                <li><span><a href="#">用户信息面板2</a></span>
                </li>
                <li><span><a href="#">用户综合面板3</a></span>
                </li>
            </ul>
        </div>
    </div>
</div>
</div>


<!--第三方插件加载-->
<script src="<%=path%>/js/plugin/justgage/raphael-2.1.4.min.js"></script>
<script src="<%=path%>/js/plugin/justgage/justgage.js"></script>
<script src="<%=path%>/js/plugin/Highcharts/highcharts.js"></script>
<script type="text/javascript" src="<%=path%>/js/plugin/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="<%=path%>/js/plugin/ueditor/ueditor.all.min.js"></script>
<link href="<%=path%>/js/plugin/cropper/cropper.min.css" rel="stylesheet" type="text/css">
<script src="<%=path%>/js/plugin/cropper/cropper.min.js"></script>
<!--第三方插件加载结束-->
</body>
</html>