package com.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable; // Consider using HashMap instead

import javax.security.auth.login.LoginException;

import oracle.iam.identity.usermgmt.api.UserManager;
import oracle.iam.identity.usermgmt.vo.User;
import oracle.iam.identity.usermgmt.vo.UserManagerResult;
import oracle.iam.platform.OIMClient;

public class Main {

    public static void main(String[] args) throws Exception {

        OIMClient oimClient = Login.createSession("xelsysadm", "welcome1".toCharArray());
        System.out.println(oimClient);

        Users user = new Users();
        user.findBy("User Login", "M*"); // Wildcard search for users starting with "M"

//        user.findAll();  // Uncomment to find all users (may be inefficient for large datasets)
//        user.findByUserLogin("MOSHIN12");  // Find user with exact login "MOSHIN12"
//        user.findByUserLogin("mo*");  // Find users with login starting with "mo*"

//        Users user = new Users();
//        user.create(oimClient);  // Uncomment to create a new user (requires appropriate permissions)

        oimClient.logout();
        System.exit(0);
    }
}
