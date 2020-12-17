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
    <title>班级表</title>
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
                localUrl = localUrl + '/classInfoServlet?way=deleteMoreClass&id=';
                var ids = $(":checked").parent().next("td");
                for (var i = 0; i < ids.length; i++) {
                    console.log(ids[i].innerText);
                    localUrl = localUrl + ids[i].innerText + " ";
                }
                console.log(localUrl);
                window.location.href = localUrl;
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

            // 给班级添加验证
            $("[name='className']").blur(function () {
                var pwd = $(this).val();
                var reg = /^(\d){3}班$/;
                if (reg.test(pwd)) {
                    $(this).next().html("地址输入正确");
                } else {
                    $(this).next().html("地址有误");
                    $(this).focus();
                }
            });


            //点击修改按钮把对应的学生信息上传到模态框
            $(".updateStu").click(function () {
                var student = $(this).parent().siblings("td");

                // $("[name='stuId']").val(student[0].innerText);
                $("[name='classId']").attr("value", student[0].innerText);
                $("[name='classId']").prop("placeholder", student[0].innerText);

                $("[name='className']").attr("value", student[1].innerText);
                $("[name='className']").prop("placeholder", student[1].innerText);

                /*var sex= $("[name='stuSex']").filter("[value='"+student[2].innerText+"']");*/
                var dateTime = student[2].innerText;
                dateTime = dateTime.replace(" ","T")
                $("[name='classDate']").val(dateTime);


                $("[name='classNote']").attr("value", student[3].innerText);
                $("[name='classNote']").prop("placeholder", student[3].innerText);

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
                <caption align="center">班级信息表</caption>
                <tr>
                    <td colspan="5">
                        <button class="btn btn-primary" id="btn_saveStudent" data-toggle="modal"
                                data-target="#addStudent">添加
                        </button>
                        <button class="btn btn-primary" id="btn_deleteStudent">删除</button>
                    </td>
                </tr>
                <tr>
                    <th width="30px">
                        <input type="checkbox" id="checkAll"/>
                    </th>
                    <th>班级名称</th>
                    <th>开学日期</th>
                    <th>班级口号</th>
                    <th>操作</th>

                </tr>
                <c:forEach items="${requestScope.classInfoList}" var="classInfo" varStatus="status">
                    <tr>
                        <th width="30px">
                            <input type="checkbox">
                        </th>
                        <td style="display:none;">${classInfo.classId}</td>
                        <td>
                            <a href="studentServlet?way=showById&stuClass=${classInfo.classId}">${classInfo.className}</a>
                        </td>
                        <td>${classInfo.classDate}</td>
                        <td>${classInfo.classNote}</td>
                        <td>
                            <a class="btn btn-primary updateStu" data-toggle="modal"
                               data-target="#updateStudent">修改</a>
                            <a class="btn btn-primary"
                               href="classInfoServlet?way=deleteClassInfo&classId=${classInfo.classId}"
                               style="background-color: red">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

<%--添加班级信息模态框--%>
<div class="modal fade" id="addStudent" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form action="classInfoServlet?way=addClassInfo" method="post">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">添加班级信息</h4>
                </div>
                <div class="modal-body">
                    <div class="container">
                        <%--主体部分--%>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-sm-6 col-xs-6">
                                    <label for="exampleInputEmail1">班级名字</label>
                                    <input type="test" name="className" class="form-control" id="exampleInputEmail2"
                                           placeholder="className">
                                    <span></span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <div class="col-sm-6 col-xs-6">
                                    <label for="exampleInputPassword1">班级日期</label>
                                    <input type="datetime-local" name="classDate" class="form-control"
                                           id="exampleInputPassword2">
                                    <span></span>
                                </div>
                            </div>
                        </div>
                        <div>
                            <div class="row">
                                <div class="col-sm-6 col-xs-6">
                                    <input type="text" name="classNote" class="form-control" id="exampleInputPassword6"
                                           placeholder="classNote">
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

<!-- 修改模态框 -->
<div class="modal fade" id="updateStudent" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form action="classInfoServlet?way=updateClassInfo" method="post">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel02">修改班级信息</h4>
                </div>
                <div class="modal-body">
                    <%--主体部分--%>
                    <input class="form-control" type="text" name="classId" value="0" placeholder="0" readonly>
                    <div class="form-group">
                        <label for="exampleInputEmail1">班级名字</label>
                        <input type="test" name="className" class="form-control" id="exampleInputEmail1"
                               placeholder="className">
                        <span></span>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">班级日期</label>
                        <input type="datetime-local" name="classDate" class="form-control"
                               id="exampleInputPassword1">
                        <span></span>
                    </div>
                    <div>
                        <input type="text" name="classNote" class="form-control" id="exampleInputPassword5"
                               placeholder="classNote">
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
