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


public class Main {
	private static OIMClient oimClient;

	 public static void main(String[] args) throws Exception {
	 	Hashtable<String, String> env = new Hashtable<String, String>();
	 	env.put("java.naming.provider.url", "t3://10.2.2.97:14000/oim");
     	env.put("java.naming.factory.initial", "weblogic.jndi.WLInitialContextFactory");
	    System.setProperty("java.security.auth.login.config", "/home/aamir/aamir-drive/java-oim-api/src/main/resources/lib/authwl.conf");
        System.setProperty("APPSERVER_TYPE", "wls");
	    String username = "xelsysadm";

	 	OIMClient oimClient = new OIMClient(env);
        oimClient.login(username, "welcome1".toCharArray());
		
	 	String userLogin = "jawad_NOw2"; 
		
	 	UserManager usrMgr = oimClient.getService(UserManager.class);
	 	UserManagerResult userResult = null;
	 	HashMap<String, Object> createAttributes = new HashMap<String, Object>();
	 	String userKey = null;

	 	createAttributes.put("User Login", userLogin);
	 	createAttributes.put("First Name", userLogin + "First API JAWAD");
	 	createAttributes.put("Last Name", userLogin + "Last Api JAWAD");
	 	createAttributes.put("act_key", 1l);
	 	createAttributes.put(oracle.iam.identity.utils.Constants.PASSWORD, "Welcome1$2");
	 	createAttributes.put("Xellerate Type", "End-User");
	 	createAttributes.put("Role", "Full-Time");

	 	userResult = usrMgr.create(new User(null,createAttributes));
	 	userKey = userResult.getEntityId();
	 	System.out.println("Created user with key = " + userKey);
		
	 	oimClient.logout();
	 	System.exit(0);
		
	 }

//	     public static void main(String[] args) throws LoginException {
//        System.out.println("Creating client....-------------------------------------");
//        String ctxFactory = "weblogic.jndi.WLInitialContextFactory";
//        String serverURL = "t3://localhost:14000/";
//        String username = "xelsysadm";
//        Hashtable env = new Hashtable();
//        env.put(OIMClient.JAVA_NAMING_FACTORY_INITIAL,ctxFactory);
//        env.put(OIMClient.JAVA_NAMING_PROVIDER_URL, serverURL);
//     System.setProperty("java.security.auth.login.config", "/home/aamir/aamir-drive/oimClient/conf/authwl.conf");
//     System.setProperty("APPSERVER_TYPE", "wls");
//            //  System.setProperty("weblogic.security.SSL.trustedCAKeyStore", "/home/aamir/Oracle/Middleware/Oracle_Home/wlserver/server/lib/DemoTrust.jks"); // Provide if using SSL
//
//            
//         oimClient = new OIMClient(env);
//         System.out.println("Logging in");               
//         oimClient.login(username, "welcome1".toCharArray());
//         System.out.println("----------------------------executed--------------------------------------");
//        System.out.println("Log in successful");
//     }


}
