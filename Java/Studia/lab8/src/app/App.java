package app;

import java.awt.Color;
import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import java.awt.Dimension;
import java.awt.event.*;

public class App extends JFrame implements ActionListener {

    public App(){
        super.setTitle("Okineko");
        Container contain = super.getContentPane();

        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contain.setBackground(Color.ORANGE);
       
        super.setSize(300, 300);

        SpringLayout layout = new SpringLayout();
        contain.setLayout(layout);

        JTextField txt = new JTextField(20);
        contain.add(txt);

        layout.putConstraint(SpringLayout.WEST, txt, 40, SpringLayout.WEST, contain);
        layout.putConstraint(SpringLayout.NORTH, txt, 10, SpringLayout.NORTH, contain);

        JPanel panel1 = new JPanel();
        contain.add(panel1);
        BoxLayout box =  new BoxLayout(panel1, BoxLayout.X_AXIS);
        panel1.setPreferredSize(new Dimension(280,30));

        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");

        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);

        layout.putConstraint(SpringLayout.SOUTH, panel1, 40, SpringLayout.SOUTH, txt);
        layout.putConstraint(SpringLayout.WEST, panel1, 0, SpringLayout.WEST, contain);
        layout.putConstraint(SpringLayout.EAST, panel1, 0, SpringLayout.EAST, contain);


        String table[] = {"1", "2", "3"};
        JComboBox list = new JComboBox<>(table);
        JLabel label = new JLabel("Combobombo box");
        contain.add(list);
        contain.add(label);
        
        layout.putConstraint(SpringLayout.WEST, list, 20, SpringLayout.WEST, contain);
        layout.putConstraint(SpringLayout.NORTH, list, 75, SpringLayout.NORTH, contain);


        layout.putConstraint(SpringLayout.NORTH, label, 75, SpringLayout.NORTH, contain);
        layout.putConstraint(SpringLayout.WEST, label, 20, SpringLayout.EAST, list);


        button1.addActionListener(this);
        button2.addActionListener(new ActionListener (){

            @Override
            public void actionPerformed(ActionEvent e) {
                JButton buton = null;
                if(e.getSource() instanceof JButton) buton = (JButton) e.getSource();
                if(buton != null) System.out.println("Clicked " + buton.getText());
            }
            

        });

        button3.addActionListener((ActionEvent e)-> {
            JButton buton = null;
            if(e.getSource() instanceof JButton) buton = (JButton) e.getSource();
            if(buton != null) System.out.println("Clicked " + buton.getText());
        });

     Adapter a = new Adapter();
     this.addWindowListener(a);

     Item item = new Item(label, list);
    list.addItemListener(item);

        super.setVisible(true);
    }


        
    class Item implements ItemListener{
        private JLabel lab = new JLabel();
        private JComboBox cb = new JComboBox<>();

        public Item(JLabel lab, JComboBox cb) {
            this.lab = lab;
            this.cb = cb;
        }

		@Override
		public void itemStateChanged(ItemEvent ie) {
        
            String getItem = (String)cb.getSelectedItem();

            if(getItem.equals("1")) lab.setText("Position 1");
            else if(getItem.equals("2")) lab.setText("Position 2");
            else if(getItem.equals("3")) lab.setText("Position 3");
		}
        
    }

    class Adapter extends WindowAdapter{
        @Override
        public void windowOpened(WindowEvent e) {
            JOptionPane.showMessageDialog(e.getWindow(), "" , "Super okno", JOptionPane.PLAIN_MESSAGE);
            super.windowOpened(e);
        }

        @Override
        public void windowClosed(WindowEvent e){
            System.exit(0);
        }
    }

    public static void main(String[] args) throws Exception {
        App application = new App();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buton = null;
        if(e.getSource() instanceof JButton) buton = (JButton) e.getSource();
        if(buton != null) System.out.println("Clicked " + buton.getText());

    }

}