import keeptoo.KGradientPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.function.Consumer;

public class LogIn extends JFrame {

    public Consumer<Integer> callback;


    public JButton inloggen = new JButton();

    public JButton maakAccount = new JButton("<html><u>Of maak een account</u></html");

    //Kijkt of er buttons gedrukt worden
    private void ButtonPressed(ActionEvent e){

        if (e.getSource() == inloggen) callback.accept(1);
        if (e.getSource() == maakAccount) callback.accept(2);

    }


    public LogIn() throws IOException {
        //Resolutie gebruiker zoeken
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenSize.width = (int) (screenSize.width*3)/4;
        screenSize.height = (int) (screenSize.height*3)/4;

        //Maken en instellen objects
        //bg.setLayout(new GridLayout());
        KGradientPanel bg = new KGradientPanel();
        bg.setStartColor(new Color(252, 92, 125));
        bg.setEndColor(new Color(106, 130, 251));
        bg.setGradientFocus(1500);


        //loginBg.setForeground(new java.awt.Color(67,70,75));
        JPanel loginBg = new JPanel();


        loginBg.setBackground(new java.awt.Color(255, 255, 255));
        loginBg.setBounds((screenSize.width*5)/9, screenSize.height/7, (screenSize.width*10)/31, (screenSize.height*10)/15);


        BufferedImage fotoBuffer = ImageIO.read(Objects.requireNonNull(getClass().getResource("ComputerCloud512x512.png")));
        Image fotoResized = fotoBuffer.getScaledInstance((screenSize.width*10)/50,(screenSize.width*10)/50,Image.SCALE_DEFAULT);


        JLabel foto = new JLabel();
        foto.setIcon(new ImageIcon(fotoResized));
        foto.setBounds(screenSize.width/7, screenSize.height/4, (screenSize.width*10)/50, (screenSize.width*10)/50);


        JLabel carbonNaam = new JLabel();
        carbonNaam.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("CarbonTec100x17.png"))));
        carbonNaam.setBounds(screenSize.width/39, (screenSize.height/10)*9, 100, 17);


        JLabel logIn = new JLabel();
        logIn.setFont(new Font("Segoe UI", 1, 18));
        logIn.setForeground(new Color(102, 102, 102));
        logIn.setText("Log in met uw CarbonTec account");


        JLabel loginEmail = new JLabel();
        loginEmail.setFont(new Font("Segoe UI", 0, 15));
        loginEmail.setForeground(new Color(102, 102, 102));
        loginEmail.setText("Email");


        JLabel loginPwd = new JLabel();
        loginPwd.setFont(new Font("Segoe UI", 0, 15));
        loginPwd.setForeground(new Color(102, 102, 102));
        loginPwd.setText("Wachtwoord");


        JTextField loginEmailTxt = new JTextField();
        loginEmailTxt.setFont(new Font("Segoe UI", 0, 14));
        loginEmailTxt.setForeground(new Color(102, 102, 102));
        loginEmailTxt.setBackground(new Color(255,255,255));
        loginEmailTxt.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(12, 91, 160)));


        JPasswordField loginPwdTxt = new JPasswordField();
        loginPwdTxt.setFont(new Font("Segoe UI", 0, 15));
        loginPwdTxt.setForeground(new Color(102, 102, 102));
        loginPwdTxt.setBackground(new Color(255,255,255));
        loginPwdTxt.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(12, 91, 160)));


        KGradientPanel buttonGradient = new KGradientPanel();
        buttonGradient.setStartColor(new Color(252, 92, 125));
        buttonGradient.setEndColor(new Color(106, 130, 251));
        buttonGradient.setGradientFocus(200);



        inloggen.setFont(new Font("Segoe UI", 1, 17));
        inloggen.setText("           Inloggen");
        inloggen.setOpaque(false);
        inloggen.setContentAreaFilled(false);
        inloggen.setBorderPainted(false);
        buttonGradient.add(inloggen);
        inloggen.setBounds(0, 0, 300, 40);
        inloggen.setForeground(new Color(255,255,255));
        inloggen.addActionListener(this::ButtonPressed);



        maakAccount.setFont(new Font("Segoe UI", 0,15));
        maakAccount.setForeground(new Color(179, 179, 179));
        maakAccount.setOpaque(false);
        maakAccount.setBorderPainted(false);
        maakAccount.setContentAreaFilled(false);
        maakAccount.addActionListener(this::ButtonPressed);




        GroupLayout loginBlokLayout = new GroupLayout(loginBg);
        loginBg.setLayout(loginBlokLayout);
        loginBlokLayout.setHorizontalGroup(
                loginBlokLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(loginBlokLayout.createSequentialGroup()
                        .addGap(screenSize.width/30, screenSize.width/30, screenSize.width/30)
                        .addGroup(loginBlokLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(logIn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(loginBlokLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(loginPwd, screenSize.width/4, screenSize.width/4, screenSize.width/4)
                                        .addComponent(loginEmail)
                                        .addComponent(loginEmailTxt)
                                        .addComponent(loginPwdTxt)
                                        .addComponent(buttonGradient, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                                        .addComponent(maakAccount, GroupLayout.Alignment.CENTER,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE)
                                )
                        )
                )
        );


        loginBlokLayout.setVerticalGroup(
                loginBlokLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(loginBlokLayout.createSequentialGroup()
                        .addGap(50,50,50)
                        .addComponent(logIn)
                        .addGap(60,60,60)
                        .addComponent(loginEmail)
                        .addGap(18,18,18)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginEmailTxt,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                        .addGap(60,60,60)
                        .addComponent(loginPwd)
                        .addGap(18,18,18)
                        .addComponent(loginPwdTxt,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,24,Short.MAX_VALUE)
                        .addComponent(buttonGradient, GroupLayout.PREFERRED_SIZE,44,GroupLayout.PREFERRED_SIZE)
                        .addGap(5,5,5)
                        .addComponent(maakAccount)
                        .addGap(50,50,50)
                )
        );


        //Opstellen van scherm
        setTitle("CarbonTec Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(screenSize.width, screenSize.height);
        setContentPane(bg);
        getRootPane().setDefaultButton(inloggen);


        //Toevoegen image
        ImageIcon imageIcon = new ImageIcon("Icon.png");
        setIconImage(imageIcon.getImage());

        //Objects toevoegen aan scherm
        bg.add(loginBg);
        bg.add(foto);
        bg.add(carbonNaam);

    }


}

