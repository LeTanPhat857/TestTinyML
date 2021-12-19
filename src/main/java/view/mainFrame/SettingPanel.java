package view.mainFrame;

import javax.swing.*;
import java.awt.*;

public class SettingPanel extends JPanel {

    // fields
    DataPanel dataPanel;

    JTextField savingPath;
    JTextField loadingPath;

    StatusPanel statusPanel;

    JButton trainButton;
    JButton saveButton;
    JButton loadButton;
    JButton testButton;
    JButton showButton;

    // constructor
    public SettingPanel() {
        // set up this
        this.setLayout(new BorderLayout(10, 10));
        this.setPreferredSize(new Dimension(600, 500));
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY, 2, false), "Setting",
                3, 2, new Font("Arial", Font.ITALIC, 14), Color.BLUE));

        // create component
        dataPanel = new DataPanel();
        savingPath = new JTextField("trained/savingNet");
        loadingPath = new JTextField("trained/loadingNet");

        statusPanel = new StatusPanel();

        trainButton = new JButton("train");
        saveButton = new JButton("save");
        loadButton = new JButton("load");
        testButton = new JButton("test");
        showButton = new JButton("show");

        // savingPanel
        JPanel savingPanel = new JPanel();
        savingPanel.setLayout(new GridLayout());
        savingPanel.setBorder(BorderFactory.createTitledBorder(null, "Saving Net Path", 1, 2,
                new Font("Arial", Font.ITALIC, 14), Color.BLUE));
        savingPanel.add(savingPath);

        // loadingPanel
        JPanel loadingPanel = new JPanel();
        loadingPanel.setLayout(new GridLayout());
        loadingPanel.setBorder(BorderFactory.createTitledBorder(null, "Loading Net Path", 1, 2,
                new Font("Arial", Font.ITALIC, 14), Color.BLUE));
        loadingPanel.add(loadingPath);

        // tempPanel contains dataPanel, savingPanel and loadingPanel
        JPanel tempPanel = new JPanel();
        tempPanel.setLayout(new BoxLayout(tempPanel, BoxLayout.Y_AXIS));
        tempPanel.add(dataPanel);
        tempPanel.add(savingPanel);
        tempPanel.add(loadingPanel);

        // optionPanel trainButton, saveButton and loadButton
        JPanel optionPanel = new JPanel();
        optionPanel.setLayout(new FlowLayout(0, 40, 0));
        optionPanel.add(trainButton);
        optionPanel.add(saveButton);
        optionPanel.add(loadButton);
        optionPanel.add(testButton);
        optionPanel.add(showButton);

        // add in this
        this.add(tempPanel, BorderLayout.NORTH);
        this.add(statusPanel, BorderLayout.CENTER);
        this.add(optionPanel, BorderLayout.SOUTH);
    }

    // run test
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());

        SettingPanel settingPanel = new SettingPanel();

        frame.add(settingPanel);

        frame.setVisible(true);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }

    // methods
    //
    public JTextField getDataSetPathField() {
        return this.dataPanel.getDataSetPathField();
    }

    public JTextField getLabelSetPathField() {
        return this.dataPanel.getLabelSetPathField();
    }

    public JTextField getDataTestSetPathField() {
        return this.dataPanel.getDataTestSetPathField();
    }

    public JTextField getLabelTestSetPathField() {
        return this.dataPanel.getLabelTestSetPathField();
    }

    //
    public JTextArea getStatusTextArea() {
        return this.statusPanel.getStatusTextArea();
    }

    //
    public JTextField getSavingPath() {
        return savingPath;
    }

    public JTextField getLoadingPath() {
        return loadingPath;
    }

    //
    public JButton getTrainButton() {
        return this.trainButton;
    }

    public JButton getSaveButton() {
        return this.saveButton;
    }

    public JButton getLoadButton() {
        return this.loadButton;
    }

    public JButton getTestButton() {
        return testButton;
    }

    public JButton getShowButton() {
        return this.showButton;
    }
}
