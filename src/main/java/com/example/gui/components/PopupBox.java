package com.example.gui.components;

import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopupBox {
//    public static void showPopup(String message) {
//        JFrame popup = new JFrame();
//        popup.setTitle("User Creation");
//
//        JLabel messageLabel = new JLabel(message);
//        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
//
//        popup.getContentPane().add(messageLabel);
//
//        popup.setSize(300, 100);
//        // Center the popup on the screen
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int x = (screenSize.width - popup.getWidth()) / 2;
//        int y = (screenSize.height - popup.getHeight()) / 2;
//        popup.setLocation(x, y);
//
//        popup.setVisible(true);
//    }
    
    
    public static void showSuccessDialog(final JFrame frame, String message) {
           JOptionPane.showMessageDialog(frame, message, "Success", JOptionPane.INFORMATION_MESSAGE);
       }

       public static void showErrorDialog(final JFrame frame, String heading, String message) {
           JOptionPane.showMessageDialog(frame, message, heading, JOptionPane.ERROR_MESSAGE);
       }
}



