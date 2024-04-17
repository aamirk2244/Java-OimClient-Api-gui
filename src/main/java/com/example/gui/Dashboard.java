package com.example.gui;

import com.example.Users;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Dashboard extends JFrame{
    
        private final JPanel buttonPanel; // Panel for user choice buttons
        private JFrame createUserFrame; // Frame for user creation
        private JFrame passwordResetFrame; // Frame for user creation
        

        public Dashboard() {
            super("OIM User Management");

            JButton createButton = new JButton("Create User");
            JButton editButton = new JButton("Edit User");
            JButton passwordResetButton = new JButton("Password Reset");

            buttonPanel = new JPanel();
            buttonPanel.add(createButton);
            buttonPanel.add(editButton);
            buttonPanel.add(passwordResetButton);

            // Add action listeners to handle button clicks
            createButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showCreateScreen(); // Open create user screen
                }
            });
            
            passwordResetButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showPasswordResetScreen(); // Open create user screen
                }
            });

            editButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Edit User functionality not yet implemented.");
                }
            });

            // Add button panel to this frame
            getContentPane().add(buttonPanel, BorderLayout.CENTER);

            setPreferredSize(new Dimension(400, 100)); // Set preferred size for button screen
            pack();
            setLocationRelativeTo(null); // Center the button screen
            setVisible(true);

            // Create the screen for user creation (initially hidden)
        }


        private void showCreateScreen() {
            handleDispose(createUserFrame);
            
            createUserFrame = new CreateUserScreen().create();            
            createUserFrame.setVisible(true);
        }
        
        private void showPasswordResetScreen() {
            handleDispose(passwordResetFrame);

            passwordResetFrame = new PasswordResetScreen().create();            
            passwordResetFrame.setVisible(true);
        }
        
        private void handleDispose(JFrame frame) {
            if(frame != null) {
                frame.dispose();
            }
        }
    
      

}
