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
        private final JFrame createScreen; // Frame for user creation

        public Dashboard() {
            super("OIM User Management");

            // Create buttons for user choice
            JButton createButton = new JButton("Create User");
            JButton editButton = new JButton("Edit User");

            // Create a panel to hold the choice buttons
            buttonPanel = new JPanel();
            buttonPanel.add(createButton);
            buttonPanel.add(editButton);

            // Add action listeners to handle button clicks
            createButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showCreateScreen(); // Open create user screen
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
            createScreen = new CreateUserScreen().create();
            createScreen.setVisible(false);
        }


        private void showCreateScreen() {
            createScreen.setVisible(true); // Make create user screen visible
        }
        
      

}
