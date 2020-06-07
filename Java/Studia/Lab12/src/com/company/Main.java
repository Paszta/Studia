package com.company;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private JPanel panel = new JPanel();
    private SpringLayout layout = new SpringLayout();
    JEditorPane edit_pane = new JEditorPane();
    JTextArea area = new JTextArea();
    JButton b1 = new JButton("Klik");
    JTextField field = new JTextField();

    public Main(){
        this.setTitle("Mozzila Inernet FireGoogle ChromeExplorer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,500);

        edit_pane.setPreferredSize(new Dimension(664,270 ));
        area.setPreferredSize(new Dimension(664,50 ));
        field.setPreferredSize(new Dimension(400,20 ));

        panel.setLayout(layout);
        panel.add(edit_pane);
        panel.add(area);
        panel.add(b1);
        panel.add(field);

        layout.putConstraint(SpringLayout.WEST, edit_pane, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, edit_pane, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.EAST, edit_pane, 10, SpringLayout.EAST, panel);

        layout.putConstraint(SpringLayout.WEST, area, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, area, 10, SpringLayout.SOUTH, edit_pane);
        layout.putConstraint(SpringLayout.EAST, area, 10, SpringLayout.EAST, panel);

        layout.putConstraint(SpringLayout.WEST, field, 15, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, field, 10, SpringLayout.SOUTH, area);

        layout.putConstraint(SpringLayout.EAST, b1, 90, SpringLayout.EAST, field);
        layout.putConstraint(SpringLayout.NORTH, b1, 10, SpringLayout.SOUTH, area);


        this.add(panel);
        this.setVisible(true);
        System.out.println(panel.getWidth());
    }


    public static void main(String[] args) {
	Main app = new Main();
    }
}
