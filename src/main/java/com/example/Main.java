package com.example;

import Thor.API.Security.XLClientSecurityAssociation;
import com.example.gui.Dashboard;
import com.thortech.xl.dataaccess.tcDataBaseClient;
import com.thortech.xl.dataaccess.tcDataProvider;
import com.thortech.xl.dataaccess.tcDataSet;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Logger;

import com.thortech.xl.crypto.*;
import com.thortech.xl.dataaccess.tcDataSetException;


public class Main {

    public static void main(String[] args) throws Exception {
//        DatabaseConnection.testConnection();

//        Login login = new Login();
//        OIMClient oimClient = login.getSession();
//        System.out.println(oimClient);
        Dashboard guiMain = new Dashboard();
//          new UserModifications(oimClient).passwordReset("12003");  
//        Users user = new Users();
//        user.findBy("User Login", "M*"); // Wildcard search for users starting with "M"
//            user.getUserLogin("mo*");
//        user.getAdministratorsOfOrganization("Xell*");
//        user.findAll();  // Uncomment to find all users (may be inefficient for large datasets)
//        user.findByUserLogin("Swing*");  // Find user with exact login "MOSHIN12"
//        user.findByUserLogin("mo*");  // Find users with login starting with "mo*"

//        Users user = new Users();
//        
//        HashMap<String, Object> createAttributes = new HashMap<String, Object>();
//
//        createAttributes.put("User Login", "H11User2");
//        createAttributes.put("First Name", "H11 FIRST2");
//        createAttributes.put("Last Name","H11 LAST2");
//        createAttributes.put("act_key", 1l);
//        createAttributes.put(oracle.iam.identity.utils.Constants.PASSWORD, "Welcome1$2");
//        createAttributes.put("Xellerate Type", "End-User");
//        createAttributes.put("Role", "Full-Time");
//        
//        user.create(createAttributes);  // Uncomment to create a new user (requires appropriate permissions)
//        login.destroySession();
//        System.exit(0);

//



    }
}










//////////////////////////// getting the database columns through the oim ###################################
//        tcDataProvider dbProvider = null;
//        try
//        {
//            XLClientSecurityAssociation.setClientHandle(Login.createSession());//Needed for database client
//            dbProvider = new tcDataBaseClient(); //Connection to OIM Schema
//            tcDataSet dataSet = new tcDataSet(); //Stores the result set of an executed query
//            String query = "SELECT * FROM USR"; //Query Users table
//            //String query = "SELECT * FROM PCQ"; //Query Users Challenge Question
//            dataSet.setQuery(dbProvider, query); //Set query and database provider
//            dataSet.executeQuery(); //execute query and store results into dataSet object
//            int records = dataSet.getTotalRowCount(); //Get total records from result set
//            for(int i = 0; i < records; i++)
//            {
//                dataSet.goToRow(i); //move pointer to next record
//                String plainTextPassword = dataSet.getString("USR_PASSWORD");
//                String userLogin = dataSet.getString("USR_LOGIN");
//                String userStatus = dataSet.getString("USR_STATUS");
//                System.out.printf("User Login: %s\nStatus: %s\nPassword: %s\n\n", userLogin, userStatus, plainTextPassword);
//                System.out.println(plainTextPassword);
//                //Getting user challenge questions and answers
//                //String usrKey = dataSet.getString("USR_KEY");
//                //String question = dataSet.getString("PCQ_QUESTION");
//                //String answer = dataSet.getString("PCQ_ANSWER");
//                //System.out.printf("USR_KEY: %s\nQuestion: %s\nAnswer: %s\n", usrKey, question, answer);
//            }
//        }
//        catch (tcDataSetException ex)
//        {
////            Logger.getLogger(DecryptedOIMPassword.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        finally
//        {
//            //close connections
//            try{dbProvider.close();} catch(Exception e){}
//            try{XLClientSecurityAssociation.clearThreadLoginSession();} catch(Exception e){}
//
//        }
/////////////////////////////////////##############################################################

