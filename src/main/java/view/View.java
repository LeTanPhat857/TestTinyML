package view;

import controller.iController;
import utils.ImgUtils;
import view.mainFrame.AccuracyPanel;
import view.mainFrame.InputPanel;
import view.mainFrame.MainFrame;
import view.mainFrame.OutputPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class View {

    // fields
    private iController controller;
    private MainFrame mainFrame;

    // constructor
    public View(iController controller) {
        this.controller = controller;
        this.mainFrame = new MainFrame("HandwrittenDigitRecognition");

        // set listenner
        setActionForTrainButton();
        setActionForSaveButton();
        setActionForLoadButton();
        setActionForTestButton();
        setActionForInputPanel();
        setActionForShowPredictImage();
        setActionForShowTrainingImage();
    }

    // run test
    public static void main(String[] args) {
        new View(null).mainFrame.setVisible(true);
    }

    // methods
    public void setActionForTrainButton() {
        getTrainButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    if (controller != null) {
                        controller.startTraining();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setActionForSaveButton() {
        getSaveButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (controller != null) {
                    controller.startSaving(getSavingPath().getText());
                }
            }
        });
    }

    public void setActionForLoadButton() {
        getLoadButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (controller != null) {
                    controller.startLoading(getLoadingPath().getText());
                }
            }
        });
    }

    public void setActionForTestButton() {
        getTestButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (controller != null) {
                    controller.startTesting();
                }
            }
        });
    }

    public void setActionForInputPanel() {
        getInputPanel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (controller != null) {
                    controller.startPredicting();
                }
                if (ImgUtils.hasInstance("show predict image")) {
                    ImgUtils.getInstance("show predict image").showImage(getInputPanel().getBufferedImage());
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                getOutputPanel().clear();
            }
        });
    }

    public void setActionForShowPredictImage() {
        this.getShowPredictImageButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controller != null) {
                    controller.showPredictImage();
                }
            }
        });
    }

    public void setActionForShowTrainingImage() {
        this.getShowTrainingImageButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (controller != null) {
                    controller.showTrainingImage();
                }
            }
        });
    }

    // get
    public MainFrame getMainFrame() {
        return mainFrame;
    }

    // homePanel
    public JTextArea getInfoArea() {
        return this.mainFrame.getInfoTextArea();
    }

    public InputPanel getInputPanel() {
        return this.mainFrame.getInputPanel();
    }

    public OutputPanel getOutputPanel() {
        return this.mainFrame.getOutputPanel();
    }

    public AccuracyPanel getAccuracyPanel() {
        return mainFrame.getAccuracyPanel();
    }

    public JButton getShowPredictImageButton() {
        return mainFrame.getShowPredictImageButton();
    }

    // settingPanel
    public JTextField getDataSetPathField() {
        return this.mainFrame.getDataSetPathField();
    }

    public JTextField getLabelSetPathField() {
        return this.mainFrame.getLabelSetPathField();
    }

    public JTextField getDataTestSetPathField() {
        return this.mainFrame.getDataTestSetPathField();
    }

    public JTextField getLabelTestSetPathField() {
        return this.mainFrame.getLabelTestSetPathField();
    }

    //
    public JTextArea getStatusTextArea() {
        return this.mainFrame.getStatusTextArea();
    }

    //
    public JTextField getSavingPath() {
        return this.mainFrame.getSavingPath();
    }

    public JTextField getLoadingPath() {
        return this.mainFrame.getLoadingPath();
    }

    //
    public JButton getTrainButton() {
        return this.mainFrame.getTrainButton();
    }

    public JButton getSaveButton() {
        return this.mainFrame.getSaveButton();
    }

    public JButton getLoadButton() {
        return this.mainFrame.getLoadButton();
    }

    public JButton getTestButton() {
        return this.mainFrame.getTestButton();
    }

    public JButton getShowTrainingImageButton() {
        return this.mainFrame.getShowTrainingImageButton();
    }
}
