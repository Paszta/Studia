package app;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SpringLayout;

import java.awt.*;


public class App extends JFrame {

    
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("App 1");
        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");
        JButton button4 = new JButton("Button 4");
        JButton button5 = new JButton("Button 5");
        frame.setSize(300,300);
        Container contentPane =  frame.getContentPane();


        //contentPane.setLayout(new FlowLayout());
        
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        //frame.add(button5);
        SpringLayout layout = new SpringLayout();  
        contentPane.setLayout(layout);

        layout.putConstraint(SpringLayout.WEST, button1, 5,SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.WEST, button1, 5,SpringLayout.EAST, button2);
        layout.putConstraint(SpringLayout.WEST, button2, 5,SpringLayout.EAST, button3);
        layout.putConstraint(SpringLayout.WEST, button3, 5,SpringLayout.EAST, button4);

        frame.setVisible(true);
    }
}