package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

public class DeleteServlet extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id"); // 删除数据的ID，根据ID删除
        if (idStr != null && !idStr.equals("")) {
            int id = Integer.valueOf(idStr);
            UserDao dao = new UserDao();
            dao.deleteUser(id);
        }
        req.getRequestDispatcher("list").forward(req, resp);
    }
}