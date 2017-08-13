/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.forms.loginform.logindao;

import com.pos.forms.stocks.stocksdao.StocksDao;
import com.pos.beans.User;
import com.pos.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author AbidAli
 */
public class LoginDaoImpl extends LoginDao{

    private static final String USER_LOGIN_QUERY =  "select user_name, user_password, user_id from users where user_name= ? and user_password= ? ";
    @Override
    public boolean checkUser(User user) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(USER_LOGIN_QUERY);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
  
            rs = ps.executeQuery();
            if (rs.next()) // found
            {
                user.setId(Long.parseLong(rs.getString("user_id")));      // to use user_id it in sale insert
                System.out.println("User found : " + rs.getString("user_name"));
                return true;
            }
            else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            return false;
        } finally {
            DBUtils.close(con);
            DBUtils.closeResultSet(rs);
            DBUtils.closePreparedStmnt(ps);
        }
    }
    
}
