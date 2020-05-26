<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html public "-//w3c//dtd html 4.0 transitional//en">
<!-- saved from url=(0043)http://localhost:8080/contract/register.jsp -->
<html>
<head><title>register</title>
    <meta http-equiv=content-type content="text/html; charset=utf-8">
    <meta http-equiv=pragma content=no-cache>
    <meta http-equiv=cache-control content=no-cache>
    <meta http-equiv=expires content=0>
    <meta http-equiv=keywords content=keyword1,keyword2,keyword3>
    <meta http-equiv=description content="this is my page"><!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <style>body {
        text-align: center
    }

    .error {
        color:red;
        width: 300px;
    }

    #register {
        padding-right: 10px;
        padding-left: 10px;
        padding-bottom: 10px;
        width: 600px;
        padding-top: 10px;
        background-color: #eaf2d3
    }
    </style>

    <meta content="mshtml 6.00.2900.5726" name=generator>
</head>
<body>
<h3>注册个人通讯录 </h3>
<div id=register>
    <form action="register" method="GET">
        <table>
            <tbody>
            <tr>
                <td align=right>姓名：</td>
                <td><input name=name></td>
                <td class="error"><%=request.getAttribute("error_name")!=null?request.getAttribute("error_name"):""%></td>
            </tr>
            <tr>
                <td align=right>性别：</td>
                <td>男 <input type=radio value=m name=sex> 女 <input type=radio value=f
                                                                   name=sex></td>
            </tr>
            <tr>
                <td align=right>学号：</td>
                <td><input name=stuid></td>
                <td class="error"><%=request.getAttribute("error_stuid")!=null?request.getAttribute("error_stuid"):""%></td>

            </tr>
            <tr>
                <td align=right>班级：</td>
                <td><select name=classInfo.id>
                    <c:if test="${classes!=null}">
                        <c:forEach items="${classes}" var="classInfo">
                            <option value="${classInfo.id}">${classInfo.name}</option>
                        </c:forEach>
                    </c:if>
                </select>
                </td>
            </tr>
            <tr>
                <td align=right>手机号码：</td>
                <td><input name=mobile></td>
            </tr>
            <tr>
                <td align=right>电子邮件：</td>
                <td><input name=email></td>
            </tr>
            <tr>
                <td align=right>qq号码：</td>
                <td><input name=qq></td>
            </tr>
            <tr>
                <td></td>
                <td><input type=submit value=注册> <input type=reset value=重置>
                </td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
<div>返回 <a href="index.jsp">主页面</a>
</div>
</body>
</html>
