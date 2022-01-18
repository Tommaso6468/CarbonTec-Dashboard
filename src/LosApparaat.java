import keeptoo.KGradientPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.function.Consumer;



public class LosApparaat extends JFrame {

    public JButton logOut = new JButton("<html><U>Uitloggen</U></html>");

    public JButton home = new JButton("Home");

    public JButton apparaten = new JButton("Apparaten");

    public Consumer<Integer> callback;

    public String sterLeeg = String.valueOf("\u2606");
    public String sterVol = String.valueOf("\u2605");
    public String geenSter = sterLeeg + sterLeeg + sterLeeg + sterLeeg + sterLeeg;
    public String eenSter = sterVol + sterLeeg + sterLeeg + sterLeeg + sterLeeg;
    public String tweeSterren = sterVol + sterVol + sterLeeg + sterLeeg + sterLeeg;
    public String drieSterren = sterVol + sterVol + sterVol + sterLeeg + sterLeeg;
    public String vierSterren = sterVol + sterVol + sterVol + sterVol + sterLeeg;
    public String vijfSterren = sterVol + sterVol + sterVol + sterVol + sterVol;

    public int apparaatNummer = MainProgram.gekozenLosApparaat;
    public String naamApparaat = MainProgram.naamGekozenApparaat;
    public Double laatstePPM = 0.0;

    private XYDataset createDataset() throws SQLException {


        DefaultXYDataset ds = new DefaultXYDataset();

        Connection connect = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/carbontec",
                "Bob",
                "ikbenbob");

        PreparedStatement pst = null;
        Statement statement = connect.createStatement( );
        ResultSet waarde = statement.executeQuery("SELECT waarde FROM apparaat WHERE serienummer = " + apparaatNummer + " AND tijd like '2022-01-19%'");

        ArrayList<Double> ppmwaardes = new ArrayList<>();
        int i = 1;
        while (waarde.next()){
            ppmwaardes.add(waarde.getDouble(i));
            i++;
        }
        int a = ppmwaardes.size() - 1;
        while (a <= 24){
            ppmwaardes.add(0.0);
            a++;
        }

        System.out.println(ppmwaardes);

        //data aanpassen
        // eerste is uren
        // tweede is ppm
        double[][] data = { {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24}, {ppmwaardes.get(0),ppmwaardes.get(1),ppmwaardes.get(2),ppmwaardes.get(3),ppmwaardes.get(4),ppmwaardes.get(5),ppmwaardes.get(6),ppmwaardes.get(7),ppmwaardes.get(8),ppmwaardes.get(9),ppmwaardes.get(10),ppmwaardes.get(11),ppmwaardes.get(12),ppmwaardes.get(13),ppmwaardes.get(14),ppmwaardes.get(15),ppmwaardes.get(16),ppmwaardes.get(17),ppmwaardes.get(18),ppmwaardes.get(19),ppmwaardes.get(20),ppmwaardes.get(21),ppmwaardes.get(22),ppmwaardes.get(23),} };

        ds.addSeries("Apparaat", data);

        laatstePPM = ppmwaardes.get(23);
        return ds;
    }

    private void ButtonPressed(ActionEvent e){
        if (e.getSource() == logOut) callback.accept(1);
        if (e.getSource() == home) callback.accept(2);
        if (e.getSource() == apparaten) callback.accept(3);
    }

    public LosApparaat(){

        //String apparaatNummer = MainProgram.gekozenLosApparaat;
        //String naamApparaat = MainProgram.naamGekozenApparaat;

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
        losApparaatBg.add(new JSeparator(JSeparator.VERTICAL));
        losApparaatBg.setVisible(true);


        XYDataset ds = null;
        try {
            ds = createDataset();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JFreeChart chart =
                ChartFactory.createXYLineChart("CO2 afgelopen 24 uur",
                        "uren", "ppm", ds, PlotOrientation.VERTICAL, true, true,
                        false);

        ChartPanel cp = new ChartPanel(chart);
        cp.setBounds(screenSize.width*2/6, screenSize.height/8, screenSize.width/2, screenSize.height*3/4);



        JLabel apparaatNaam = new JLabel();
        apparaatNaam.setForeground(new Color(0,0,0));
        apparaatNaam.setBackground(new Color(0,0,255));
        apparaatNaam.setFont(new Font("Segoe UI", 1, screenSize.width/85));
        apparaatNaam.setText(naamApparaat);

        JLabel Rating = new JLabel(); //"<html>First line and maybe second line</html>"

        Rating.setFont(new Font("Segoe UI", 1, screenSize.width/85));
        Rating.setBorder(new RoundedBorder(2));
        // System.out.println("Uw CO2 rating is: ");
        if (laatstePPM > 500) {
            Rating.setText("Ongezond!");
            Rating.setForeground(new Color(255,0,0));
        } else {
            Rating.setText("Gezond!");
            Rating.setForeground(new Color(0,255,0));
        }

        JLabel RatingText = new JLabel();
        RatingText.setForeground(new Color(0,0,0));
        RatingText.setBackground(new Color(0,0,255));
        RatingText.setFont(new Font("Seqoe UI", 1, screenSize.width/85));
        RatingText.setText("Uw CO2 rating is:");

        JLabel ratingMaand = new JLabel();
        ratingMaand.setFont(new Font("Dialog.bold",0,screenSize.width/80));
        ratingMaand.setForeground(new Color(0,0,0));
        ratingMaand.setText(geenSter);

        JLabel ratingWeek = new JLabel();
        ratingWeek.setFont(new Font("Dialog.bold",0,screenSize.width/80));
        ratingWeek.setForeground(new Color(0,0,0));
        ratingWeek.setText(geenSter);

        /*JLabel ratingDag = new JLabel();
        ratingDag.setFont(new Font("Dialog.bold",0,screenSize.width/80));
        ratingDag.setForeground(new Color(0,0,0));
        ratingDag.setText(vijfSterren);*/


        //JLabel GeschDag = new JLabel();
        //GeschDag.setForeground(new Color(150,100,255));
        //.setFont(new Font("Segoe UI", 1, screenSize.width/80));
        //GeschDag.setText("Geschiedenis afgelopen 24 uur");
        //GeschDag.setVisible(true);

        JLabel CO2PPM = new JLabel();
        CO2PPM.setForeground(new Color(0,0,0));
        CO2PPM.setFont(new Font("Segoe UI", 1, screenSize.width/85));
        CO2PPM.setText(laatstePPM + " PPM");

        JPanel Ratingpanel = new JPanel();
        Ratingpanel.setBackground(new Color(255, 255, 255));
        Ratingpanel.setBounds(screenSize.width*2/17, screenSize.height/8, screenSize.width*3/4, screenSize.height*3/4);

        JLabel RatingmaandText = new JLabel();
        RatingmaandText.setForeground(new Color(0,0,0));
        RatingmaandText.setBackground(new Color(0,0,255));
        RatingmaandText.setFont(new Font("Seqoe UI", 1, screenSize.width/85));
        RatingmaandText.setText("Rating deze maand:");

        JLabel RatingweekText = new JLabel();
        RatingweekText.setForeground(new Color(0,0,0));
        RatingweekText.setBackground(new Color(0,0,255));
        RatingweekText.setFont(new Font("Seqoe UI", 1, screenSize.width/85));
        RatingweekText.setText("Rating deze week:");

        /*Grafiek apparaatgrafiek = new Grafiek();
        apparaatgrafiek.setForeground(new Color(0,0,0));
        apparaatgrafiek.setBackground(new Color(0,0,255));
*/
        /*JLabel Ratingdagtext = new JLabel();
        Ratingdagtext.setForeground(new Color(0,0,0));
        Ratingdagtext.setBackground(new Color(0,0,255));
        Ratingdagtext.setFont(new Font("Seqoe UI", 1, screenSize.width/85));
        Ratingdagtext.setText("Rating vandaag:");*/


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
                                .addGap(screenSize.width/70)
                                .addGroup(losApparaatLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(RatingText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(screenSize.width/2)
                                                .addComponent(apparaatNaam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(screenSize.width/2)
                                                .addComponent(Rating, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(screenSize.width/2)
                                                .addComponent(CO2PPM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(screenSize.width/2)
//                                                .addComponent(Ratingdagtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
//                                                .addGap(screenSize.width/2)
//                                                .addComponent(ratingDag, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(screenSize.width/2)
                                                .addComponent(RatingweekText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(screenSize.width/2)
                                                .addComponent(ratingWeek, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(screenSize.width/2)
                                                .addComponent(RatingmaandText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(screenSize.width/2)
                                                .addComponent(ratingMaand, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(screenSize.width/2)
//                                                .addComponent(apparaatgrafiek, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        // .addComponent(GeschDag, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE
                                )




                        )


        );

        losApparaatLayout.setVerticalGroup(
                losApparaatLayout.createParallelGroup(GroupLayout.Alignment.LEADING)


                        .addGroup(losApparaatLayout.createSequentialGroup()

                                .addGap(screenSize.height/35)
                                .addComponent(apparaatNaam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(screenSize.height/50)
                                .addComponent(RatingText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                         .addGap(screenSize.height/50)
                                .addComponent(Rating, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(screenSize.height/50)
                                .addComponent(CO2PPM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(screenSize.height/4)
                                // .addComponent(Ratingdagtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        //.addGap(screenSize.height/50)
//                                .addComponent(ratingDag, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(screenSize.height/20)
                                .addComponent(RatingweekText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(screenSize.height/50)
                                .addComponent(ratingWeek, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(screenSize.height/50)
                                .addComponent(RatingmaandText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(screenSize.height/50)
                                .addComponent(ratingMaand, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)



                        )


                        //.addGroup(losApparaatLayout.createSequentialGroup()
                                //.addGap(5)
                                //.addComponent(GeschDag, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)

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
        bg.add(cp);
        bg.add(losApparaatBg);




    }

    private static double[][] getSineData(double phase) {

        double[] xData = new double[100];
        double[] yData = new double[100];
        for (int i = 0; i < xData.length; i++) {
            double radians = phase + (2 * Math.PI / xData.length * i);
            xData[i] = radians;
            yData[i] = Math.sin(radians);
        }
        return new double[][] { xData, yData };
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
