import javax.swing.*;

public class ButtonGroup extends JFrame {}

    public JButton dag = new JButton("dag");

    public JButton week = new JButton("week");

    public JButton maand = new JButton("maand");

    ButtonGroup group = new JButton();
    group.add(dag);
            group.add(week);
            group.add(maand);

            this.add(dag);
            this.add(week);
            this.add(maand);
            this.pack();
            this.setvVisible(true);

