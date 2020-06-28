package com.company;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Main extends JFrame implements ActionListener {

    JPanel panel = new JPanel();
    SpringLayout layout = new SpringLayout();
    JButton b1 = new JButton("Open");
    JButton b2 = new JButton("Save");
    JEditorPane edit_page = new JEditorPane();
    Border b = new LineBorder(Color.ORANGE, 2);


    public Main(){
        this.setTitle("Input & Output");
        this. setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(layout);

        panel.add(b1);
        panel.add(b2);


        edit_page.setPreferredSize(new Dimension(300, 300));
        edit_page.setEnabled(true);
        edit_page.setEditable(true);
        edit_page.setBorder(b);

        panel.add(edit_page);

        layout.putConstraint(SpringLayout.WEST, edit_page, 90, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, edit_page, 40, SpringLayout.NORTH, this);

        layout.putConstraint(SpringLayout.WEST, b1, 90, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, b1, 40, SpringLayout.SOUTH, edit_page);

        layout.putConstraint(SpringLayout.WEST, b2, 175, SpringLayout.EAST, b1);
        layout.putConstraint(SpringLayout.NORTH, b2, 40, SpringLayout.SOUTH, edit_page);

        b1.addActionListener(this);
        b2.addActionListener(this);

        this.add(panel);
        this.setVisible(true);
    }

    public static void main(String[] args) {
	Main app = new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== b1){
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

                File file = fc.getSelectedFile();
                String path = file.getAbsolutePath();
                String line = "", tekst = "";
                BufferedReader br = null;
                try {
                    br = new BufferedReader(new FileReader(path));
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                }
                while(true){
                    try {
                        if (!((line=br.readLine())!=null)) break;
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    tekst+=line;
                }
                edit_page.setText(tekst);
            }

        }

        if(e.getSource()==b2){
            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(Main.this) == JFileChooser.APPROVE_OPTION) {

                File file = fc.getSelectedFile();
                String path = file.getAbsolutePath();
                BufferedWriter wr = null;
                try {
                    wr = new BufferedWriter(new FileWriter(path));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    wr.write(edit_page.getText());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                try {
                    wr.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }
}
