import keeptoo.KGradientPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class SignUp extends JFrame {

    public JButton aanmaken = new JButton();

    public JButton ofLogIn = new JButton("<html><u>Of log in</u></html");


    private void signupButtonPressed(ActionEvent e){
        //if (e.getSource() == aanmaken)
    }



    public SignUp() throws IOException {

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
        JPanel signupBg = new JPanel();


        signupBg.setBackground(new Color(255, 255, 255));
        signupBg.setBounds((screenSize.width*10)/17, screenSize.height/7, (screenSize.width*10)/31, (screenSize.height*10)/15);


        BufferedImage fotoBuffer = ImageIO.read(Objects.requireNonNull(getClass().getResource("ComputerCloud512x512.png")));
        Image fotoResized = fotoBuffer.getScaledInstance((screenSize.width*10)/30,(screenSize.width*10)/30,Image.SCALE_DEFAULT);

        BufferedImage fotoCarbonBuffer = ImageIO.read(Objects.requireNonNull(getClass().getResource("CarbonTec100x17.png")));
        Image fotoCarbonResized = fotoCarbonBuffer.getScaledInstance(screenSize.width/14,screenSize.height/45,Image.SCALE_DEFAULT);


        JLabel foto = new JLabel();
        foto.setIcon(new ImageIcon(fotoResized));
        foto.setBounds(screenSize.width/12, (screenSize.height*10)/57, (screenSize.width*10)/30, (screenSize.width*10)/30);


        JLabel carbonNaam = new JLabel();
        carbonNaam.setIcon(new ImageIcon(fotoCarbonResized));
        carbonNaam.setBounds(screenSize.width/39, (screenSize.height/10)*9, screenSize.width/14, screenSize.width/85);



        JLabel signup = new JLabel();
        signup.setFont(new Font("Segoe UI", 1, screenSize.width/80));
        signup.setForeground(new Color(102, 102, 102));
        signup.setText("Maak een CarbonTec account aan ");


        JLabel signupVoornaam = new JLabel();
        signupVoornaam.setFont(new Font("Segoe UI", 0, screenSize.width/96));
        signupVoornaam.setForeground(new Color(102,102,102));
        signupVoornaam.setText("Voornaam");


        JTextField signupVoornaamTxt = new JTextField();
        signupVoornaamTxt.setFont(new Font("Segoe UI",0,screenSize.width/103));
        signupVoornaamTxt.setForeground(new Color(102,102,102));
        signupVoornaamTxt.setBackground(new Color(255,255,255));
        signupVoornaamTxt.setBorder(BorderFactory.createMatteBorder(0,0,2,0,new Color(12,91,160)));


        JLabel signupAchternaam = new JLabel();
        signupAchternaam.setFont(new Font("Segoe UI",0,screenSize.width/96));
        signupAchternaam.setForeground(new Color(102,102,102));
        signupAchternaam.setText("Achternaam");


        JTextField signupAchternaamTxt = new JTextField();
        signupAchternaamTxt.setFont(new Font("Segoe UI",0,screenSize.width/103));
        signupAchternaamTxt.setForeground(new Color(102,102,102));
        signupAchternaamTxt.setBackground(new Color(255,255,255));
        signupAchternaamTxt.setBorder(BorderFactory.createMatteBorder(0,0,screenSize.width/720,0,new Color(12,91,160)));



        JLabel signupEmail = new JLabel();
        signupEmail.setFont(new Font("Segoe UI", 0, screenSize.width/96));
        signupEmail.setForeground(new Color(102, 102, 102));
        signupEmail.setText("Email");


        JLabel signupPwd = new JLabel();
        signupPwd.setFont(new Font("Segoe UI", 0, screenSize.width/96));
        signupPwd.setForeground(new Color(102, 102, 102));
        signupPwd.setText("Wachtwoord");


        JTextField signupEmailTxt = new JTextField();
        signupEmailTxt.setFont(new Font("Segoe UI", 0, screenSize.width/103));
        signupEmailTxt.setForeground(new Color(102, 102, 102));
        signupEmailTxt.setBackground(new Color(255,255,255));
        signupEmailTxt.setBorder(BorderFactory.createMatteBorder(0, 0, screenSize.width/720, 0, new Color(12, 91, 160)));


        JPasswordField signupPwdTxt = new JPasswordField();
        signupPwdTxt.setFont(new Font("Segoe UI", 0, screenSize.width/103));
        signupPwdTxt.setForeground(new Color(102, 102, 102));
        signupPwdTxt.setBackground(new Color(255,255,255));
        signupPwdTxt.setBorder(BorderFactory.createMatteBorder(0, 0, screenSize.width/720, 0, new Color(12, 91, 160)));


        KGradientPanel buttonGradient = new KGradientPanel();
        buttonGradient.setStartColor(new Color(252, 92, 125));
        buttonGradient.setEndColor(new Color(106, 130, 251));
        buttonGradient.setGradientFocus(200);
        buttonGradient.setSize(screenSize.width/4, screenSize.height/20);


        aanmaken.setFont(new Font("Segoe UI", 1, screenSize.width/85));
        aanmaken.setText("Aanmaken");
        aanmaken.setOpaque(false);
        aanmaken.setContentAreaFilled(false);
        aanmaken.setBorderPainted(false);
        aanmaken.setSize(buttonGradient.getWidth(), buttonGradient.getHeight());
        aanmaken.setForeground(new Color(255,255,255));
        aanmaken.addActionListener(this::signupButtonPressed);
        buttonGradient.add(aanmaken);


        ofLogIn.setFont(new Font("Segoe UI", 0,screenSize.width/96));
        ofLogIn.setForeground(new Color(179, 179, 179));
        ofLogIn.setOpaque(false);
        ofLogIn.setBorderPainted(false);
        ofLogIn.setContentAreaFilled(false);
        ofLogIn.addActionListener(this::signupButtonPressed);




        GroupLayout loginBlokLayout = new GroupLayout(signupBg);
        signupBg.setLayout(loginBlokLayout);
        loginBlokLayout.setHorizontalGroup(
                loginBlokLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(loginBlokLayout.createSequentialGroup()
                                .addGap(screenSize.width/25)
                                .addGroup(loginBlokLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(signup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(loginBlokLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(signupVoornaam)
                                                .addComponent(signupVoornaamTxt)
                                                .addComponent(signupAchternaam)
                                                .addComponent(signupAchternaamTxt)
                                                .addComponent(signupEmail)
                                                .addComponent(signupEmailTxt)
                                                .addComponent(signupPwd, screenSize.width/4, screenSize.width/4, screenSize.width/4)
                                                .addComponent(signupPwdTxt)
                                                .addComponent(buttonGradient, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                                                .addComponent(ofLogIn, GroupLayout.Alignment.CENTER,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE)
                                        )
                                )
                        )
        );


        loginBlokLayout.setVerticalGroup(
                loginBlokLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(loginBlokLayout.createSequentialGroup()
                                .addGap(screenSize.width/29)
                                .addComponent(signup)
                                .addGap(screenSize.width/48)
                                .addComponent(signupVoornaam)
                                .addGap(screenSize.width/120)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(signupVoornaamTxt,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                .addGap(screenSize.width/48)
                                .addComponent(signupAchternaam)
                                .addGap(screenSize.width/120)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(signupAchternaamTxt,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                .addGap(screenSize.width/48)
                                .addComponent(signupEmail)
                                .addGap(screenSize.width/120)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(signupEmailTxt,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                .addGap(screenSize.width/48)
                                .addComponent(signupPwd)
                                .addGap(screenSize.width/120)
                                .addComponent(signupPwdTxt,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                .addGap(screenSize.width/29)
                                .addComponent(buttonGradient, GroupLayout.PREFERRED_SIZE,screenSize.width/33,GroupLayout.PREFERRED_SIZE)
                                .addGap(screenSize.width/288)
                                .addComponent(ofLogIn)
                                .addGap(screenSize.width/29)
                        )
        );


        //Opstellen van scherm
        setTitle("CarbonTec Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(screenSize.width, screenSize.height);
        setContentPane(bg);
        getRootPane().setDefaultButton(aanmaken);


        //Toevoegen image
        ImageIcon imageIcon = new ImageIcon("Icon.png");
        setIconImage(imageIcon.getImage());

        //Objects toevoegen aan scherm
        bg.add(signupBg);
        bg.add(foto);
        bg.add(carbonNaam);

    }


}

