package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.User;
import dao.UserDao;

public class UpdateServlet extends HttpServlet {
    /**
     * 查询到选中ID的值所对应的数据
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
        String idStr = req.getParameter("id");
        if (idStr != null && !idStr.equals("")) {
            int id = Integer.valueOf(idStr);
            UserDao dao = new UserDao();
            User user = dao.selectUserById(id);
            req.setAttribute("user", user);
        }
        req.getRequestDispatcher("update.jsp").forward(req, resp);
    }

    /**
     * 根据此ID对数据的值进行修改
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
        String idStr = req.getParameter("id");
        if (idStr != null && !idStr.equals("")) {
            int id = Integer.valueOf(idStr);
            String name = req.getParameter("name");
            Integer age = Integer.valueOf(req.getParameter("age"));
            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setAge(age);
            UserDao dao = new UserDao();
            dao.updateUser(user);
        }
        req.getRequestDispatcher("list").forward(req, resp);
    }
}