import keeptoo.KGradientPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class SignUp extends JFrame {


    private void signupButtonPressed(ActionEvent e){

    }



    public SignUp() {

        //Maken en instellen objects
        //bg.setLayout(new GridLayout());
        KGradientPanel bg = new KGradientPanel();
        bg.setStartColor(new Color(252, 92, 125));
        bg.setEndColor(new Color(106, 130, 251));
        bg.setGradientFocus(1500);


        //loginBg.setForeground(new java.awt.Color(67,70,75));
        JPanel signupBg = new JPanel();


        signupBg.setBackground(new Color(255, 255, 255));
        signupBg.setBounds(1100, 100, 500, 750);


        JLabel foto = new JLabel();
        foto.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("ComputerCloud512x512.png"))));
        foto.setBounds(250, 220, 512, 512);


        JLabel carbonNaam = new JLabel();
        carbonNaam.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("CarbonTec100x17.png"))));
        carbonNaam.setBounds(50, 900, 100, 17);



        JLabel signup = new JLabel();
        signup.setFont(new Font("Segoe UI", 1, 20));
        signup.setForeground(new Color(102, 102, 102));
        signup.setText("Maak een CarbonTec account aan ");


        JLabel signupVoornaam = new JLabel();
        signupVoornaam.setFont(new Font("Segoe UI", 0, 15));
        signupVoornaam.setForeground(new Color(102,102,102));
        signupVoornaam.setText("Voornaam");


        JTextField signupVoornaamTxt = new JTextField();
        signupVoornaamTxt.setFont(new Font("Segoe UI",0,14));
        signupVoornaamTxt.setForeground(new Color(102,102,102));
        signupVoornaamTxt.setBackground(new Color(255,255,255));
        signupVoornaamTxt.setBorder(BorderFactory.createMatteBorder(0,0,2,0,new Color(12,91,160)));


        JLabel signupAchternaam = new JLabel();
        signupAchternaam.setFont(new Font("Segoe UI",0,15));
        signupAchternaam.setForeground(new Color(102,102,102));
        signupAchternaam.setText("Achternaam");


        JTextField signupAchternaamTxt = new JTextField();
        signupAchternaamTxt.setFont(new Font("Segoe UI",0,14));
        signupAchternaamTxt.setForeground(new Color(102,102,102));
        signupAchternaamTxt.setBackground(new Color(255,255,255));
        signupAchternaamTxt.setBorder(BorderFactory.createMatteBorder(0,0,2,0,new Color(12,91,160)));



        JLabel signupEmail = new JLabel();
        signupEmail.setFont(new Font("Segoe UI", 0, 15));
        signupEmail.setForeground(new Color(102, 102, 102));
        signupEmail.setText("Email");


        JLabel signupPwd = new JLabel();
        signupPwd.setFont(new Font("Segoe UI", 0, 15));
        signupPwd.setForeground(new Color(102, 102, 102));
        signupPwd.setText("Wachtwoord");


        JTextField signupEmailTxt = new JTextField();
        signupEmailTxt.setFont(new Font("Segoe UI", 0, 14));
        signupEmailTxt.setForeground(new Color(102, 102, 102));
        signupEmailTxt.setBackground(new Color(255,255,255));
        signupEmailTxt.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(12, 91, 160)));


        JPasswordField signupPwdTxt = new JPasswordField();
        signupPwdTxt.setFont(new Font("Segoe UI", 0, 14));
        signupPwdTxt.setForeground(new Color(102, 102, 102));
        signupPwdTxt.setBackground(new Color(255,255,255));
        signupPwdTxt.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(12, 91, 160)));


        KGradientPanel buttonGradient = new KGradientPanel();
        buttonGradient.setStartColor(new Color(252, 92, 125));
        buttonGradient.setEndColor(new Color(106, 130, 251));
        buttonGradient.setGradientFocus(200);


        JButton aanmaken = new JButton();
        aanmaken.setFont(new Font("Segoe UI", 1, 17));
        aanmaken.setText("Aanmaken                         ");
        aanmaken.setOpaque(false);
        aanmaken.setContentAreaFilled(false);
        aanmaken.setBorderPainted(false);
        buttonGradient.add(aanmaken);
        aanmaken.setBounds(100,0,300,40);
        aanmaken.setForeground(new Color(255,255,255));
        aanmaken.addActionListener(this::signupButtonPressed);





        GroupLayout loginBlokLayout = new GroupLayout(signupBg);
        signupBg.setLayout(loginBlokLayout);
        loginBlokLayout.setHorizontalGroup(
                loginBlokLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(loginBlokLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(loginBlokLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(signup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(loginBlokLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(signupVoornaam)
                                                .addComponent(signupVoornaamTxt)
                                                .addComponent(signupAchternaam)
                                                .addComponent(signupAchternaamTxt)
                                                .addComponent(signupEmail)
                                                .addComponent(signupEmailTxt)
                                                .addComponent(signupPwd, 100, 375,375)
                                                .addComponent(signupPwdTxt)
                                                .addComponent(buttonGradient, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                                        )
                                )
                        )
        );


        loginBlokLayout.setVerticalGroup(
                loginBlokLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(loginBlokLayout.createSequentialGroup()
                                .addGap(50,50,50)
                                .addComponent(signup)
                                .addGap(60,60,60)
                                .addComponent(signupVoornaam)
                                .addGap(18,18,18)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(signupVoornaamTxt,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                .addGap(60,60,60)
                                .addComponent(signupAchternaam)
                                .addGap(18,18,18)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(signupAchternaamTxt,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                .addGap(60,60,60)
                                .addComponent(signupEmail)
                                .addGap(18,18,18)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(signupEmailTxt,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                .addGap(60,60,60)
                                .addComponent(signupPwd)
                                .addGap(18,18,18)
                                .addComponent(signupPwdTxt,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,24,Short.MAX_VALUE)
                                .addComponent(buttonGradient, GroupLayout.PREFERRED_SIZE,44,GroupLayout.PREFERRED_SIZE)
                                .addGap(55,55,55)
                        )
        );


        //Opstellen van scherm
        setTitle("CarbonTec Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1800, 1000);
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

