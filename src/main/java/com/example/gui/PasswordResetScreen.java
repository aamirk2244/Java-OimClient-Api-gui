package com.example.gui;

import com.example.Login;
import com.example.UserModifications;

import com.example.gui.components.PopupBox;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PasswordResetScreen {

    // Create input fields
    JTextField userKey = new JTextField(10);
    JTextField userPassword = new JTextField(10);
    JFrame frame;

        public JFrame create() {
            frame = new JFrame("Password Reset");

            // Create labels for the fields
            JLabel userKeyLabel = new JLabel("User Key:");
            JLabel passwordLabel = new JLabel("New Password:");

            // Create a panel to hold the labels and fields
            JPanel inputPanel = new JPanel();
            inputPanel.add(userKeyLabel);
            inputPanel.add(userKey);
            inputPanel.add(passwordLabel);
            inputPanel.add(userPassword);
            
            inputPanel.setPreferredSize(new Dimension(300, 200));

            userKey.setPreferredSize(new Dimension(100, 20));
            userPassword.setPreferredSize(new Dimension(150, 20));
            
            // Add a button to submit the form (can be extended later)
            JButton submitButton = new JButton("Submit");
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Handle form submission (e.g., collect data and create user)            
                    updatePassword(userKey.getText(), userPassword.getText());
                }
            });

            // Add input panel and submit button to the frame
            frame.setSize(560, 200);      

            frame.getContentPane().add(inputPanel, BorderLayout.CENTER);
            frame.getContentPane().add(submitButton, BorderLayout.SOUTH);

        //        frame.setPreferredSize(new Dimension(400, 300)); // Size for create user screen
            frame.setLocationRelativeTo(null); // Center the create user screen

            return frame;
        }
        
        private void updatePassword(String userKey, String password) {
            try {
            new UserModifications(new Login().getSession()).passwordReset(userKey, password);
            PopupBox.showSuccessDialog(frame, "Password Updated Successfully");

            }catch (Exception e) {
                PopupBox.showErrorDialog(frame, "Password Reset Error",  e.getMessage());

            }

        }
}
