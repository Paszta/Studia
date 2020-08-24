package Apaczio;

import com.sun.tools.javac.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlicjaPasztelan
 */
class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    //zintegrowany z naszą aplikacją)
    private String framework = "embedded";
    //Nazwa protokołu komunikacyjnego - różna dla różnych silników baz danych, np. MySQL, czy PostgreSQL
    private String protocol = "jdbc:derby:";
    ArrayList<Statement> statements = new ArrayList<Statement>();
    // lista Statements i PreparedStatements

    //Zmienne reprezentujące wyrażenia - zapytania do bazy danych parametryzowane
    private PreparedStatement psInsert;
    private PreparedStatement psUpdate;
    //zwykłe
    private Statement s;
    //Zbiór rezultatów zapytania
    private ResultSet rs = null;
    private Connection conn = null;

    private Vector<Vector> dane = new Vector();
    private Vector kolumny = new Vector();


    public NewJFrame() throws SQLException {
        initComponents();
        conncetToDb();
    }


    private void conncetToDb() throws SQLException {


        //Deklaracja niezbędnych zmiennych
        //Połączenie do bazy danych (analogia: tory kolejowe do stacji docelowej)
        //Pomocnicza kolekcja na zapytania do bazy danych

        try {
            //Załadowanie i rejestracja w menadżerze sterowników sterownika (klasy tłumaczącej zapytania na
            //wywołania API silnika bazy danych) do DBMS Derby
            Class.forName(driver).getDeclaredConstructor().newInstance();

            Properties props = new Properties(); // właściwości połączenia
            // podawanie użytkownika i hasła jest opcjonalne dla frameworków embedded i derbyclient
            props.put("user", "user1");
            props.put("password", "user1");
            //W bazie danych mogą być schematy - podzbiory bazy danych posiadające własne nazwy i np. różne
            //prawa dostępu
            /* Domyślnie używany jest schemat APP jeśli nie podamy żadnej nazwy użytkownika
             * W innym wypadku zakładany jest schemat odpowiadający nazwie użytkownika (w tym przypadku
             * "user1" lub USER1.)
             *
             * Uwaga. Uwierzytelnianie użytkownika jest domyślnie wyłączone, co oznacza, że do bazy może
             * podłączyć się dowolny użytkownik z dowolnym hasłem.
             */
            String dbName = "Kitki"; // nazwa bazy danych - dowolna
            /*
             * Połączenie zawiera element create=true in the connection URL to
             * spowoduje, że baza danych zostanie utworzona przy pierwszym połączeniu.
             * Żeby usunąc bazę danych należy usunąć katalog derbyDB (nazwa taka jak bazy) i jego zawartość.
             *
             * Katalog odpowiadający nazwie bazy danych derbyDB będzie utworzony jako podkatalog katalogu
             * na który wskazuje zmienna systemowa derby.system.home lub katalogu bieżącego
             * (user.dir) jeśli derby.system.home jest nie ustawiona..
             */
            conn = DriverManager.getConnection(protocol + dbName
                    + ";create=true", props);
            System.out.println("Connected to and created database " + dbName);
            // W bazach danych stosowane są transakcje. Zbiór akcji (dodawania, modyfikacji, usuwania danych),
            //które wykonują się wszystkie lub żadna.
            // Prawidłowo wykonana transakcja kończy się utrwaleniem zmian w bazie danych (commit),
            // a jakikolwiek błąd podczas wykonywania zbioru akcji wycofuje transakcję (rollback). Baza wraca do
            // stanu z przed transakcji. Chcemy zarządzać transakcjami (zapisem) ręcznie - ustawiamy autocommit na
            // "false". Domyślnie autocommit przez sterownik JDBC jest ustawiony na "true".
            conn.setAutoCommit(false);
            s = conn.createStatement();
            try{
                s.execute("create table kitki" + "(" +
                        "imiona varchar(40)," +
                        "karma_w_kg int" +
                        ")");
                conn.commit();
            }
            catch (Exception e){
                System.out.println("tabela już istnieje");
                rs = s.executeQuery("SELECT * from kitki");
                while(rs.next()){
                    Vector temp = new Vector();
                    temp.add(rs.getString(1));
                    temp.add(rs.getInt(2));
                    dane.add(temp);
                }
                conn.commit();
            }


        }
        catch (SQLException sqle)
        {
            // Metoda pomocnicza do wyświetlania błędów
            printSQLException(sqle);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void reportFailure(String message) {
        System.err.println("\nData verification failed:");
        System.err.println('\t' + message);
    }
    /**
     * Drukuje szczegóły łańcucha SQLException <code>System.err</code>.
     * Szczegółami zawartymi są SQL State, Error code i Exception message.
     *
     * @param e wyjątek SQLException z którego drukować szczegóły.
     */
    public static void printSQLException(SQLException e)
    {
        // Rozpakowuje łańcuch wyjątków, w celu określenia rzeczywistego powodu wystąpienia wyjątku.
        while (e != null){
            System.err.println("\n----- SQLException -----");
            System.err.println(" SQL State: " + e.getSQLState());
            System.err.println(" Error Code: " + e.getErrorCode());
            System.err.println(" Message: " + e.getMessage());
            // w celu sprawdzenia stosu, można sprawdzić derby.log albo odkomentować to:
            //e.printStackTrace(System.err);
            e = e.getNextException();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 500));
        setResizable(false);

        jLabel1.setText("Formularz");

        jLabel2.setText("Imię kitka");

        jLabel3.setText("Ilość jedzonej karmy");

        jButton1.setText("Dodaj");


        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel1)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jTextField2))))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(256, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 296, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(51, 51, 51))
        );
        Collections.addAll(kolumny, "Imię", "Karma");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                dane,
                kolumny
        ));
//        jTable1.setModel(new javax.swing.table.DefaultTableModel(
//                new Object [][] {
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null},
//                        {null, null}
//                },
//                new String [] {
//                        "Imię", "Karma"
//                }
//        ));
        jTable1.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.addActionListener(e -> {
            String imie;
            int karma;
            imie = jTextField1.getText();
            karma = Integer.parseInt(jTextField2.getText());
            System.out.println(imie + " " + karma);
            try {
              //  s.execute("INSERT INTO kitki VALUES (" + imie +", " + karma + ")");
                psInsert = conn.prepareStatement("insert into kitki values (?, ?)"); //znaki zapytania to parametry, pod które podstawione zostaną
                psInsert.setString(1, imie);
                psInsert.setInt(2, karma);
                psInsert.executeUpdate();
                Vector temp = new Vector();
                temp.add(imie);
                temp.add(karma);
                dane.add(temp);
                rs = s.executeQuery("SELECT * from kitki");
                while(rs.next()){
                    System.out.println(rs.getString(1) + rs.getInt(2));
                }
                conn.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            DefaultTableModel tableModel = (DefaultTableModel) jTable1.getModel();
            tableModel.fireTableDataChanged();


        });

        pack();
    }// </editor-fold>



    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new NewJFrame().setVisible(true);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration
}
