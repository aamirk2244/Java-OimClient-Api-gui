package com.example.gui;

import com.example.Login;
import com.example.UserModifications;
import com.example.Users;
import com.example.gui.components.PopupBox;
import oracle.iam.identity.usermgmt.vo.User;
import oracle.iam.platform.OIMClient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PasswordResetScreen {
    private OIMClient oimClient;

    private JTextField userLogin;
    private JTextField userPassword;
    private JButton submitButton;
    private JLabel userLoginLabel;
    private JLabel userPasswordLabel;
    private JPanel panel;
    private JFrame frame = new JFrame("Password Reset");

    public  JFrame create() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePassword( getUserKeyByUserLogin( userLogin.getText()), userPassword.getText());
            }
        });

        frame.setSize(560, 200);
        frame.setContentPane(panel);

        frame.setLocationRelativeTo(null); // Center the create user screen

        return frame;
    }

    private String getUserKeyByUserLogin(String userLogin) {
        oimClient = Login.crateSession();
        Users users=  new Users(oimClient);
        User oimUser =  users.findByUserLogin(userLogin);
        if(oimUser == null)
            return "";

        return oimUser.getId();
    }

    private void updatePassword(String userKey, String password) {
           if(new UserModifications(Login.crateSession()).passwordReset(userKey, password))
             PopupBox.showSuccessDialog(frame, "Password Updated Successfully");
           else
               PopupBox.showErrorDialog(frame, "Password Reset Error",  "Error while resetting the password, Please check the logs for details");
    }
}
