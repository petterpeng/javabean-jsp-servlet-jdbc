<%@ page language="java" contentType="text/html; charset=utf-8"  
    pageEncoding="utf-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<%@page import="java.util.List"%>  
<%@page import="common.User"%>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
<title>所有用户</title>  
<style type="text/css">  
td {  
    font-size: 12px;  
}  
h2 {  
    margin: 0px  
}  
</style>  
<script type="text/javascript">  
   
</script>  
</head>  
<body>  
    <h2 align="center">  
        <a href="add.jsp">添加新用户</a>  
    </h2> 
    <br>
    <table align="center" width="450" border="1" height="180"  
        bordercolor="white" bgcolor="black" cellpadding="1" cellspacing="1">  
        <tr bgcolor="white">  
            <td align="center" colspan="7">  
                <h2>所有用户信息</h2>  
            </td>  
        </tr>  
        <tr align="center" bgcolor="#e1ffc1">  
            <td><b>ID</b></td>  
            <td><b>姓名</b></td>  
            <td><b>年龄</b></td>  
            <td colspan="2"><b>操作</b></td>  
        </tr>  
        <%  
            // 获取用户信息集合  
            List<User> list = (List<User>) request.getAttribute("userInfoList");  
            // 判断是否有数据
            if (list == null || list.size() < 1) {  
        %>
                <tr bgcolor="white"><td colspan="5" ><h4 align="center">没有数据</h4></td></tr>
        <%
            } else {  
                // 遍历用户集合中的数据  
                for (User user : list) {  
        %>  
        <tr align="center"  bgcolor="white">  
            <td><%=user.getId()%></td>  
            <td><%=user.getName()%></td>  
            <td><%=user.getAge()%></td>  
            <td >  
               <a href="update?id=<%=user.getId()%>">修改</a>
                 
            </td>  
            <td>  
                <a href="delete?id=<%=user.getId()%>">删除</a>  
            </td>  
        </tr>  
        <%  
            }  
            }  
        %>  
    </table>  
</body>  
</html>