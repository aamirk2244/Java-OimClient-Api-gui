package com.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable; 

import javax.security.auth.login.LoginException;

import javax.swing.SwingUtilities;

import oracle.iam.identity.usermgmt.api.UserManager;
import oracle.iam.identity.usermgmt.vo.User;
import oracle.iam.identity.usermgmt.vo.UserManagerResult;
import oracle.iam.platform.OIMClient;
import com.example.*;
import com.example.gui.Dashboard;
import com.example.gui.components.PopupBox;

public class Main {

    public static void main(String[] args) throws Exception {

        OIMClient oimClient = Login.createSession("xelsysadm", "welcome1".toCharArray());
        System.out.println(oimClient);
//        InputTest field = new InputTest();
//        Dashboard guiMain = new Dashboard();
          new UserModifications().passwordReset("12003");  
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

        oimClient.logout();
//        System.exit(0);
    }
}
