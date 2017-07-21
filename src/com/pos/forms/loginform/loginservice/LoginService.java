/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.forms.loginform.loginservice;

import com.pos.beans.User;
import com.pos.forms.loginform.logindao.LoginDao;
import com.pos.forms.loginform.logindao.LoginDaoImpl;
import com.pos.forms.stocks.stocksdao.StocksDao;
import com.pos.forms.stocks.stocksdao.StokcsDaoImpl;

/**
 *
 * @author AbidAli
 */
public class LoginService {
 
    public boolean checkUser(User user)
    {
        LoginDao loginDao = new LoginDaoImpl();
        boolean userExists = false;
        if(null != user)
        {
            userExists =  loginDao.checkUser(user);
        }
        else
        {
            System.out.println("user object is null");
            userExists =  false;
        }
        return userExists;
    }
    
    
}
