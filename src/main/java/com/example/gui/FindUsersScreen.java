package com.example.gui;

import com.example.Login;
import com.example.Users;
import oracle.iam.identity.usermgmt.vo.User;

import javax.security.auth.login.LoginException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;

public class FindUsersScreen {
    private JTextField columnNameTextField;
    private JTextField queryTextField;
    private JButton searchButton;
    private JLabel columnLabel;
    private JLabel queryLabel;
    private JTextArea resultTextArea;
    private JPanel panel;
    private JFrame frame = new JFrame("Find Users");


    public JFrame create() {
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findUsers(columnNameTextField.getText(), queryTextField.getText());
            }
        });

        frame.setSize(860, 600);
        frame.setContentPane(panel);

        frame.setLocationRelativeTo(null); // Center the create user screen

        return frame;

    }

    private void findUsers(String column, String query) {
        try {
            Users user = new Users(new Login().getSession());
            Optional<List<User>>  users = user.findBy(column, query);

            if(users.isPresent()) {
                System.out.println(users);
                resultTextArea.setText(users.toString());
                return;
            }
            resultTextArea.setText("No User Found");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
