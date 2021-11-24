import keeptoo.KGradientPanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Arc2D;
import java.util.Random;
import java.util.function.Consumer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;
import javax.swing.JLabel;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
public class Home extends JFrame {

    public JButton logOut = new JButton("<html><U>Uitloggen</U></html>");

    public JButton home = new JButton("Home");

    public JButton apparaten = new JButton("Apparaten");

    public JButton alleApparaten = new JButton("Alle apparaten");

    public Consumer<Integer> callback;

    public Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public String sterLeeg = String.valueOf("\u2606");
    public String sterVol = String.valueOf("\u2605");
    public String geenSter = sterLeeg + sterLeeg + sterLeeg + sterLeeg + sterLeeg;
    public String eenSter = sterLeeg + sterLeeg + sterLeeg + sterLeeg + sterVol;
    public String tweeSterren = sterLeeg + sterLeeg + sterLeeg + sterVol + sterVol;
    public String drieSterren = sterLeeg + sterLeeg + sterVol + sterVol + sterVol;
    public String vierSterren = sterLeeg + sterVol + sterVol + sterVol + sterVol;
    public String vijfSterren = sterVol + sterVol + sterVol + sterVol + sterVol;

    public int apparatenOnline = 5; // Dit moet aan db gekoppeld worden
    public int totaalApparaten = 10; // Dit moet aan db gekoppeld worden

    public int uptime = 97; // Procenten

    private void ButtonPressed(ActionEvent e){
        if (e.getSource() == logOut) callback.accept(1);
        if (e.getSource() == home) callback.accept(2);
        if (e.getSource() == apparaten) callback.accept(3);
        if (e.getSource() == alleApparaten) callback.accept(3);
    }



    public Home() throws InterruptedException {

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


        logOut.setFont(new Font("Segoe UI", 0,screenSize.width/96));
        logOut.setForeground(new Color(102, 102, 102));
        logOut.setOpaque(false);
        logOut.setBorderPainted(false);
        logOut.setContentAreaFilled(false);
        logOut.addActionListener(this::ButtonPressed);


        home.setFont(new Font("Segoe UI",1,screenSize.width/80));
        home.setForeground(new Color(0,0,0));
        home.setOpaque(false);
        home.setContentAreaFilled(false);
        home.addActionListener(this::ButtonPressed);
        home.setBorder(BorderFactory.createMatteBorder(0, 0, screenSize.width/720, 0, new Color(12, 91, 160)));

        apparaten.setFont(new Font("Segoe UI",1,screenSize.width/80));
        apparaten.setForeground(new Color(0,0,0));
        apparaten.setOpaque(false);
        apparaten.setBorderPainted(false);
        apparaten.setContentAreaFilled(false);
        apparaten.addActionListener(this::ButtonPressed);
        apparaten.setBorder(BorderFactory.createEmptyBorder());


        JPanel apparatenpanel = new JPanel();
        apparatenpanel.setBackground(new Color(255,255,255));
        apparatenpanel.setBounds(screenSize.width/20,screenSize.height/7, screenSize.width*10/24, screenSize.height*10/14);


        JPanel gezondheidspanel = new JPanel();
        gezondheidspanel.setBackground(new Color(255,255,255));
        gezondheidspanel.setBounds(screenSize.width*10/19,screenSize.height/7,screenSize.width*10/24,screenSize.height*10/30);


        JPanel statistiekenpanel = new JPanel();
        statistiekenpanel.setBackground(new Color(255,255,255));
        statistiekenpanel.setBounds(screenSize.width*10/19, screenSize.height*40/77, screenSize.width*10/24, screenSize.height*10/30);


        JLabel apparatenlbl = new JLabel();
        apparatenlbl.setFont(new Font("Segoe UI",1,screenSize.width/80));
        apparatenlbl.setForeground(new Color(0,0,0));
        apparatenlbl.setText("Apparaten");


        alleApparaten.setFont(new Font("Segoe UI",1,screenSize.width/96));
        alleApparaten.setContentAreaFilled(false);
        alleApparaten.setOpaque(false);
        alleApparaten.setForeground(new Color(12, 91, 160));
        alleApparaten.setBorder(new RoundedBorder(5));
        alleApparaten.addActionListener(this::ButtonPressed);


        JLabel gezndrtngDag = new JLabel();
        gezndrtngDag.setFont(new Font("Segoe UI",1,screenSize.width/80));
        gezndrtngDag.setForeground(new Color(0,0,0));
        gezndrtngDag.setText("Gezondheidsrating afgelopen dag:");


        JLabel gezndrtngWeek = new JLabel();
        gezndrtngWeek.setFont(new Font("Segoe UI",1,screenSize.width/80));
        gezndrtngWeek.setForeground(new Color(0,0,0));
        gezndrtngWeek.setText("Gezondheidsrating afgelopen week:");


        JLabel gezndrtngMaand = new JLabel();
        gezndrtngMaand.setFont(new Font("Segoe UI",1,screenSize.width/80));
        gezndrtngMaand.setForeground(new Color(0,0,0));
        gezndrtngMaand.setText("Gezondheidsrating afgelopen maand:");


        JLabel gezndrtngJaar = new JLabel();
        gezndrtngJaar.setFont(new Font("Segoe UI",1,screenSize.width/80));
        gezndrtngJaar.setForeground(new Color(0,0,0));
        gezndrtngJaar.setText("Gezondheidsrating afgelopen jaar:");


        // Later hieronder sterren koppelen aan berekening met db gegevens
        JLabel ratingDag = new JLabel();
        ratingDag.setFont(new Font("Dialog.bold",0,screenSize.width/80));
        ratingDag.setForeground(new Color(0,0,0));
        ratingDag.setText(geenSter);


        JLabel ratingWeek = new JLabel();
        ratingWeek.setFont(new Font("Dialog.bold",0,screenSize.width/80));
        ratingWeek.setForeground(new Color(0,0,0));
        ratingWeek.setText(geenSter);


        JLabel ratingMaand = new JLabel();
        ratingMaand.setFont(new Font("Dialog.bold",0,screenSize.width/80));
        ratingMaand.setForeground(new Color(0,0,0));
        ratingMaand.setText(geenSter);


        JLabel ratingJaar = new JLabel();
        ratingJaar.setFont(new Font("Dialog.bold",0,screenSize.width/80));
        ratingJaar.setForeground(new Color(0,0,0));
        ratingJaar.setText(geenSter);


        JPanel linkerGauge = new JPanel();
        linkerGauge.setBounds(screenSize.width*10/19, screenSize.height*40/74, screenSize.width*10/48, screenSize.height*10/35);
        linkerGauge.setBackground(new Color(255,255,255));


        JPanel rechterGauge = new JPanel();
        rechterGauge.setBounds(screenSize.width*30/41, screenSize.height*40/74, screenSize.width*10/48, screenSize.height*10/35);
        rechterGauge.setBackground(new Color(255,255,255));


        GaugeChart gaugeChart1 = new GaugeChart();
        gaugeChart1.setColor1(new Color(252, 92, 125));
        gaugeChart1.setColor2(new Color(106, 130, 251));
        gaugeChart1.setSize(screenSize.height/200,screenSize.height/200);
        int percentageOnline = (int) Math.round((double) apparatenOnline / totaalApparaten * 100);
        gaugeChart1.setValue(percentageOnline);
        gaugeChart1.setLocation(screenSize.width/10,screenSize.height/10);
        linkerGauge.add(gaugeChart1);


        GaugeChart gaugeChart2 = new GaugeChart();
        gaugeChart2.setColor1(new Color(252, 92, 125));
        gaugeChart2.setColor2(new Color(106, 130, 251));
        gaugeChart2.setSize(screenSize.height/200,screenSize.height/200);
        gaugeChart2.setValue(uptime);
        gaugeChart2.setLocation(screenSize.width/10,screenSize.height/10);
        rechterGauge.add(gaugeChart2);


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


        GroupLayout apparatenLayout = new GroupLayout(apparatenpanel);
        apparatenpanel.setLayout(apparatenLayout);
        apparatenLayout.setHorizontalGroup(
                apparatenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(apparatenLayout.createSequentialGroup()
                                .addGap(screenSize.width/30)
                                .addGroup(apparatenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(apparatenlbl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(apparatenLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(alleApparaten)
                                        )
                                )
                        )
        );


        apparatenLayout.setVerticalGroup(
                apparatenLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(apparatenLayout.createSequentialGroup()
                                .addGap(screenSize.height/30)
                                .addComponent(apparatenlbl)
                                .addGap(screenSize.height*10/18)
                                .addComponent(alleApparaten)
                        )
        );


        GroupLayout gezondheidLayout = new GroupLayout(gezondheidspanel);
        gezondheidspanel.setLayout(gezondheidLayout);
        gezondheidLayout.setHorizontalGroup(
                gezondheidLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gezondheidLayout.createSequentialGroup()
                                .addGap(screenSize.width/30)
                                .addGroup(gezondheidLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(gezndrtngDag)
                                        .addComponent(gezndrtngWeek)
                                        .addComponent(gezndrtngMaand)
                                        .addComponent(gezndrtngJaar)
                                )
                        )
                        .addGroup(gezondheidLayout.createSequentialGroup()
                                .addGap(screenSize.width/3)
                                .addGroup(gezondheidLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(ratingDag)
                                        .addComponent(ratingWeek)
                                        .addComponent(ratingMaand)
                                        .addComponent(ratingJaar)
                                )
                        )
        );

        gezondheidLayout.setVerticalGroup(
                gezondheidLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gezondheidLayout.createSequentialGroup()
                                .addGap(screenSize.height/23)
                                .addComponent(gezndrtngDag)
                                .addGap(screenSize.height/26)
                                .addComponent(gezndrtngWeek)
                                .addGap(screenSize.height/26)
                                .addComponent(gezndrtngMaand)
                                .addGap(screenSize.height/26)
                                .addComponent(gezndrtngJaar)
                        )
                        .addGroup(gezondheidLayout.createSequentialGroup()
                                .addGap(screenSize.height/23)
                                .addComponent(ratingDag)
                                .addGap(screenSize.height/24)
                                .addComponent(ratingWeek)
                                .addGap(screenSize.height/24)
                                .addComponent(ratingMaand)
                                .addGap(screenSize.height/24)
                                .addComponent(ratingJaar)
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
        bg.add(apparatenpanel);
        bg.add(gezondheidspanel);
        bg.add(linkerGauge);
        bg.add(rechterGauge);
        bg.add(statistiekenpanel);

    }

    public class GaugeChart extends JComponent {


        public int getGaugeSize() {
            return gaugeSize;
        }

        public void setGaugeSize(int gaugeSize) {
            this.gaugeSize = gaugeSize;
            repaint();
        }

        public Color getColor1() {
            return color1;
        }

        public void setColor1(Color color1) {
            this.color1 = color1;
            repaint();
        }

        public Color getColor2() {
            return color2;
        }

        public void setColor2(Color color2) {
            this.color2 = color2;
            repaint();
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            if (animator.isRunning()) {
                animator.stop();
            }
            if (value < 0) {
                value = 0;
            }
            this.value = value;
            lastAnimate = getValueFixed();
            repaint();
        }

        public int getMaximum() {
            return maximum;
        }

        public void setMaximum(int maximum) {
            this.maximum = maximum;
            repaint();
        }

        private int gaugeSize = 15;
        private Color color1 = new Color(51, 71, 216);
        private Color color2 = new Color(237, 63, 63);
        private int value;
        private int maximum = 100;
        private final Animator animator;
        private float targetAnimate;
        private float currentAnimate;
        private float lastAnimate;

        public GaugeChart() {
            screenSize.width = (int) (screenSize.width*3)/4;
            screenSize.height = (int) (screenSize.height*3)/4;
            setFont(new JLabel().getFont().deriveFont(0, screenSize.width/72));
            setPreferredSize(new Dimension(250, 220));
            setForeground(new Color(60, 60, 60));
            TimingTarget target = new TimingTargetAdapter() {
                @Override
                public void timingEvent(float fraction) {
                    currentAnimate = (targetAnimate - lastAnimate) * fraction;
                    currentAnimate += lastAnimate;
                    value = (int) currentAnimate;
                    repaint();
                }

                @Override
                public void end() {
                    lastAnimate = currentAnimate;
                }
            };
            animator = new Animator(500, target);
            animator.setResolution(0);
            animator.setAcceleration(0.5f);
            animator.setDeceleration(0.5f);
        }

        @Override
        public void paint(Graphics grphcs) {
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            float spaceBot = 0.15f; //  space bot 15%
            int width = getWidth();
            int height = getHeight();
            height += (int) (height * spaceBot);
            int size = Math.min(width, height) - (gaugeSize + 5);   //  5 is margin
            int centerSize = 20;
            int x = (width - size) / 2;
            int y = (height - size) / 2;
            int centerX = width / 2;
            int centerY = height / 2;
            int angleStart = -35;
            g2.setColor(new Color(240, 240, 240));
            g2.fillOval(centerX - centerSize / 2, centerY - centerSize / 2, centerSize, centerSize);
            g2.setStroke(new BasicStroke(gaugeSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
            Shape s = new Arc2D.Double(x, y, size, size, angleStart, 250, Arc2D.OPEN);
            g2.draw(s);
            double angle = getAngleOfValues();
            if (angle > 0) {
                s = new Arc2D.Double(x, y, size, size, angleStart + 250 - angle, angle, Arc2D.OPEN);
                GradientPaint gra = new GradientPaint(0, 0, color1, width, 0, color2);
                g2.setPaint(gra);
                g2.draw(s);
            }
            g2.setStroke(new BasicStroke(1f));
            //  Create line
            double len = 20;
            double space = 250 / len;
            double start = angleStart + 7;
            double angleSize = (size / 2) - gaugeSize;
            g2.setColor(new Color(200, 200, 200));
            for (int i = 1; i <= len; i++) {
                Point p = getLocation(start, angleSize);
                g2.fillOval(centerX + p.x - 2, centerY - p.y - 2, 4, 4);
                start += space;
            }
            //  Create pointer
            double ang = angleStart + 250 - angle;
            g2.setColor(color2);
            Path2D p = new Path2D.Double();
            Point end = getLocation(ang, angleSize);
            Point right = getLocation(ang - 90, 5);
            Point left = getLocation(ang + 90, 5);
            p.moveTo(centerX + left.x, centerY - left.y);
            p.lineTo(centerX + end.x, centerY - end.y);
            p.lineTo(centerX + right.x, centerY - right.y);
            g2.fill(p);
            g2.fillOval(centerX - 5, centerY - 5, 10, 10);
            g2.setColor(new Color(240, 240, 240));
            g2.fillOval(centerX - 2, centerY - 2, 4, 4);
            drawText(g2, centerX, centerY, angleSize);
            super.paint(grphcs);
        }

        private void drawText(Graphics2D g2, int x, int y, double size) {
            g2.setColor(getForeground());
            double max = maximum;
            double v = getValueFixed();
            double n = v / max * 100f;
            String text = String.valueOf((int) n) + "%";
            FontMetrics ft = g2.getFontMetrics();
            Rectangle2D r2 = ft.getStringBounds(text, g2);
            g2.drawString(text, (int) (x - r2.getWidth() / 2), (int) (y + size - r2.getHeight()));
        }

        private double getAngleOfValues() {
            double max = maximum;
            double v = getValueFixed();
            double n = v / max * 100f;
            double angle = n * 250f / 100f;
            return angle;
        }

        private int getValueFixed() {
            return value > maximum ? maximum : value;
        }

        private Point getLocation(double angle, double size) {
            double x = Math.cos(Math.toRadians(angle)) * size;
            double y = Math.sin(Math.toRadians(angle)) * size;
            return new Point((int) x, (int) y);
        }

        public void setValueWithAnimation(int value) {
            if (value < 0) {
                value = 0;
            }
            this.targetAnimate = value > maximum ? maximum : value;
            if (animator.isRunning()) {
                animator.stop();
            }
            animator.start();
        }
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
