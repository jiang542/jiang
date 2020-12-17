<%--
  Created by IntelliJ IDEA.
  User: JAVASM
  Date: 2020/12/14
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生表</title>
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
    <script>
        $(function () {
            //获取路径
            var localUrl = '${pageContext.request.contextPath}';
            //获取所有被选中的id
            $("#btn_deleteStudent").click(function () {
                localUrl = localUrl + '/studentServlet?way=deleteMoreStudent&id=';
                var ids = $(":checked").parent().next("td");
                for (var i = 0; i < ids.length; i++) {
                    console.log(ids[i].innerText);
                    localUrl = localUrl + ids[i].innerText + " ";
                }
                console.log(localUrl);
                window.location.href=localUrl;
            });

            //点全选选择全部--取消全选取消全部
            $("#checkAll").click(function () {
                var boolean = $("#checkAll").prop("checked");
                if (boolean == false) {
                    $("[type='checkbox']").prop("checked", false);
                } else {
                    $("[type='checkbox']").prop("checked", "checked");
                }
            });

            // 给地址添加验证
            $("[name='stuAdress']").blur(function () {
                var pwd = $(this).val();
                var reg = /^(\w|[\u4e00-\u9fa5]){6,12}$/;
                if (reg.test(pwd)) {
                    $(this).next().html("地址输入正确");
                } else {
                    $(this).next().html("地址有误");
                    $(this).focus();
                }
            });
            // 给名字添加验证
            $("[name='stuName']").blur(function () {
                var pwd = $(this).val();
                var reg = /^(\w|[\u4e00-\u9fa5]){2,6}$/;
                if (reg.test(pwd)) {
                    $(this).next().html("名字输入正确");
                } else {
                    $(this).next().html("名字有误");
                    $(this).focus();
                }
            });

            //点击修改按钮把对应的学生信息上传到模态框
            $(".updateStu").click(function () {
                var student = $(this).parent().siblings("td");

                // $("[name='stuId']").val(student[0].innerText);
                $("[name='stuId']").attr("value",student[0].innerText);
                $("[name='stuId']").prop("placeholder",student[0].innerText);

                $("[name='stuName']").attr("value",student[1].innerText);
                $("[name='stuName']").prop("placeholder",student[1].innerText);

                /*var sex= $("[name='stuSex']").filter("[value='"+student[2].innerText+"']");*/
                var sex= $("[name='stuSex'][value='"+student[2].innerText+"']");
                sex.attr("checked","checked");
                sex.prop("checked","checked");

                $("[name='stuAdress']").attr("value",student[3].innerText);
                $("[name='stuAdress']").prop("placeholder",student[3].innerText);

                $("[name='stuClass']").attr("value",student[4].innerText);
                $("[name='stuClass']").prop("placeholder",student[4].innerText);
            });
        });
    </script>
</head>
<body>
<%--表格--%>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2">

            <table class="table table-hover">
                <caption align="center">学生表</caption>
                <tr>
                    <td colspan="5">
                        <button class="btn btn-primary" id="btn_saveStudent" data-toggle="modal"
                                data-target="#addStudent">添加
                        </button>
                        <!-- 添加的模态框 -->

                        <button class="btn btn-primary" id="btn_deleteStudent">删除</button>
                    </td>
                </tr>
                <tr>
                    <th width="30px">
                        <input type="checkbox" id="checkAll"/>
                    </th>
                    <th>学生id</th>
                    <th>学生名字</th>
                    <th>学生密码</th>
                    <th>学生生日</th>
                    <th>学生性别</th>
                    <th>操作</th>

                </tr>
                <c:forEach items="${requestScope.studentList}" var="student" varStatus="status">
                    <tr>
                        <th width="30px">
                            <input type="checkbox">
                        </th>
                        <td>${student.stuId}</td>
                        <td>${student.stuName}</td>
                        <td>${student.stuSex}</td>
                        <td>${student.stuAdress}</td>
                        <td>${student.stuClass}</td>
                        <td>
                            <a class="btn btn-primary updateStu" data-toggle="modal"
                               data-target="#updateStudent" >修改</a>
                            <a class="btn btn-primary" href="studentServlet?way=deleteStudent&stuId=${student.stuId}" style="background-color: red">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

<%--添加学生信息--%>
<div class="modal fade" id="addStudent" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form action="studentServlet?way=addStudent" method="post">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">添加学生信息</h4>
                </div>
                <div class="modal-body">
                    <div class="container">
                        <%--主体部分--%>
                        <div class="form-group">
                            <label for="exampleInputEmail1">学生名字</label>
                            <div class="row">
                                <div class="col-sm-6 col-xs-6">
                                    <input type="test" name="stuName" class="form-control" id="exampleInputEmail1"
                                           placeholder="stuName">
                                    <span></span>
                                </div>
                            </div>
                        </div>
                        <div class="radio">
                            <label class="radio-inline">
                                <input type="radio" name="stuSex" id="inlineRadio1" value="男" > 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="stuSex" id="inlineRadio2" value="女"> 女
                            </label>
                            <span></span>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">学生住址</label>
                            <div class="row">
                                <div class="col-sm-6 col-xs-6">
                                    <input type="text" name="stuAdress" class="form-control" id="exampleInputPassword1"
                                           placeholder="stuAdress">
                                    <span></span>
                                </div>
                            </div>
                        </div>
                        <div>
                            <div class="row">
                                <div class="col-sm-6 col-xs-6">
                                    <select class="form-control" name="stuClass">
                                        <option value="401">401</option>
                                        <option value="402">402</option>
                                        <option value="403">403</option>
                                        <option value="404">404</option>
                                        <option value="405">405</option>
                                    </select>
                                    <span></span>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">添加</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="updateStudent" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form action="studentServlet?way=updateStudent" method="post">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel02">修改学生信息</h4>
            </div>
            <div class="modal-body">
                <%--主体部分--%>
                <input class="form-control" type="text" name="stuId" value="0" placeholder="0" readonly>
                <div class="form-group">
                    <label for="exampleInputEmail2">学生名字</label>
                    <input type="test" name="stuName" class="form-control" id="exampleInputEmail2"
                           placeholder="stuName" >
                    <span></span>
                </div>
                <div class="radio">
                    <label class="radio-inline">
                        <input type="radio" name="stuSex" id="inlineRadio3" value="男"> 男
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="stuSex" id="inlineRadio4" value="女"> 女
                    </label>
                    <span></span>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword2">学生住址</label>
                        <input type="text" name="stuAdress" class="form-control" id="exampleInputPassword2"
                               placeholder="stuAdress">
                        <span></span>
                </div>
                <div>
                        <select class="form-control" name="stuClass">
                            <option value="401">401</option>
                            <option value="402">402</option>
                            <option value="403">403</option>
                            <option value="404">404</option>
                            <option value="405">405</option>
                        </select>
                        <span></span>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="submit" class="btn btn-primary">修改信息</button>
            </div>
            </form>
        </div>
    </div>
</div>


</body>
</html>
