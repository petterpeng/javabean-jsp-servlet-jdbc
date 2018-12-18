<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="common.User"%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息页面</title>
</head>
<body>
    <div>
        <table>
            <thead>
                <h1>修改用户信息</h1>
            </thead>
            <tbody>
                <form action="update" method="post">
                <tr>
                    <td>ID：</td>
                    <td><input type="text" name="id" value="${user.id}"
                        readonly="readonly" /></td>
                </tr>
                <tr>
                    <td>name：</td>
                    <td><input type="text" name="name" value="${user.name}" /></td>
                </tr>
                <tr>
                    <td>age：</td>
                    <td><input type="text" name="age" value="${user.age}" /></td>
                </tr>
                <tr>
                    <td><input class="btn" type="submit" value="提交" /> <input
                        class="btn" type="reset" value="重置" /></td>
                </tr>
            </tbody>
            </form>
        </table>
    </div>
</body>
</html>