import keeptoo.KGradientPanel;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class LogIn extends JFrame{

    public LogIn() {
        //Maken van objects
        KGradientPanel bg = new KGradientPanel();
        JPanel loginBg = new JPanel();

        //Instellen van objects
        //bg.setLayout(new GridLayout());
        bg.setStartColor(new java.awt.Color(195,55,100));
        bg.setEndColor(new java.awt.Color(29,38,113));
        bg.setGradientFocus(700);

        //loginBg.setForeground(new java.awt.Color(67,70,75));
        //loginBg.setBackground(new java.awt.Color(67,70,75));
        loginBg.setBounds(1100,100,550,750);


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


        //Scherm tonen
        setVisible(true);
    }

}

