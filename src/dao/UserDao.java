package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.User;
import helper.DbHelper;

public class UserDao {
    /**
     * 查询所有用户信息
     * @return
     */
     public List<User> getAllUser(){  
            List<User> list = new ArrayList<User>();  
            Connection conn = DbHelper.getConnection();//连接数据库
            String sql  = "select * from user";  
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet rst = pst.executeQuery();
                while (rst.next()) {
                    User user = new User();
                    user.setId(rst.getInt("id"));  
                    user.setName(rst.getString("name"));
                    user.setAge(rst.getInt("age"));
                    list.add(user);
                }
                rst.close();  
                pst.close();  
            } catch (SQLException e) {
                e.printStackTrace();  
            }
            return list;  
        }
     
        /**
         * 添加用户
         * @param user
         * @return
         */
        public boolean addUser(User user){ 
            String sql = "INSERT INTO `user`(`name`,`age`) VALUES (?,?)";  
            Connection conn = DbHelper.getConnection();
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, user.getName());
                pst.setInt(2, user.getAge());
                int count = pst.executeUpdate();
                pst.close();
                return count>0?true:false; 
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }
        
        /**
         * 修改用户信息
         * @param user
         * @return
         */
        public boolean updateUser(User user){  
            String sql = "UPDATE `user` SET `name`=?,`age`=? WHERE `id` = ?"; 
            Connection conn = DbHelper.getConnection();
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, user.getName());
                pst.setInt(2, user.getAge());
                pst.setInt(3, user.getId());  
                int count = pst.executeUpdate();
                pst.close(); 
                return count>0?true:false;  
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }
        
        /**
         * 删除用户
         * @param id
         * @return
         */
        public boolean deleteUser(int id){  
            String sql = "delete from user where id = ?"; 
            Connection conn = DbHelper.getConnection();
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, id);
                int count = pst.executeUpdate();
                pst.close();
                return count>0?true:false;  
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }
        
        /**
         * 根据ID进行查询用户
         * @param id
         * @return
         */
        public User selectUserById(int id){  
            Connection conn = DbHelper.getConnection();
            String sql  = "select * from user where id = "+id;
            User user = null;
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet rst = pst.executeQuery();
                while (rst.next()) {
                    user = new User();
                    user.setId(rst.getInt("id"));
                    user.setName(rst.getString("name"));
                    user.setAge(rst.getInt("age"));
                }
                rst.close();
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return user;  
        }
}