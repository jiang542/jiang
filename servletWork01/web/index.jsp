<%--
  Created by IntelliJ IDEA.
  User: JAVASM
  Date: 2020/12/15
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>默认页面</title>
</head>
<body>
欢迎今日系统<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script>
        $(function () {
            $("[name=userName]").blur(function () {
                var userName = $(this).val();
                // 1.获取XMLHttpRequest对象
                var httpRequest = new XMLHttpRequest();// 由浏览器的厂商
                // 2.设置请求的信息
                httpRequest.open("get", "${pageContext.request.contextPath}/ajax.do?userName=" + userName);
                // 3.从客户端发送请求到服务器
                httpRequest.send();
                // 4.处理由服务器发送到浏览器的数据（设置回调函数）
                httpRequest.onreadystatechange = function () {
                    // httpRequest.readyState：请求到服务器的状态
                    // 1：由客户端向服务器发送，服务器准备处理用户的请求
                    // 2：服务器接收到了用户的请求，并开始处理
                    // 3：服务器处理完了用户请求，开始响应
                    // 4：响应结束
                    // httpRequest.status：服务器处理请求的状态（404、500、405、200）
                    // httpRequest.responseText：服务器发送到客户端的数据
                    console.log(httpRequest.readyState);
                    console.log(httpRequest.status);
                    if (httpRequest.readyState == 4 && httpRequest.status == 200) {
                        console.log(httpRequest.responseText);
                    }
                }

                // 获取username的值
                // var userName = $(this).val();
                // 访问servlet，验证username是否存在
                <%--location.href = "${pageContext.request.contextPath}/user.do?methodType=checkUserName&userName=" + userName;--%>
            });

            $("#pwd").blur(function () {
                var userName = $("[name=userName]").val();
                var pwd = $(this).val();
                // 获取XMlHttpRequest对象
                var httpRequest = new XMLHttpRequest();
                // 设置请求信息
                httpRequest.open("post", "${pageContext.request.contextPath}/ajax.do");
                // 如果提交方式为post，要设置Content-type
                httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
                // 发送请求到服务器
                httpRequest.send("pwd=" + pwd + "&userName=" + userName);
                // 设置回调函数
                httpRequest.onreadystatechange = function () {
                    console.log(httpRequest.readyState);
                    console.log(httpRequest.status);
                    if (httpRequest.readyState == 4 && httpRequest.status == 200) {
                        console.log(httpRequest.responseText);
                    }
                }
            });


        })

    </script>
</head>
<body>

<div class="container">

    <form action="user" method="post" class="form-horizontal">

        <div class="row">
            <div class="form-group col-md-6 col-md-offset-3">
                <label class="col-md-6 control-label">
                    账号：
                </label>
                <div class="col-md-6">
                    <input type="hidden" name="methodType" value="saveUser">
                    <input type="text" name="userName" value="${userName}" placeholder="请输入账号" class="form-control"
                           required/>
                    <span style="color: red" id="showUsernameMessage">${message}</span>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-6 col-md-offset-3">
                <label class="col-md-6 control-label">
                    密码：
                </label>
                <div class="col-md-6">
                    <input type="text" name="pwd" id="pwd" placeholder="请输入密码" class="form-control" required/>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-6 col-md-offset-3">
                <label class="col-md-6 control-label">
                    性别：
                </label>
                <div class="col-md-6 radio">
                    <label>
                        <input type="radio" name="sex" value="1" checked/> 男
                    </label>
                    <label>
                        <input type="radio" name="sex" value="0"/> 女
                    </label>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-6 col-md-offset-3">
                <label class="col-md-6 control-label">
                    爱好：
                </label>
                <div class="col-md-6 checkbox">
                    <label>
                        <input type="checkbox" name="aiaho"/> 斗地主
                    </label>
                    <label>
                        <input type="checkbox" name="aiaho"/> 钓鱼
                    </label>
                    <label>
                        <input type="checkbox" name="aiaho"/> 摸鱼
                    </label>
                    <label>
                        <input type="checkbox" name="aiaho"/> 睡觉
                    </label>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-6 col-md-offset-3">
                <label class="col-md-6 control-label">
                    电话：
                </label>
                <div class="col-md-6">
                    <input type="text" name="iphone" placeholder="请输入账号" class="form-control"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-6 col-md-offset-3">
                <label class="col-md-6 control-label">
                    生日：
                </label>
                <div class="col-md-6">
                    <input type="date" name="birthday" placeholder="请选择出生年与日" class="form-control"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-6 col-md-offset-3">
                <label class="col-md-6 control-label">
                </label>
                <div class="col-md-6">
                    <button type="submit" class="btn btn-primary">添加用户</button>
                    ${message }
                </div>
            </div>
        </div>

    </form>
</div>
</body>
</html>

</body>
</html>
