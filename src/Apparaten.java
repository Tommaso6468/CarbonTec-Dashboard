import keeptoo.KGradientPanel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;

public class Apparaten extends JFrame {

    public JButton logOut = new JButton("<html><U>Uitloggen</U></html>");

    public JButton home = new JButton("Home");

    public JButton apparaten = new JButton("Apparaten");

    public JButton nieuwApparaat = new JButton("Nieuw apparaat");

    public static String data[][] = new String[1000][1000];
    public String col[] = {"Serienummer","Naam","Bekijk"};
    public JTable apparatenLijst = new JTable(data,col);

    public int ApparaatNummer = 0;
    public static int ValueY;

    public static Consumer<Integer> callback;

    private void ButtonPressed(ActionEvent e){
        if (e.getSource() == logOut) callback.accept(1);
        if (e.getSource() == home) callback.accept(2);
        if (e.getSource() == apparaten) callback.accept(3);
        if (e.getSource() == nieuwApparaat) callback.accept(4);
    }

    public Apparaten(){

        //Resolutie gebruiker zoeken
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        screenSize.width = (int) (screenSize.width*3)/4;
        screenSize.height = (int) (screenSize.height*3)/4;


        String path = "apparaten.csv";
        String line = "";
        int counter = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null){
                data[counter] = line.split(",");
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


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


        JPanel panel = new JPanel();
        panel.setBackground(new Color(255,255,255));
        panel.setBounds(screenSize.width/15, screenSize.height/7, screenSize.width*10/12, screenSize.height*10/14);


        JLabel apparatenLbl = new JLabel();
        apparatenLbl.setFont(new Font("Segoe UI",1,screenSize.width/80));
        apparatenLbl.setForeground(new Color(0,0,0));
        apparatenLbl.setText("| Apparaten");

        nieuwApparaat.setFont(new Font("Segoe UI",1,screenSize.width/96));
        nieuwApparaat.setContentAreaFilled(false);
        nieuwApparaat.setOpaque(false);
        nieuwApparaat.setForeground(new Color(12, 91, 160));
        nieuwApparaat.setBorder(new Apparaten.RoundedBorder(5));
        nieuwApparaat.addActionListener(this::ButtonPressed);


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


        JScrollPane scrollPane = new JScrollPane(apparatenLijst);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.RIGHT );
        apparatenLijst.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        apparatenLijst.setBackground(new Color(255,255,255));
        apparatenLijst.setTableHeader(null);
        apparatenLijst.setBorder(BorderFactory.createMatteBorder(0, 0, screenSize.width/720, 0, new Color(255, 255, 255)));
        apparatenLijst.setGridColor(new Color(255,255,255));
        apparatenLijst.setShowHorizontalLines(false);
        apparatenLijst.setShowVerticalLines(false);
        scrollPane.getViewport().setBackground(new Color(255,255,255));
        scrollPane.setVerticalScrollBar(new ScrollBarCustom());
        apparatenLijst.setRowHeight(screenSize.height/20);
//        apparatenLijst.setEnabled(false);
        apparatenLijst.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
        apparatenLijst.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JTextField()));
        apparatenLijst.getColumnModel().getColumn(1).setCellEditor(new ButtonEditor2(new JTextField()));
        apparatenLijst.getColumnModel().getColumn(0).setCellEditor(new ButtonEditor2(new JTextField()));


        GroupLayout panelLayout = new GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(screenSize.width/35)
                                .addGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(apparatenLbl)
                                        .addComponent(scrollPane)
                                        .addComponent(nieuwApparaat)
                                )
                                .addGap(screenSize.width/35)
                        )
        );

        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(panelLayout.createSequentialGroup()
                                .addGap(screenSize.height/25)
                                .addComponent(apparatenLbl)
                                .addGap(screenSize.height/60)
                                .addComponent(scrollPane)
                                .addGap(screenSize.height/60)
                                .addComponent(nieuwApparaat)
                                .addGap(screenSize.height/40)
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
        bg.add(panel);
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

class ModernScrollBarUI extends BasicScrollBarUI {

    private final int THUMB_SIZE = 80;

    @Override
    protected Dimension getMaximumThumbSize() {
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            return new Dimension(0, THUMB_SIZE);
        } else {
            return new Dimension(THUMB_SIZE, 0);
        }
    }

    @Override
    protected Dimension getMinimumThumbSize() {
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            return new Dimension(0, THUMB_SIZE);
        } else {
            return new Dimension(THUMB_SIZE, 0);
        }
    }

    @Override
    protected JButton createIncreaseButton(int i) {
        return new ScrollBarButton();
    }

    @Override
    protected JButton createDecreaseButton(int i) {
        return new ScrollBarButton();
    }

    @Override
    protected void paintTrack(Graphics grphcs, JComponent jc, Rectangle rctngl) {

    }

    @Override
    protected void paintThumb(Graphics grphcs, JComponent jc, Rectangle rctngl) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = rctngl.x;
        int y = rctngl.y;
        int width = rctngl.width;
        int height = rctngl.height;
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            y += 8;
            height -= 16;
        } else {
            x += 8;
            width -= 16;
        }
        g2.setColor(scrollbar.getForeground());
        g2.fillRoundRect(x, y, width, height, 1, 1);
    }

    private class ScrollBarButton extends JButton {

        public ScrollBarButton() {
            setBorder(BorderFactory.createEmptyBorder());
        }

        @Override
        public void paint(Graphics grphcs) {
        }
    }
}

class ScrollBarCustom extends JScrollBar {

    public ScrollBarCustom() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(5, 5));
        setForeground(new Color(94, 139, 231));
        setUnitIncrement(20);
        setOpaque(false);
    }
}

class TableHeader extends JLabel {

    public TableHeader(String text) {
        super(text);
        setOpaque(true);
        setBackground(Color.WHITE);
        setFont(new Font("sansserif", 1, 12));
        setForeground(new Color(102, 102, 102));
        setBorder(new EmptyBorder(10, 5, 10, 5));
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(230, 230, 230));
        g2.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
    }
}

class ButtonRenderer extends JButton implements TableCellRenderer
{

    public ButtonRenderer() {
        setOpaque(true);
        setBackground(new Color(179, 188, 196));
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object obj,
                                                   boolean selected, boolean focused, int row, int col) {

        setText((obj==null) ? "":obj.toString());

        return this;
    }

}

class ButtonEditor extends DefaultCellEditor
{
    protected JButton btn;
    private String lbl;
    private Boolean clicked;

    public ButtonEditor(JTextField txt) {
        super(txt);

        btn=new JButton();
        btn.setOpaque(true);
        btn.setBackground(new Color(179, 188, 196));

        btn.addActionListener(e -> fireEditingStopped());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object obj,
                                                 boolean selected, int row, int col) {

        lbl=(obj==null) ? "":obj.toString();
        btn.setText(lbl);
        clicked=true;
        return btn;
    }

    @Override
    public Object getCellEditorValue() {

        if(clicked)
        {
            int yButton = Math.toIntExact(btn.getY()/40);
            int gekozenApparaat = Integer.parseInt(Apparaten.data[yButton][0]);
            MainProgram.gekozenLosApparaat = gekozenApparaat;
            Apparaten.ValueY = yButton;
            String naamGekozenApparaat = Apparaten.data[yButton][0];
            MainProgram.naamGekozenApparaat = naamGekozenApparaat;
            System.out.println(gekozenApparaat);
            System.out.println(naamGekozenApparaat);
            Apparaten.callback.accept(5);
        }
        clicked=false;
        return new String(lbl);
    }

    @Override
    public boolean stopCellEditing() {

        clicked=false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}

class ButtonEditor2 extends DefaultCellEditor
{
    protected JButton btn;
    private String lbl;
    private Boolean clicked;

    public ButtonEditor2(JTextField txt) {
        super(txt);

        btn=new JButton();
        btn.setOpaque(true);
        btn.setBackground(new Color(179, 188, 196));

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                fireEditingStopped();
            }
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object obj,
                                                 boolean selected, int row, int col) {

        lbl=(obj==null) ? "":obj.toString();
        btn.setText(lbl);
        clicked=true;
        return btn;
    }

    @Override
    public Object getCellEditorValue() {

        clicked=false;
        return new String(lbl);
    }

    @Override
    public boolean stopCellEditing() {

        clicked=false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}