/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.forms.loginform.logindao;

import com.pos.beans.User;

/**
 *
 * @author AbidAli
 */
public abstract class LoginDao {

    /**
     *
     * @param user
     * @return
     */
    public abstract boolean checkUser(User user);
   
}
