<%--
  Created by IntelliJ IDEA.
  User: JAVASM
  Date: 2020/12/14
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录页面</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-6 col-lg-offset-3">
            <%--登录界面--%>
            <form class="form-horizontal" action="loginServlet" method="post">
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">名称</label>
                    <div class="col-sm-10">
                        <input type="test" class="form-control" id="inputEmail3" placeholder="name" name="customerName">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="inputPassword3" placeholder="pwd" name="pwd">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" name="flagRemeber"> 记住密码
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-2">
                        <button type="submit" class="btn btn-default">登录</button>
                    </div>
                    <div class="col-sm-offset-2 col-sm-2">
                        <a class="btn btn-default" href="#" role="button">注册</a>
                    </div>
                </div>
                <div class="col-lg-offset-2" >
                    <c:if test="${requestScope.message != null}">
                        <span style="color: red">${requestScope.message}</span>
                    </c:if>
                </div>


            </form>

        </div>
    </div>
</div>

</body>
</html>
