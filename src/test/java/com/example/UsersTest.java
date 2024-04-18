package com.example;

import oracle.iam.identity.usermgmt.api.UserManager;
import oracle.iam.identity.usermgmt.vo.User;
import oracle.iam.identity.usermgmt.vo.UserManagerResult;
import oracle.iam.platform.OIMClient;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsersTest {

    @Mock
    private OIMClient mockOimClient;

    @Mock
    private UserManager mockUserManager;

    @Mock
    private UserManagerResult mockUserManagerResult;

    @Mock
    private User mockUser;


    @org.junit.jupiter.api.Test
    void createUserSuccessfully() throws Exception {
        HashMap<String, Object> userAttributes = new HashMap<>();
        userAttributes.put("First Name", "Aamir");


        when(mockOimClient.getService(UserManager.class)).thenReturn(mockUserManager);
        when(mockUserManager.create(any(User.class))).thenReturn(mockUserManagerResult);
        Users users = new Users(mockOimClient);
        // Execution
        System.out.println("hello dear");
        users.create(userAttributes);
    }
}
