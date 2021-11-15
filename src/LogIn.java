import keeptoo.KGradientPanel;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class LogIn extends JFrame{

    public LogIn() {

        //Maken en instellen objects
        //bg.setLayout(new GridLayout());
        KGradientPanel bg = new KGradientPanel();
        bg.setStartColor(new java.awt.Color(252, 92, 125));
        bg.setEndColor(new java.awt.Color(106, 130, 251));
        bg.setGradientFocus(1500);


        //loginBg.setForeground(new java.awt.Color(67,70,75));
        JPanel loginBg = new JPanel();
        //loginBg.setBackground(new java.awt.Color(179, 188, 196));
        loginBg.setBounds(1100,100,500,750);


        JLabel foto = new JLabel();
        foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("ComputerCloud512x512.png")));
        foto.setBounds(250,220,512,512);


        JLabel carbonNaam = new JLabel();
        carbonNaam.setIcon(new javax.swing.ImageIcon(getClass().getResource("CarbonTec100x17.png")));
        carbonNaam.setBounds(50,900,100,17);




        //Opstellen van scherm
        setTitle("CarbonTec Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1800,1000);
        setContentPane(bg);
        //Toevoegen image
        ImageIcon imageIcon = new ImageIcon("Icon.png");
        setIconImage(imageIcon.getImage());

        //Objects toevoegen aan scherm
        bg.add(loginBg);
        bg.add(foto);
        bg.add(carbonNaam);

        //Scherm tonen
        setVisible(true);
    }

}

