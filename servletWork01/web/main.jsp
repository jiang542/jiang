<%@ page import="javasm.entity.Customer" %><%--
  Created by IntelliJ IDEA.
  User: JAVASM
  Date: 2020/12/14
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主界面</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <style>
        .container-fluid {
            padding: 0px;
            margin: 0px;
        }

        .navbar-brand {
            padding-left: 30px;
        }
    </style>
</head>
<body>
<%--style="overflow: hidden"--%>
<div class="container-fluid">

    <%-- 导航条开始 --%>
    <nav class="navbar navbar-default navbar-inverse">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">首页</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="#">
                            <img src="img/stick.gif" width="30px" height="20px" class="img-rounded">
                            <%
                                //获取session中登录的用户对象
                                Object customer = session.getAttribute("loginCustomer");
                                if (customer != null){
                                    Customer cus = (Customer) customer;
                                    out.write(cus.getCustomerName()+",欢迎你");
                                }
                            %>
                        </a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">个人中心 <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">修改密码</a></li>
                            <li><a href="#">查看个人信息</a></li>
                            <li><a href="#">你懂的</a></li>
                        </ul>
                    </li>


                    <li><a href="exitServlet">登出</a></li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
    <%-- 导航条结束 --%>

    <%--中间主要部分 开始--%>
    <div class="row">
        <%--左边侧边导航 开始--%>
        <div class="col-sm-2">
            <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingOne">
                        <h4 class="panel-title">
                            <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                系统管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                        <div class="panel-body">
                            <%--  二级菜单 --%>
                            <ul class="list-group">
                                <li class="list-group-item">
                                    <a data-url="customerServlet?way=showAll">管理员表</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingTwo">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                班级管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                        <div class="panel-body">
                            <%--  二级菜单 --%>
                            <ul class="list-group">
                                <li class="list-group-item">
                                    <a data-url="classInfoServlet?way=showAll">班级信息表</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="headingThree">
                        <h4 class="panel-title">
                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                学生管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                        <div class="panel-body">
                            <%--  二级菜单 --%>
                            <ul class="list-group">
                                <li class="list-group-item">
                                    <%-- data-url：自定义属性（html5） --%>
                                    <%-- 点击li之后获取a标签上的data-url的值，将a表的data-url设置给iframe的src --%>
                                    <%--  showAllRole：查询角色的servlet的路径  --%>
                                    <a data-url="studentServlet?way=showAll">学生信息表</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%--左边侧边导航 结束--%>

        <%--主体内容 开始--%>
        <div class="col-sm-10">
            <iframe id="content" src="index.jsp" width="100%"  frameborder="1" seamless ></iframe>
        </div>
        <%--主体内容 结束--%>

    </div>
    <%--中间主要部分 结束--%>

</div>


<script>
    window.onresize=function(){
        //获取浏览器的高度
        var windowsHeight = window.innerHeight;

        //给iframe设置高度
        $("#content").prop("height",(windowsHeight-100)+"px");
    }

    $(function () {
        //获取浏览器的高度
        var windowsHeight = window.innerHeight;

        //给iframe设置高度
        $("#content").prop("height",(windowsHeight-100)+"px");

        $(".list-group-item").click(function () {
            // alert("123");
            var url = $(this).children("a").attr("data-url");
            $("#content").attr("src",url);
        });


    });
</script>
</body>
</html>
