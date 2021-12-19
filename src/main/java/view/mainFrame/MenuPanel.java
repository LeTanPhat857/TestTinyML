package view.mainFrame;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    // fields
    JButton homeButton;
    JButton settingButton;
    JButton exitButton;

    // constructor
    public MenuPanel() {
        // set up option panel
        this.setLayout(new FlowLayout(2, 30, 5));
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY, 2, false), "Menu", 3,
                2, new Font("Arial", Font.ITALIC, 14), Color.BLUE));

        // create button
        this.homeButton = new JButton("home");
        this.settingButton = new JButton("setting");
        this.exitButton = new JButton("exit");

        // add button
        this.add(homeButton);
        this.add(settingButton);
        this.add(exitButton);
    }

    // run test
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());

        MenuPanel optionPanel = new MenuPanel();

        frame.add(optionPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
        frame.pack();
    }

    // methods
    public JButton getHomeButton() {
        return this.homeButton;
    }

    // methods
    public void setHomeButton(JButton homeButton) {
        this.homeButton = homeButton;
    }

    public JButton getSettingButton() {
        return this.settingButton;
    }

    public void setSettingButton(JButton settingButton) {
        this.settingButton = settingButton;
    }

    public JButton getExitButton() {
        return this.exitButton;
    }

    public void setExitButton(JButton exitButton) {
        this.exitButton = exitButton;
    }

}
