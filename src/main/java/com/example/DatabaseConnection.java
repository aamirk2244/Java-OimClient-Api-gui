package com.example;
import java.sql.DriverManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {

    public static void testConnection() {
                try{
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//10.2.2.251:1521/oimdb", "DEV2_oim", "welcome1");

////step1 load the driver class
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());

//step3 create the statement object
            System.out.println("check conn " + con);
            Statement stmt=con.createStatement();

////step4 execute query
            ResultSet rs=stmt.executeQuery("SELECT USR_LOGIN, USR_PASSWORD from USR");
            System.out.println("rs is " + rs);
            while(rs.next())
                System.out.println(rs.getString(1)+"  "+rs.getString(2));

//step5 close the connection object
            con.close();

        }catch(Exception e){ System.out.println(e);}

    }

}
