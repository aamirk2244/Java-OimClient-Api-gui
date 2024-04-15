package com.example;

import java.io.IOException;

import java.util.HashMap;
import java.util.Hashtable;

import javax.security.auth.login.LoginException;

import oracle.iam.identity.usermgmt.api.UserManager;
import oracle.iam.identity.usermgmt.vo.User;
import oracle.iam.identity.usermgmt.vo.UserManagerResult;
import oracle.iam.platform.OIMClient;


import oracle.iam.platform.OIMClient;
import Thor.API.tcResultSet;

import java.util.HashSet;
import java.util.Set;
import java.util.HashSet;
import java.util.Hashtable;

import java.util.List;
import java.util.Set;

import oracle.iam.platform.OIMClient;
import oracle.iam.identity.usermgmt.api.UserManager;
import oracle.iam.platform.entitymgr.vo.SearchCriteria;
import oracle.iam.identity.usermgmt.vo.User;


import oracle.iam.platform.entitymgr.vo.SearchCriteria;

public class Users {
    private OIMClient oimClient;
    public Users() {
        super();
        oimClient =  Login.getSession();
    }
    
    public void create(OIMClient oimClient)throws Exception {
        
        String userLogin = "jawad_NOw2"; 
        Hashtable<String, String> env = new Hashtable<String, String>();
        
        UserManager usrMgr = oimClient.getService(UserManager.class);
        UserManagerResult userResult = null;
        String userKey = null;

        userResult = usrMgr.create(new User(null,user_params()));
        userKey = userResult.getEntityId();
        System.out.println("Created user with key = " + userKey);
        
    }
    
    public void findAll() throws Exception {
           
        UserManager usrMgr = oimClient.getService(UserManager.class);
        SearchCriteria criteria = new SearchCriteria("User Login","*", SearchCriteria.Operator.EQUAL);
           
        List<User> users = usrMgr.search(criteria, retColumns(), null);
        System.out.println(users);
//
//           for(User user : users) {
//               System.out.println("********COLUMNS********" + user.getAttributeNames());
//               
//               Long usrKey = (Long)user.getAttribute("usr_key");
//                 System.out.println("UserKey-> " +  usrKey);
//               System.out.println(user);
//           
//       }
    }

    
    public void findBy(String column, String query) throws Exception {
           
           UserManager usrMgr = oimClient.getService(UserManager.class);

           SearchCriteria criteria = new SearchCriteria(column,
               query, SearchCriteria.Operator.EQUAL);

           List<User> users = usrMgr.search(criteria, retColumns(), null);
           System.out.println(users);
       }
    
    public void findByUserLogin(String query) throws Exception {
        findBy("User Login", query);
    }

    public void findByFirstName(String query) throws Exception {
        findBy("First Name", query);
    }

    public void findByLastName(String query) throws Exception {
        findBy("Last Name", query);
    }

    
    private HashMap<String, Object> user_params() {
    
        HashMap<String, Object> createAttributes = new HashMap<String, Object>();

        createAttributes.put("User Login", "H11User");
        createAttributes.put("First Name", "H11 FIRST");
        createAttributes.put("Last Name","H11 LAST");
        createAttributes.put("act_key", 1l);
        createAttributes.put(oracle.iam.identity.utils.Constants.PASSWORD, "Welcome1$2");
        createAttributes.put("Xellerate Type", "End-User");
        createAttributes.put("Role", "Full-Time");
        return createAttributes;

    }
    
    private Set retColumns() {
        Set retSet = new HashSet();
        retSet.add("usr_key");
        retSet.add("User Login");
        retSet.add("First Name");
        retSet.add("Last Name");
        return retSet;
    }
    
}
