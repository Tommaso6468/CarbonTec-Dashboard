import keeptoo.KGradientPanel;

import javax.swing.*;
import java.awt.*;

public class LogIn extends JFrame{
    private KGradientPanel KGradientPanel1;
    private JPanel panel1;

    public static void main(String[] args) {

        //JFrame is gui scherm
        JFrame frame = new JFrame(); //maakt een frame
        frame.setTitle("CarbonTec Dashboard"); //Maakt de titel aan
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //sluit het programma als je op x drukt
        frame.setResizable(false); //gebruiker kan dan niet het scherm van grootte veranderen
        frame.setSize(1800,1000); //maakt de grootte
        frame.setContentPane(new LogIn().KGradientPanel1); //voegt de gradient panel toe
        frame.setVisible(true); //laat het scherm zien

        ImageIcon imageIcon = new ImageIcon("Icon.png"); //maakt icon
        frame.setIconImage(imageIcon.getImage()); //zet het icon op het frame



    }


}

