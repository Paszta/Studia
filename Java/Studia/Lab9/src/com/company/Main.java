package com.company;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener, ItemListener, ChangeListener {


    //Declaration
    private JLabel name_l = new JLabel("Name: ");
    private JLabel gender_l = new JLabel("Gender: ");
    private JLabel age_l = new JLabel("Age: ");
    private JLabel surname_l = new JLabel("Surname: ");

    private JLabel pets_l = new JLabel("Choose pets which you have at home: ");

    private JTextField name_tf = new JTextField(30);
    private JTextField surname_tf = new JTextField(30);

    private JRadioButton  female_button = new JRadioButton("Female");
    private JRadioButton male_button = new JRadioButton("Male");
    private ButtonGroup buttongroup = new ButtonGroup();


    private JSpinner age_s = new JSpinner();

    private DefaultListModel<String> home_pets = new DefaultListModel<>();
    private JList<String> pets_list = new JList<String>(home_pets);
    JScrollPane scroll_pane;
    JScrollBar scroll_bar = new JScrollBar();


    private JButton confirm = new JButton("Confirm");
    private JButton cancel = new JButton("Cancel");

    private JPanel survey_p = new JPanel();
    private JLabel survey_l = new JLabel("Do you want to participate in the survey?");

//Constructor
    public Main(){
        super.setTitle("Ankieta");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(440,400);

        SpringLayout layout = new SpringLayout();
        super.setLayout(layout);

        buttongroup.add(female_button);
        buttongroup.add(male_button);
        female_button.setEnabled(false);
        male_button.setEnabled(false);

        age_s.setEnabled(false);


        home_pets.addElement("Dog");
        home_pets.addElement("Cat");
        home_pets.addElement("Hamster");
        home_pets.addElement("Bunny");
        home_pets.addElement("Spider");
        home_pets.addElement("Fish");
        home_pets.addElement("Insects");

        pets_list.setLayoutOrientation(JList.VERTICAL_WRAP);
        pets_list.setVisibleRowCount(5);
        pets_list.setEnabled(false);
        scroll_pane = new JScrollPane(pets_list);
        scroll_bar = scroll_pane.getVerticalScrollBar();
        scroll_pane.setPreferredSize(new Dimension(120,80));
        scroll_pane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll_pane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);



//Adding to frame
        super.add(name_l);
        super.add(surname_l);
        super.add(gender_l);
        super.add(age_l);
        super.add(pets_l);

        super.add(name_tf);
        super.add(surname_tf);

        super.add(female_button);
        super.add(male_button);

        super.add(age_s);

        //super.add(pets_list);
        this.getContentPane().add(scroll_pane);

        super.add(confirm);
        super.add(cancel);

        confirm.setBackground(Color.orange);
        cancel.setBackground(Color.orange);


//Positioning

        layout.putConstraint(SpringLayout.WEST, name_l, 1 , SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.NORTH, name_l, 10 , SpringLayout.NORTH, this);

        layout.putConstraint(SpringLayout.WEST, surname_l, 1 , SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.NORTH, surname_l, 6 , SpringLayout.SOUTH, name_l);

        layout.putConstraint(SpringLayout.WEST, gender_l, 1 , SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.NORTH,gender_l, 25 , SpringLayout.SOUTH, surname_l);

        layout.putConstraint(SpringLayout.WEST, age_l, 1 , SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.NORTH,age_l, 20 , SpringLayout.SOUTH, gender_l);

        layout.putConstraint(SpringLayout.WEST, pets_l, 1 , SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.NORTH,pets_l, 20 , SpringLayout.SOUTH, age_l);


        layout.putConstraint(SpringLayout.WEST, name_tf, 25 , SpringLayout.EAST, name_l);
        layout.putConstraint(SpringLayout.NORTH, name_tf, 10 , SpringLayout.NORTH, this);

        layout.putConstraint(SpringLayout.WEST, surname_tf, 8 , SpringLayout.EAST, surname_l);
        layout.putConstraint(SpringLayout.NORTH, surname_tf, 4 , SpringLayout.SOUTH, name_tf);



        layout.putConstraint(SpringLayout.WEST, female_button, 15 , SpringLayout.EAST, gender_l);
        layout.putConstraint(SpringLayout.NORTH,female_button, 14 , SpringLayout.SOUTH, surname_tf);

        layout.putConstraint(SpringLayout.WEST, male_button, 10 , SpringLayout.EAST, female_button);
        layout.putConstraint(SpringLayout.NORTH,male_button, 14 , SpringLayout.SOUTH, surname_tf);


        layout.putConstraint(SpringLayout.WEST, age_s, 15 , SpringLayout.EAST, age_l);
        layout.putConstraint(SpringLayout.NORTH,age_s, 14 , SpringLayout.SOUTH, female_button);


      //  layout.putConstraint(SpringLayout.WEST, pets_list, 1 , SpringLayout.EAST, this);
      //  layout.putConstraint(SpringLayout.NORTH,pets_list, 14 , SpringLayout.SOUTH, pets_l);

        layout.putConstraint(SpringLayout.WEST, scroll_pane, 1 , SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.NORTH,scroll_pane, 14 , SpringLayout.SOUTH, pets_l);

        layout.putConstraint(SpringLayout.WEST, confirm, 40 , SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.NORTH,confirm, 35 , SpringLayout.SOUTH, scroll_pane);

        layout.putConstraint(SpringLayout.WEST, cancel, 20 , SpringLayout.EAST, confirm);
        layout.putConstraint(SpringLayout.NORTH,cancel, 35 , SpringLayout.SOUTH, scroll_pane);

//Adding listeners
        surname_tf.addActionListener(this);
        name_tf.addActionListener(this);
        female_button.addItemListener(this);
        male_button.addItemListener(this);
        age_s.addChangeListener(this);


        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer ageValue = (Integer)age_s.getValue();

                JRadioButton selected_rb = null;
                if (female_button.isSelected()) {
                   selected_rb = female_button;
                }
                else if (male_button.isSelected()) {
                    selected_rb = male_button;
                }

                String pet = (String) pets_list.getSelectedValue();

                JOptionPane.showMessageDialog(confirm, "Name: " + name_tf.getText() + "\n" + "Surname: " + surname_tf.getText() +"\n"+"Age: " + ageValue + "\n" + "Gender: " + selected_rb.getText() +"\n"+ "Pet at home: " + pet + "\n" );
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(cancel, "Action canceled");
                System.exit(0);
            }
        });


            survey_p.setSize(new Dimension(200,200));
            survey_p.add(survey_l);
            int option = JOptionPane.showConfirmDialog(null, survey_p, "Survey", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if(option == 0){
                super.setVisible(true);
            }
            else{
                System.exit(0);
            }
// Mouse adapter class
        class Adapter extends MouseAdapter {
              private JButton button;

            public Adapter(JButton button) {
                this.button = button;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                button.setBackground(Color.pink);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                button.setBackground(Color.orange);

            }
        }

            Adapter adapt_conf = new Adapter(confirm);
            Adapter adapt_canc = new Adapter(cancel);
            confirm.addMouseListener(adapt_conf);
            cancel.addMouseListener(adapt_canc);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
    if(!surname_tf.getText().isEmpty() && !name_tf.getText().isEmpty()) {
        female_button.setEnabled(true);
        male_button.setEnabled(true);
        }
    else
        JOptionPane.showMessageDialog(this, "Invalid data");

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED){
            age_s.setEnabled(true);
        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSpinner spin = (JSpinner)e.getSource();
        int value = (int)spin.getValue();
    if(value > 0 ){
        pets_list.setEnabled(true);
    }
    }


    public static void main(String[] args) {
        Main app = new Main();

    }

}
