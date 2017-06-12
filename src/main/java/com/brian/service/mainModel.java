package com.brian.service;
import java.sql.*;

/**
 * Created by brian-kamau on 6/12/17.
 */
public abstract class mainModel {


    public static String dbUsername ="root";
    public static String dbPassword="wamatu";
    public static String dbUrl="jdbc:mysql://localhost:3306/RestfulApi?useSSL=false";
    public static String dbDriver="com.mysql.cj.jdbc.Driver";
    protected PreparedStatement pst=null;
    protected Statement stat = null;
    protected Connection conn=null;
    protected ResultSet rst=null;


    protected final boolean dbConnect(){
        boolean success = true;
        try{
            Class.forName(dbDriver);
            conn=DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        }catch(Exception ex){
            System.out.println("Database Error"+ex.getMessage());
            ex.printStackTrace();
        }

        return success;
    }
    protected final boolean dbDisconnect(){
        boolean success = true;
        try{
            if(!conn.isClosed()){
                conn.close();
            }
            if(!stat.isClosed()){
                stat.close();
            }
            if(!rst.isClosed()){
                rst.close();
            }

        }catch(Exception ex){
            System.out.println("Disconnecting Database Error"+ex.getMessage());
        }

        return success;
    }



}
