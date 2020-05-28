package app;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.FlowLayout;


public class App  extends JFrame{

    private String frame_title;

    public App(String title_name){
        this.frame_title = title_name;
        super.setTitle(title_name);


        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
//1
        JPanel p1 = new JPanel();
        p1.setLayout(new BoxLayout(p1, BoxLayout.PAGE_AXIS));
        JButton button1, button2, button3, button4, button5;
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");

        p1.add(button1);
        p1.add(button2);
        p1.add(button3);
        p1.add(button4);
        p1.add(button5);

        add(p1, BorderLayout.WEST);
        
        p1.setBackground(Color.ORANGE);
        p1.setBorder((javax.swing.BorderFactory.createTitledBorder("Options")));

//2
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(5,2));
        for(int i=0; i < 10; i++){
            if(i%2==0) p2.add(new JLabel("Position "+i, JLabel.RIGHT));
            else p2.add(new JTextField(20));
        }
        add(p2, BorderLayout.EAST);

        p2.setBackground(Color.CYAN);
        p2.setBorder((javax.swing.BorderFactory.createTitledBorder("Form: ")));

//3
        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton ok_button = new JButton("OK");
        p3.add(ok_button);
        p3.setBackground(Color.PINK);
        add(p3, BorderLayout.SOUTH);

//4
        String[] headers = {"Nr", "Name", "Surname"};
        Object[][] data = {{new Integer(1), "Officeto", "Let" }, {new Integer(2), "Luigi", "Faggotenni"}};
        JTable data_table = new JTable(data, headers);
        JScrollPane scroll = new JScrollPane(data_table);
        add(scroll, BorderLayout.CENTER);

//5
        JMenuBar top_menu = new JMenuBar();
        JMenu option_files = new JMenu("Files");
        JMenu option_edit = new JMenu("Edit");
        JMenuItem item1 = new JMenuItem("Item 1");
        JMenuItem item2 = new JMenuItem("Item 2");
        option_files.add(item1);
        option_files.add(item2);

        top_menu.add(option_files);
        top_menu.add(option_edit);

        super.setJMenuBar(top_menu);



        super.pack();
        super.setVisible(true);
   
    }

    public static void main(String[] args) throws Exception {
        App application = new App("Window");
    }
}