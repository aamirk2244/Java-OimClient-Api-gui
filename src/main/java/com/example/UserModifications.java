package com.example;

import oracle.iam.identity.usermgmt.api.UserManager;
import oracle.iam.platform.OIMClient;
import javax.security.auth.login.LoginException;
import oracle.iam.identity.exception.UserModifyException;
import oracle.iam.identity.exception.ValidationFailedException;
import oracle.iam.identity.exception.NoSuchUserException;
import oracle.iam.identity.exception.UserManagerException;
import oracle.iam.platform.authz.exception.AccessDeniedException;

public class UserModifications {
    private OIMClient oimClient;

    public UserModifications(OIMClient oimClient) throws Exception {
        this.oimClient = oimClient;
    }
    
    public void passwordReset(String userKey, String newPassword) {

        // Establish a connection to the OIM client (assuming appropriate setup)
        UserManager usrMgr = oimClient.getService(UserManager.class);

        
        try {
            // Attempt password reset
            usrMgr.changePassword(userKey, newPassword.toCharArray(), false, false);
            System.out.println("\nPassword reset successfully for user: " + userKey + "\n");
        } catch (ValidationFailedException e) {
            System.err.println("Password reset failed due to validation errors:");
            e.printStackTrace();
        } catch (UserModifyException e) {
            System.err.println("An error occurred while modifying the user:");
            e.printStackTrace();
        } catch (NoSuchUserException e) {
            System.err.println("The specified user was not found:");
            e.printStackTrace();
        } catch (AccessDeniedException e) {
            System.err.println("You lack the necessary permissions to perform this action:");
            e.printStackTrace();
        } catch (UserManagerException e) {
            System.err.println("An unexpected error occurred with the UserManager:");
            e.printStackTrace();
        }
    }


}
