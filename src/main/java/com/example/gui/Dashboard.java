package com.example.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Dashboard extends JFrame{
    
        private final JPanel buttonPanel;
        private JFrame createUserFrame;
        private JFrame passwordResetFrame;
        private JFrame findUsersFrame;

        public Dashboard() {
            super("OIM User Management");

            JButton createButton = new JButton("Create User");
            JButton editButton = new JButton("Edit User");
            JButton passwordResetButton = new JButton("Password Reset");
            JButton findUsersButton = new JButton("Find Users");


            buttonPanel = new JPanel();
            buttonPanel.add(createButton);
            buttonPanel.add(editButton);
            buttonPanel.add(passwordResetButton);
            buttonPanel.add(findUsersButton);


            createButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showCreateScreen();
                }
            });
            
            passwordResetButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showPasswordResetScreen();
                }
            });

            editButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Edit User functionality not yet implemented.");
                }
            });


            findUsersButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showFindUsersScreen();
                }
            });

            getContentPane().add(buttonPanel, BorderLayout.CENTER);

            setPreferredSize(new Dimension(400, 100));
            pack();
            setLocationRelativeTo(null); // Center the button screen
            setVisible(true);
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

        private void showFindUsersScreen() {
            handleDispose(findUsersFrame);

            findUsersFrame = new FindUsersScreen().create();
            findUsersFrame.setVisible(true);
        }
        
        private void handleDispose(JFrame frame) {
            if(frame != null) {
                frame.dispose();
            }
        }
}
