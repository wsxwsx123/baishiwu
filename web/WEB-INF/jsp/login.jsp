
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html public "-//w3c//dtd html 4.0 transitional//en">
<!-- saved from url=(0040)http://localhost:8080/contract/login.jsp -->
<html>
<head><title>login</title>
    <meta http-equiv=content-type content="text/html; charset=gb2312">
    <meta http-equiv=pragma content=no-cache>
    <meta http-equiv=cache-control content=no-cache>
    <meta http-equiv=expires content=0>
    <meta http-equiv=keywords content=keyword1,keyword2,keyword3>
    <meta http-equiv=description content="this is my page"><!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <meta content="mshtml 6.00.2900.5726" name=generator>
</head>
<style>
    body {
        text-align: center;
        margin: 0;
    }

    .error{
        color: red;
    }

    #login {
        margin: 0 auto;
        width: 300px;
        background-color: #eaf2d3;
    }
</style>
<body>
<div id="login">
    <h3>系统登陆 </h3>
    <form action="login" method=post>
        <table>
            <tbody>
            <tr>
                <td align=right>账号：</td>
                <td><input style="width: 160px; height: 26px" name=account></td>
            </tr>
            <tr>
                <td align=right>密码：</td>
                <td><input style="width: 160px; height: 26px" type=password name=password>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><input type=submit value=登陆> <input type=reset value=重置>
                </td>
            </tr>
            </tbody>
        </table>
        <div><p class="error"><%=request.getAttribute("error")==null?"":request.getAttribute("error")%></p></div>
        <div>返回 <a href="index.jsp">主页面</a>
        </div>
    </form>
</div>
</body>
</html>

