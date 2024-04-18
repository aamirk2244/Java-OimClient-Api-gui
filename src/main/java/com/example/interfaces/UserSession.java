package com.example.interfaces;

import javax.security.auth.login.LoginException;

import oracle.iam.platform.OIMClient;

public interface UserSession {
    OIMClient getSession();
    void destroySession();
}
