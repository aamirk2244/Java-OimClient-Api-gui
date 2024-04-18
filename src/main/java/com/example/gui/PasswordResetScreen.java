package com.example.gui;

import com.example.Login;
import com.example.UserModifications;
import com.example.gui.components.PopupBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordResetScreen {
    private JTextField userKey;
    private JTextField userPassword;
    private JButton submitButton;
    private JLabel userKeyLabel;
    private JLabel userPasswordLabel;
    private JPanel panel;
    private JFrame frame = new JFrame("Password Reset");

    public  JFrame create() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePassword( userKey.getText(), userPassword.getText());
            }
        });

        frame.setSize(560, 200);
        frame.setContentPane(panel);

        frame.setLocationRelativeTo(null); // Center the create user screen
              
        return frame;
    }

    private void updatePassword(String userKey, String password) {
        try {
           if(new UserModifications(new Login().getSession()).passwordReset(userKey, password))
             PopupBox.showSuccessDialog(frame, "Password Updated Successfully");
           else
               PopupBox.showErrorDialog(frame, "Password Reset Error",  "Error while resetting the password, Please check the logs for details");

        }catch (Exception e) {
            PopupBox.showErrorDialog(frame, "Error",  e.getMessage());
        }

    }
}
