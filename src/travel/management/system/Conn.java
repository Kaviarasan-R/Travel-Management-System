package travel.management.system;

import java.sql.*;


public class Conn {
    public static void main(String[] args) {
        new Conn();
    }
    Statement statement;
    
    public Conn(){
        try{
//            E:\\Java Projects\\Travel Management System\\
            java.sql.Connection conn = DriverManager.getConnection("jdbc:sqlite:tms.db");
            statement = conn.createStatement();
//            statement.execute("DROP TABLE IF EXISTS ACCOUNT");
            statement.execute("CREATE TABLE IF NOT EXISTS ACCOUNT(username TEXT,name TEXT,password TEXT,security TEXT,answer TEXT)");
            statement.execute("CREATE TABLE IF NOT EXISTS CUSTOMER(username TEXT,ID TEXT,number TEXT,name TEXT,gender TEXT,country TEXT,address TEXT,phone TEXT,email TEXT)");
            statement.execute("CREATE TABLE IF NOT EXISTS BOOKPACKAGE(username TEXT,package TEXT,totalpersons TEXT,ID TEXT,number TEXT,phone TEXT,totalprice TEXT)");
            statement.execute("CREATE TABLE IF NOT EXISTS BOOKHOTEL(username TEXT,hotel TEXT,totalpersons TEXT,days TEXT,ac TEXT,food TEXT,ID TEXT,number TEXT,phone TEXT,totalprice TEXT)");
                        
            System.out.println("DataBase Connected Successfully");
            
        }catch(Exception e){
            
            System.out.println("DataBase Error" + e);
        }
    }
}
