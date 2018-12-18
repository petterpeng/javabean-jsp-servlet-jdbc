package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.User;
import dao.UserDao;

public class AddServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        Integer age = Integer.valueOf(req.getParameter("age"));
        User user = new User();//创建user对象
        user.setName(name);
        user.setAge(age);
        UserDao dao = new UserDao();
        dao.addUser(user);//添加到数据库中
        req.getRequestDispatcher("list").forward(req, resp);
    }
}