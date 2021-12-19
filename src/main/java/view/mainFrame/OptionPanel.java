package view.mainFrame;

import javax.swing.*;
import java.awt.*;

public class OptionPanel extends JPanel {

    // fields
    JButton clearButton;
    JButton showButton;

    // constructor
    public OptionPanel() {
        // set up this
        this.setLayout(new FlowLayout(0, 40, 0));

        // create component
        clearButton = new JButton("clear");
        showButton = new JButton("show");

        // add component
        this.add(clearButton);
        this.add(showButton);
    }

    // run test
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());

        OptionPanel optionPanel = new OptionPanel();

        frame.add(optionPanel);

        frame.setVisible(true);
        frame.pack();
        frame.setLocationRelativeTo(null);

    }

    // methods
    public JButton getClearButton() {
        return this.clearButton;
    }

    public JButton getShowButton() {
        return this.showButton;
    }

}
