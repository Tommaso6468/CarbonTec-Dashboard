import keeptoo.KGradientPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;

public class LosApparaat extends JFrame {

    public JButton logOut = new JButton("<html><U>Uitloggen</U></html>");

    public JButton home = new JButton("Home");

    public JButton apparaten = new JButton("Apparaten");

    public Consumer<Integer> callback;

    private void ButtonPressed(ActionEvent e){
        if (e.getSource() == logOut) callback.accept(1);
        if (e.getSource() == home) callback.accept(2);
        if (e.getSource() == apparaten) callback.accept(3);
    }

    public LosApparaat(){

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

        // witte achtergrond van alles
        JPanel losApparaatBg = new JPanel();
        losApparaatBg.setBackground(new Color(255, 255, 255));
        losApparaatBg.setBounds(screenSize.width*2/17, screenSize.height/8, screenSize.width*3/4, screenSize.height*3/4);


        JLabel apparaatNaam = new JLabel();
        apparaatNaam.setForeground(new Color(0,0,0));
        apparaatNaam.setBackground(new Color(0,0,255));
        apparaatNaam.setFont(new Font("Segoe UI", 1, screenSize.width/60));
        apparaatNaam.setText("Lokaal 101");

        JLabel Rating = new JLabel();
        Rating.setForeground(new Color(0,255,0));
        Rating.setFont(new Font("Segoe UI", 1, screenSize.width/60));
        Rating.setText("Gezond!");

        JLabel GeschDag = new JLabel();
        GeschDag.setForeground(new Color(150,100,255));
        GeschDag.setFont(new Font("Segoe UI", 1, screenSize.width/40));
        GeschDag.setText("Geschiedenis afgelopen 24 uur");

        JLabel CO2PPM = new JLabel();
        CO2PPM.setForeground(new Color(0,0,0));
        CO2PPM.setFont(new Font("Segoe UI", 1, screenSize.width/60));
        CO2PPM.setText("850 PPM");







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

        GroupLayout losApparaatLayout = new GroupLayout(losApparaatBg);
        losApparaatBg.setLayout(losApparaatLayout);

        losApparaatLayout.setHorizontalGroup(

                losApparaatLayout.createParallelGroup(GroupLayout.Alignment.LEADING)

                        .addGroup(losApparaatLayout.createSequentialGroup()
                                .addGap(screenSize.width/20)
                                .addGroup(losApparaatLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(apparaatNaam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Rating, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CO2PPM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)

                                )


                        ).addGroup(losApparaatLayout.createSequentialGroup()
                                .addGap(screenSize.width/5)
                                .addGroup(losApparaatLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(GeschDag, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        )



        );

        losApparaatLayout.setVerticalGroup(
                losApparaatLayout.createParallelGroup(GroupLayout.Alignment.LEADING)


                        .addGroup(losApparaatLayout.createSequentialGroup()

                                .addGap(50)
                                .addComponent(apparaatNaam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(70)
                                .addComponent(CO2PPM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(5)
                                .addComponent(Rating, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)


                        )

                        .addGroup(losApparaatLayout.createSequentialGroup()
                                .addGap(5)
                                .addComponent(GeschDag, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)

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
        bg.add(losApparaatBg);


    }


}
