/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pos.utils;

import com.pos.beans.Products;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JComboBox;


/**
 *
 * @author AbidAli
 */
public class DBUtils {
    
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos",
                    "root", "root");
            return con;
        } catch (Exception ex) {
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
            return null;
        }
    }
 
    public static void close(Connection con) {
        try {
            if(null!=con)
            {
                con.close();
            }
        } catch (Exception ex) {
            System.out.println("connection closing exception : "+ ex);
        }
    }
    
       public static void closePreparedStmnt(PreparedStatement pstment) {
        try {
            if(null!=pstment)
            {
                pstment.close();
            }
        } catch (Exception ex) {
            System.out.println("prepared statement closing exception : "+ ex);
        }
    }
          public static void closeResultSet(ResultSet resultSet) {
        try {
            if(null!=resultSet)
            {
                resultSet.close();
            }
        } catch (Exception ex) {
            System.out.println("resultSet closing exception : "+ ex);
        }
    }
          
  public static void addItemsToCombo(JComboBox combo, List listToAdd, String title)
  {
      combo.addItem(title);
      for (Object obj : listToAdd) {
        combo.addItem(obj.toString());
      
        }
  }

   
}
