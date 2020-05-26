<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html public "-//w3c//dtd html 4.0 transitional//en">
    <!-- saved from url=(0031)http://localhost:8080/contract/ -->
    <html>
    <head><title>main</title>
    <meta http-equiv=content-type content="text/html; charset=gb2312">
    <meta http-equiv=pragma content=no-cache>
    <meta http-equiv=cache-control content=no-cache>
    <meta http-equiv=expires content=0>
    <meta http-equiv=keywords content=keyword1,keyword2,keyword3>
    <meta http-equiv=description content="this is my page"><!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <style type=text/css>#customers {
        width: 100%;
        font-family: "trebuchet ms", arial, helvetica, sans-serif;
        border-collapse: collapse
    }

    #customers td {
        border-right: #98bf21 1px solid;
        padding-right: 7px;
        border-top: #98bf21 1px solid;
        padding-left: 7px;
        font-size: 1em;
        padding-bottom: 2px;
        border-left: #98bf21 1px solid;
        padding-top: 3px;
        border-bottom: #98bf21 1px solid
    }

    #customers th {
        border-right: #98bf21 1px solid;
        padding-right: 7px;
        border-top: #98bf21 1px solid;
        padding-left: 7px;
        font-size: 1em;
        padding-bottom: 2px;
        border-left: #98bf21 1px solid;
        padding-top: 3px;
        border-bottom: #98bf21 1px solid
    }

    #customers th {
        font-size: 1.1em;
        padding-bottom: 4px;
        color: #ffffff;
        padding-top: 5px;
        background-color: #a7c942;
        text-align: left
    }

    #customers tr.alt td {
        color: #000000;
        background-color: #eaf2d3
    }
    </style>
</head>
<body>
<div style="text-align: right">通讯录
    <a href="toRegister">注册</a>
    <c:if test="${sessionScope.admin != null}">当前用户：${admin.name}
        <a href="logout">退出</a>
    </c:if>
    <c:if test="${sessionScope.admin==null}">
        <a href="toLogin">登陆</a>
    </c:if>
</div>
<h3>通讯录列表 </h3>

<div>
    <form action="searchByCondition">
        性别：
        <select name="sex">
            <option value="">所有</option>
            <option value="m" ${param.sex eq 'm' || param.sex eq 'M'? 'selected':''}>男</option>
            <option value="f" ${param.sex eq 'f' || param.sex eq 'F'?'selected':''}>女</option>
        </select>
        班级：<select name="classId">
        <option value="0">所有</option>
        <c:if test="${classes!=null}">
            <c:forEach items="${classes}" var="classInfo">
                <option value="${classInfo.id}" ${param.classId==classInfo.id?'selected':''}>${classInfo.name}</option>
            </c:forEach>
        </c:if>
    </select>
        关键字：<input name="name" placeholder="请输入姓名" value="${param.name}"> <input type="submit" value="查询">
    </form>
</div>
<table id=customers>
    <thead>
    <tr>
        <th witdh="10%">姓名</th>
        <th witdh="10%">性别</th>
        <th witdh="15%">学号</th>
        <th witdh="15%">班级</th>
        <th witdh="20%">手机号码</th>
        <th witdh="20%">电子邮件</th>
        <th witdh="10%">qq号码</th>
        <c:if test="${sessionScope.admin!=null}">
            <th witdh="10%">操作</th>
        </c:if>
    </tr>
    </thead>
    <tbody>
        <c:if test="${contacts!=null}">
            <c:forEach items="${contacts}" var="contact">
                <tr>
                    <td>${contact.name}</td>
                    <td>${contact.sex eq 'm' || contact.sex eq 'M'?'男':'女'}</td>
                    <td>${contact.stuid}</td>
                    <td>${contact.classInfo.name}</td>
                    <td>${contact.mobile}</td>
                    <td>${contact.email}</td>
                    <td>${contact.qq}</td>
                    <c:if test="${sessionScope.admin!=null}">
                        <td witdh="10%">
                            <a href="toEdit/id=${contact.id}">编辑</a>
                            <a href="delete?id=${contact.id}">删除</a>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </c:if>
    </tbody>
</table>
</body>
</html>

