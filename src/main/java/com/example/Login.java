package com.example;

import com.example.interfaces.UserSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Hashtable;

import java.util.HashMap;
import java.util.Hashtable;

import javax.security.auth.login.LoginException;

import oracle.iam.identity.usermgmt.api.UserManager;
import oracle.iam.identity.usermgmt.vo.User;
import oracle.iam.identity.usermgmt.vo.UserManagerResult;
import oracle.iam.platform.OIMClient;
import javax.security.auth.login.LoginException;

import oracle.iam.platform.OIMClient;

public class Login implements UserSession{

    private OIMClient oimClient;
    
    public Login() throws LoginException{
        System.out.println("Creating client....-------------------------------------");
        String ctxFactory = "weblogic.jndi.WLInitialContextFactory";
        String serverURL = "t3://10.2.2.97:14000/";
        Hashtable env = new Hashtable();
        env.put(OIMClient.JAVA_NAMING_FACTORY_INITIAL,ctxFactory);
        env.put(OIMClient.JAVA_NAMING_PROVIDER_URL, serverURL);
        System.setProperty("java.security.auth.login.config", "/home/aamir/aamir-drive/oimClient/conf/authwl.conf");
        System.setProperty("APPSERVER_TYPE", "wls");
            //  System.setProperty("weblogic.security.SSL.trustedCAKeyStore", "/home/aamir/Oracle/Middleware/Oracle_Home/wlserver/server/lib/DemoTrust.jks"); // Provide if using SSL
            
        oimClient = new OIMClient(env);
        System.out.println("Logging in");               
        oimClient.login("xelsysadm", "welcome1".toCharArray());
        System.out.println("Log in successful");
        this.oimClient = oimClient;
    }
    
    @Override
    public OIMClient getSession() {
        return oimClient;
    }
    
    @Override
    public void destroySession() {
        oimClient.logout();
        System.out.println("Log out successful");
    }


}
