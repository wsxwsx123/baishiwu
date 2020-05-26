<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html public "-//w3c//dtd html 4.0 transitional//en">
<!-- saved from url=(0048)http://localhost:8080/contract/register.jsp?id=6 -->
<html>
<head><title>edit</title>
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

    #register {
        padding-right: 10px;
        padding-left: 10px;
        padding-bottom: 10px;
        width: 300px;
        padding-top: 10px;
        background-color: #eaf2d3
    }
    </style>
    <meta content="mshtml 6.00.2900.5726" name=generator>
</head>
<body>
<h3>编辑通讯录 </h3>

<div id=register>
    <form action="update" method=post>
        <input type=hidden value="${contact.id}" name=id>
        <table>
            <tbody>
            <tr>
                <td align=right>姓名：</td>
                <td><input value="${contact.name}" name=name></td>
                <td class="error"><%=request.getAttribute("error_name")!=null?request.getAttribute("error_name"):""%></td>
            </tr>
            <tr>
                <td align=right>性别：</td>
                <td>男 <input type=radio ${contact.sex eq 'm' || contact.sex eq 'M'?"checked":""} value=m name=sex>
                    女<input type=radio ${contact.sex eq 'f' || contact.sex eq 'F'?"checked":""}  value=f name=sex>
                </td>
            </tr>
            <tr>
                <td align=right>学号：</td>
                <td><input value="${contact.stuid}" name=stuid readonly></td>
            </tr>
            <tr>
                <td align=right>班级：</td>
                <td><select name=classInfo.id>
                    <c:if test="${classes!=null}">
                        <c:forEach items="${classes}" var="classInfo">
                            <option value="${classInfo.id}" ${contact.classInfo.id==classInfo.id?"selected":""}>${classInfo.name}</option>
                        </c:forEach>
                    </c:if>
                </select>
                </td>
            </tr>
            <tr>
                <td align=right>手机号码：</td>
                <td><input value="${contact.mobile}" name=mobile></td>
            </tr>
            <tr>
                <td align=right>电子邮件：</td>
                <td><input value="${contact.email}" name=email></td>
            </tr>
            <tr>
                <td align=right>qq号码：</td>
                <td><input value="${contact.qq}" name=qq></td>
            </tr>
            <tr>
                <td></td>
                <td><input type=submit value=编辑> <input type=reset value=重置>
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

