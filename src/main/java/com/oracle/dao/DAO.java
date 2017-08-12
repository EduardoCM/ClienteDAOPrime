package com.oracle.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
    
    private Connection con;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }
    
    public void Conectar() throws ClassNotFoundException{
      String url = "jdbc:derby://localhost:1527/";
      String dbName = "Tienda";
      String driver = "org.apache.derby.jdbc.ClientDriver";
      String userName = "root";
      String password = "root";
      
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url+dbName, userName,password);
        } catch (Exception ex) {
           ex.printStackTrace();
        }     
      
    }
    
    public void cerrar(){
        try{
        if(con != null){
            if(con.isClosed() == false){
            con.close();
            }
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
  
}
