import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;




class Apparaat extends JFrame {

    public JButton dag = new JButton("dag");

    public JButton week = new JButton("week");

    public JButton maand = new JButton("maand");

    public Consumer<Integer> callback;

    private void ButtonPressed(ActionEvent e) {
        if (e.getSource() == dag) callback.accept(1);
        if (e.getSource() == week) callback.accept(2);
        if (e.getSource() == maand) callback.accept(3);
    }
}


