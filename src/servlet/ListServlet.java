package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.User;
import dao.UserDao;

//@WebServlet("/list")
//上面注释的是WebServlet3.0的使用方式，通过这样的注解，不需要配置web.xml也可运行程序
public class ListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao dao = new UserDao();
        List<User> list = dao.getAllUser();
        req.setAttribute("userInfoList", list);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
        
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
    
}