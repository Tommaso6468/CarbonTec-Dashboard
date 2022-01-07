import keeptoo.KGradientPanel;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.function.Consumer;

public class NieuwApparaat extends JFrame {

    public JButton logOut = new JButton("<html><U>Uitloggen</U></html>");

    public JButton home = new JButton("Home");

    public JButton apparaten = new JButton("Apparaten");

    public JButton terug = new JButton("<html><U>Terug</U></html>");

    public JButton toevoegen = new JButton("Toevoegen");

    public JTextField serienummerTxt = new JTextField();
    public JTextField apparaatnaamTxt = new JTextField();

    public Consumer<Integer> callback;

    private void ButtonPressed(ActionEvent e){
        if (e.getSource() == logOut) callback.accept(1);
        if (e.getSource() == home) callback.accept(2);
        if (e.getSource() == apparaten) callback.accept(3);
        if (e.getSource() == terug) callback.accept(3);
        if (e.getSource() == toevoegen){
            //Apparaat toevoegen logic
            if (serienummerTxt.getDocument().getLength() < 5) return;
            if (apparaatnaamTxt.getDocument().getLength() < 1) return;
            int serienummerInt = Integer.parseInt(serienummerTxt.getText());
            int length = String.valueOf(serienummerInt).length();
            if (length != 5) return;
            String ID = serienummerTxt.getText();
            String naam = apparaatnaamTxt.getText();
            String path = "apparaten.csv";

            try {
                FileWriter fw = new FileWriter(path,true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);

                pw.println(ID+","+naam+",bekijk");
                pw.flush();
                pw.close();
            }
            catch (Exception E){

            }

            callback.accept(3);
        }
    }




    public NieuwApparaat(){

        //Resolutie gebruiker zoeken
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenSize.width = (int) (screenSize.width*3)/4;
        screenSize.height = (int) (screenSize.height*3)/4;


        // achtergrond staat hier
        KGradientPanel bg = new KGradientPanel();
        bg.setStartColor(new Color(252, 92, 125));
        bg.setEndColor(new Color(106, 130, 251));
        bg.setGradientFocus(1500);

        // dit is de navigation bar boven
        JPanel navbar = new JPanel();
        navbar.setBackground(new Color(255,255,255));
        navbar.setBounds(0,0,screenSize.width,screenSize.height/15);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255,255,255));
        panel.setBounds(screenSize.width*10/29, screenSize.height/7, (screenSize.width*10)/31, (screenSize.height*10)/14);


        JLabel apparatenLbl = new JLabel();
        apparatenLbl.setFont(new Font("Segoe UI",1,screenSize.width/80));
        apparatenLbl.setForeground(new Color(0,0,0));
        apparatenLbl.setText("| Apparaat toevoegen");


        JLabel serienummerLbl = new JLabel();
        serienummerLbl.setFont(new Font("Segoe UI", 0, screenSize.width/96));
        serienummerLbl.setForeground(new Color(102, 102, 102));
        serienummerLbl.setText("Serie-nummer");

        JLabel apparaatnaamLbl = new JLabel();
        apparaatnaamLbl.setFont(new Font("Segoe UI", 0, screenSize.width/96));
        apparaatnaamLbl.setForeground(new Color(102, 102, 102));
        apparaatnaamLbl.setText("Apparaatnaam (max. 45 karakters)");


        serienummerTxt.setFont(new Font("Segoe UI", 0, screenSize.width/103));
        serienummerTxt.setForeground(new Color(102, 102, 102));
        serienummerTxt.setBackground(new Color(255,255,255));
        serienummerTxt.setBorder(BorderFactory.createMatteBorder(0, 0, screenSize.width/720, 0, new Color(12, 91, 160)));
        serienummerTxt.setDocument(new JTextFieldLimit(5));


        apparaatnaamTxt.setFont(new Font("Segoe UI", 0, screenSize.width/103));
        apparaatnaamTxt.setForeground(new Color(102, 102, 102));
        apparaatnaamTxt.setBackground(new Color(255,255,255));
        apparaatnaamTxt.setBorder(BorderFactory.createMatteBorder(0, 0, screenSize.width/720, 0, new Color(12, 91, 160)));
        apparaatnaamTxt.setDocument(new JTextFieldLimit(45));


        terug.setFont(new Font("Segoe UI", 0, screenSize.width/96));
        terug.setForeground(new Color(102,102,102));
        terug.setOpaque(false);
        terug.setBorderPainted(false);
        terug.setContentAreaFilled(false);
        terug.addActionListener(this::ButtonPressed);


        KGradientPanel buttonGradient = new KGradientPanel();
        buttonGradient.setStartColor(new Color(252, 92, 125));
        buttonGradient.setEndColor(new Color(106, 130, 251));
        buttonGradient.setGradientFocus(200);
        buttonGradient.setSize(screenSize.width/4, screenSize.height/20);

        toevoegen.setFont(new Font("Segoe UI", 1, screenSize.width/85));
        toevoegen.setOpaque(false);
        toevoegen.setContentAreaFilled(false);
        toevoegen.setBorderPainted(false);
        toevoegen.setSize(buttonGradient.getWidth()*100/96, buttonGradient.getHeight());
        toevoegen.setForeground(new Color(255,255,255));
        toevoegen.addActionListener(this::ButtonPressed);
        buttonGradient.add(toevoegen);

        logOut.setFont(new Font("Segoe UI", 0,screenSize.width/96));
        logOut.setForeground(new Color(102, 102, 102));
        logOut.setOpaque(false);
        logOut.setBorderPainted(false);
        logOut.setContentAreaFilled(false);
        logOut.addActionListener(this::ButtonPressed);


        home.setFont(new Font("Segoe UI",1,screenSize.width/80));
        home.setForeground(new Color(0,0,0));
        home.setOpaque(false);
        home.setBorderPainted(false);
        home.setContentAreaFilled(false);
        home.addActionListener(this::ButtonPressed);
        home.setBorder(BorderFactory.createEmptyBorder());

        apparaten.setFont(new Font("Segoe UI",1,screenSize.width/80));
        apparaten.setForeground(new Color(0,0,0));
        apparaten.setOpaque(false);
        apparaten.setContentAreaFilled(false);
        apparaten.addActionListener(this::ButtonPressed);
        apparaten.setBorder(BorderFactory.createMatteBorder(0, 0, screenSize.width/720, 0, new Color(12, 91, 160)));


        GroupLayout navbarLayout = new GroupLayout(navbar);
        navbar.setLayout(navbarLayout);
        navbarLayout.setHorizontalGroup(
                navbarLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(navbarLayout.createSequentialGroup()
                                .addGap((screenSize.width*20)/46)
                                .addComponent(home)
                                .addGap(screenSize.width/20)
                                .addComponent(apparaten)
                                .addGap((screenSize.width*10)/30)
                                .addComponent(logOut)

                        )
        );

        navbarLayout.setVerticalGroup(
                navbarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(navbarLayout.createSequentialGroup()
                                .addGap(screenSize.height/50)
                                .addGroup(navbarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(navbarLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(home)
                                                .addComponent(apparaten)
                                                .addComponent(logOut)
                                        )
                                )
                        )
        );


        GroupLayout panelLayout = new GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(panelLayout.createSequentialGroup()
                        .addGap(screenSize.width/35)
                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING,false)
                                .addComponent(apparatenLbl)
                                .addGap(screenSize.width*10/38)
                                .addComponent(apparaatnaamLbl, screenSize.width/4, screenSize.width/4, screenSize.width/4)
                                .addComponent(apparaatnaamTxt)
                                .addComponent(serienummerLbl)
                                .addComponent(serienummerTxt)
                                .addComponent(buttonGradient, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                                .addComponent(terug)
                        )
                )
        );

        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(screenSize.height/25)
                                .addComponent(apparatenLbl)
                                .addGap(screenSize.width/20)
                                .addComponent(apparaatnaamLbl)
                                .addGap(screenSize.width/80)
                                .addComponent(apparaatnaamTxt)
                                .addGap(screenSize.width/20)
                                .addComponent(serienummerLbl)
                                .addGap(screenSize.width/80)
                                .addComponent(serienummerTxt)
                                .addGap(screenSize.width/12)
                                .addComponent(buttonGradient, GroupLayout.PREFERRED_SIZE,screenSize.width/33,GroupLayout.PREFERRED_SIZE)
                                .addGap(screenSize.width/288)
                                .addComponent(terug)
                                .addGap(screenSize.width/30)
                        )
        );



        //Opstellen van scherm
        setTitle("CarbonTec Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(screenSize.width, screenSize.height);
        setContentPane(bg);

        //Toevoegen image
        ImageIcon imageIcon = new ImageIcon("Icon.png");
        setIconImage(imageIcon.getImage());

        //Toevoegen objects
        bg.add(navbar);
        bg.add(panel);


    }

}

class JTextFieldLimit extends PlainDocument {
    private int limit;

    JTextFieldLimit(int limit) {
        super();
        this.limit = limit;
    }

    public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
        if (str == null) return;

        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
    }
}
