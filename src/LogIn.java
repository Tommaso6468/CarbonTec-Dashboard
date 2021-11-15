import keeptoo.KGradientPanel;
import javax.swing.*;
import java.awt.*;

public class LogIn extends JFrame{
    private KGradientPanel KGradientPanel1;
    private JPanel panel1;

    public LogIn() {

        KGradientPanel1.setLayout(new GridLayout());

        setTitle("CarbonTec Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1800,1000);
        setContentPane(KGradientPanel1);
        setVisible(true);

        ImageIcon imageIcon = new ImageIcon("Icon.png");
        setIconImage(imageIcon.getImage());


    }


}

