package view.mainFrame;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {

    // fields
    InfoPanel infoPanel;
    InputPanel inputPanel;
    OutputPanel outputPanel;
    AccuracyPanel accuracyPanel;
    OptionPanel optionPanel;

    // constructor
    public HomePanel() {
        // set up this
        this.setLayout(new BorderLayout(10, 10));
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY, 2, false), "Home", 3,
                2, new Font("Arial", Font.ITALIC, 14), Color.BLUE));

        // create component
        infoPanel = new InfoPanel();
        inputPanel = new InputPanel();
        outputPanel = new OutputPanel();
        accuracyPanel = new AccuracyPanel();
        optionPanel = new OptionPanel();

        // add infoPanel, centerPanel, accuracyPanel
        this.add(infoPanel, BorderLayout.NORTH);
        this.add(inputPanel, BorderLayout.WEST);
        this.add(outputPanel, BorderLayout.CENTER);
        this.add(accuracyPanel, BorderLayout.EAST);
        this.add(optionPanel, BorderLayout.SOUTH);
    }

    // run test
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());

        HomePanel homePanel = new HomePanel();

        frame.add(homePanel);

        frame.setVisible(true);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

    }

    // methods
    public JButton getClearButton() {
        return this.optionPanel.getClearButton();
    }

    public JButton getShowImageButton() {
        return this.optionPanel.getShowButton();
    }

    public InputPanel getInputPanel() {
        return this.inputPanel;
    }

    public OutputPanel getOutputPanel() {
        return this.outputPanel;
    }

    public JTextArea getInfoTextArea() {
        return this.infoPanel.getInfoTextArea();
    }

    public AccuracyPanel getAccuracyPanel() {
        return this.accuracyPanel;
    }
}
