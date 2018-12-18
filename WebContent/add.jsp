<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增用户</title>
<script type="text/javascript">  
    function check(form) {  
        with (form) {  
            if (name.value == "") {  
                alert("用户名不能为空");  
                return false;  
            }  
        }  
    }  
</script>
</head>
<body>
<form action="add" method="post" onsubmit="check(this)">  
    <table align="center" width="450">  
        <tr>  
            <td align="center" colspan="2">  
                <h2>添加用户信息</h2>  
                <hr>  
            </td>  
        </tr>  
        <tr>  
            <td align="right">用户名：</td>  
            <td><input type="text" name="name"></td>  
        </tr>  
        <tr>  
            <td align="right">年龄：</td>  
            <td><input type="text" name="age"></td>  
        </tr>  
        <tr>  
            <td align="center" colspan="2">
                <input type="submit" value="添　加">  
            </td>  
        </tr>  
    </table>  
</form>  
</body>
</html>