import keeptoo.KGradientPanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;

public class NieuwApparaat extends JFrame {

    public JButton logOut = new JButton("<html><U>Uitloggen</U></html>");

    public JButton home = new JButton("Home");

    public JButton apparaten = new JButton("Apparaten");

    public JButton ofVoegToe = new JButton();

    public Consumer<Integer> callback;

    private void ButtonPressed(ActionEvent e){
        if (e.getSource() == logOut) callback.accept(1);
        if (e.getSource() == home) callback.accept(2);
        if (e.getSource() == apparaten) callback.accept(3);
    }

    public NieuwApparaat(){

        //Resolutie gebruiker zoeken
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenSize.width = (int) (screenSize.width*3)/4;
        screenSize.height = (int) (screenSize.height*3)/4;



        KGradientPanel bg = new KGradientPanel();
        bg.setStartColor(new Color(252, 92, 125));
        bg.setEndColor(new Color(106, 130, 251));
        bg.setGradientFocus(1500);

        JPanel navbar = new JPanel();
        navbar.setBackground(new Color(255,255,255));
        navbar.setBounds(0,0,screenSize.width,screenSize.height/15);

        KGradientPanel buttonGradient = new KGradientPanel();
        buttonGradient.setStartColor(new Color(252, 92, 125));
        buttonGradient.setEndColor(new Color(106, 130, 251));
        buttonGradient.setGradientFocus(200);
        buttonGradient.setSize(screenSize.width/4, screenSize.height/20);

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

        ofVoegToe.setFont(new Font("Segoe UI", 1, screenSize.width/85));
        ofVoegToe.setText("Voeg toe ");
        ofVoegToe.setOpaque(false);
        ofVoegToe.setContentAreaFilled(false);
        ofVoegToe.setBorderPainted(false);
        ofVoegToe.setSize(buttonGradient.getWidth(), buttonGradient.getHeight());
        ofVoegToe.setForeground(new Color(179,179,179));
        ofVoegToe.addActionListener(this::ButtonPressed);
        buttonGradient.add(ofVoegToe);


        JPanel panel = new JPanel();
        panel.setBackground(new Color(255,255,255));
        panel.setBounds(screenSize.width/15, screenSize.height/7, screenSize.width*10/12, screenSize.height*10/14);


        JLabel apparatenLbl = new JLabel();
        apparatenLbl.setFont(new Font("Segoe UI",1,screenSize.width/80));
        apparatenLbl.setForeground(new Color(0,0,0));
        apparatenLbl.setText("| Apparaten");

        JLabel NieuwApparaatLogin = new JLabel();
        NieuwApparaatLogin.setFont(new Font("Segoe UI", 1, screenSize.width/80));
        NieuwApparaatLogin.setForeground(new Color(102, 102, 102));
        NieuwApparaatLogin.setText("Voeg uw apparaat toe ");

        JLabel NieuwApparaatLoginApparaatnaam = new JLabel();
        NieuwApparaatLoginApparaatnaam.setFont(new Font("Segoe UI", 0, screenSize.width/96));
        NieuwApparaatLoginApparaatnaam.setForeground(new Color(102,102,102));
        NieuwApparaatLoginApparaatnaam.setText("Apparaatnaam");

        JTextField NieuwApparaatLoginApparaatnaamTxt = new JTextField();
        NieuwApparaatLoginApparaatnaamTxt.setFont(new Font("Segoe UI",0,screenSize.width/103));
        NieuwApparaatLoginApparaatnaamTxt.setForeground(new Color(102,102,102));
        NieuwApparaatLoginApparaatnaamTxt.setBackground(new Color(255,255,255));
        NieuwApparaatLoginApparaatnaamTxt.setBorder(BorderFactory.createMatteBorder(0, 0, screenSize.width/720, 0, new Color(12, 91, 160)));

        JLabel NieuwApparaatLoginSerienummer = new JLabel();
        NieuwApparaatLoginSerienummer.setFont(new Font("Segoe UI", 0, screenSize.width/96));
        NieuwApparaatLoginSerienummer.setForeground(new Color(102,102,102));
        NieuwApparaatLoginSerienummer.setText("Serienummer");

        JTextField NieuwApparaatLoginSerienummerTxt = new JTextField();
        NieuwApparaatLoginSerienummerTxt.setFont(new Font("Segoe UI",0,screenSize.width/103));
        NieuwApparaatLoginSerienummerTxt.setForeground(new Color(102,102,102));
        NieuwApparaatLoginSerienummerTxt.setBackground(new Color(255,255,255));
        NieuwApparaatLoginSerienummerTxt.setBorder(BorderFactory.createMatteBorder(0, 0, screenSize.width/720, 0, new Color(12, 91, 160)));


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
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(NieuwApparaatLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(NieuwApparaatLoginApparaatnaam)
                                                .addComponent(NieuwApparaatLoginApparaatnaamTxt)
                                                .addComponent(NieuwApparaatLoginSerienummer)
                                                .addComponent(NieuwApparaatLoginSerienummerTxt)
                                                .addComponent(buttonGradient, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                                                .addComponent(ofVoegToe, GroupLayout.Alignment.CENTER,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE)
                                        )
                        )
        )
        );

        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(screenSize.height/25)
                                .addComponent(NieuwApparaatLogin)
                                .addGap(screenSize.height/44)
                                .addComponent(NieuwApparaatLoginApparaatnaam)
                                .addGap(screenSize.height/116)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NieuwApparaatLoginApparaatnaamTxt, GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                .addGap(screenSize.height/44)
                                .addComponent(NieuwApparaatLoginSerienummer)
                                .addGap(screenSize.height/116)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NieuwApparaatLoginSerienummerTxt,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                .addGap(screenSize.height/29)
                                .addComponent(buttonGradient, GroupLayout.PREFERRED_SIZE,screenSize.width/33,GroupLayout.PREFERRED_SIZE)
                                .addGap(screenSize.height/900)
                                .addComponent(ofVoegToe)
                                .addGap(screenSize.height/29)
                        )
        );


        //Opstellen van scherm
        setTitle("CarbonTec Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(screenSize.width, screenSize.height);
        setContentPane(bg);
        getRootPane().setDefaultButton(ofVoegToe);

        //Toevoegen image
        ImageIcon imageIcon = new ImageIcon("Icon.png");
        setIconImage(imageIcon.getImage());

        //Toevoegen objects
        bg.add(navbar);
        bg.add(panel);
    }

    private static class RoundedBorder implements Border {

        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }
        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x,y,width-1,height-1,radius,radius);

        }

    }


}
