package controller;

import dataType.Matrix;
import dataType.Vector;
import model.iModel;
import utils.ImgUtils;
import utils.Utils;
import view.View;

import java.awt.image.BufferedImage;
import java.io.File;

public class Controller implements iController {

    // fields
    iModel model;
    View view;
    ImgUtils imgUtils;

    // constructor
    public Controller(iModel model) {
        this.model = model;
        this.view = new View(this);

        view.getInfoArea().setText(model.getNetInfo());
        view.getMainFrame().setVisible(true);
    }

    // methods
    @Override
    public void startTraining() {
        // set button
        view.getTrainButton().setText("training...");
        view.getTrainButton().setEnabled(false);
        // print text
        String statusString = "Load data...";
        view.getStatusTextArea().setText(statusString);
        // get data path
        String dataTraingPath = view.getDataSetPathField().getText();
        String labelTrainingPath = view.getLabelSetPathField().getText();
        String dataTestingPath = view.getDataTestSetPathField().getText();
        String labelTestingPath = view.getLabelTestSetPathField().getText();
        boolean checkTrainingData = model.loadTrainingData(dataTraingPath, labelTrainingPath);
        boolean checkTestingData = model.loadTestingData(dataTestingPath, labelTestingPath);
        if (checkTrainingData && checkTestingData) {
            statusString += model.getDataInfo() + "\nTraining...\n";
            view.getStatusTextArea().setText(statusString);
        } else {
            statusString += "ERROR!";
            view.getStatusTextArea().setText(statusString);
            return;
        }
        // show Image
        Thread imgPrinter = new Thread(new Runnable() {
            public void run() {
                try {
                    Matrix data = model.getDataReader().getTrainingData();
                    int row = model.getDataReader().getNumOfRows();
                    int col = model.getDataReader().getNumOfCols();
                    for (int i = 0; i < data.height; i++) {
                        if (model.getDataReader().getNormalization()) {
                            ImgUtils.getInstance("show training image").showImage(Vector.create(data.data[i]).multi(255).data, row, col, (int) model.getNet().predict(Vector.create(data.data[i])).findMaxIndex() + "");
                        } else {
                            ImgUtils.getInstance("show training image").showImage(data.data[i], row, col, (int) model.getNet().predict(Vector.create(data.data[i])).findMaxIndex() + "");
                        }
                        Thread.sleep(1500);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        imgPrinter.setDaemon(true);
        imgPrinter.start();
        // train
        Thread train = new Thread(new Runnable() {
            @Override
            public void run() {
                String statusString = view.getStatusTextArea().getText();
                // train epoch
                try {
                    for (int i = 0; i < 10; i++) {
                        statusString += "epoch " + i + "...time: " + model.train() + " mls, accuracy: " + model.test() + "\n";
                        view.getStatusTextArea().setText(statusString);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // print end
                statusString += "end.";
                view.getStatusTextArea().setText(statusString);
                // reset button
                view.getTrainButton().setText("train");
                view.getTrainButton().setEnabled(true);
                // stop
                imgPrinter.stop();
            }
        });
        train.setDaemon(true);
        train.start();
    }

    @Override
    public void startPredicting() {
        // get predict vector
        Vector predictVec = null;
        try {
            BufferedImage image = view.getInputPanel().getBufferedImage();
            predictVec = model.predict(image);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        // draw output panel
        int maxIndex = Utils.findIndexOfMax(predictVec.data);
        view.getOutputPanel().drawNumber(maxIndex);
        // draw accuracy panel
        String[] accuracyStringArray = Utils.convertDoubleArrayToStringArray(predictVec.data);
        view.getAccuracyPanel().setAccuracyList(accuracyStringArray);
    }

    @Override
    public void startSaving(String savingPath) {
        view.getSaveButton().setText("saving...");
        view.getSaveButton().setEnabled(false);

        String statusString = "saved";
        view.getStatusTextArea().setText(statusString);

        if (view.getSavingPath().getText() != null) {
            model.save(view.getSavingPath().getText());
        }

        view.getSaveButton().setText("save");
        view.getSaveButton().setEnabled(true);
    }

    @Override
    public void startLoading(String loadingPath) {
        view.getLoadButton().setText("saving...");
        view.getLoadButton().setEnabled(false);

        String statusString = "loaded";
        view.getStatusTextArea().setText(statusString);

        File savedNet = new File(loadingPath);

        if (savedNet.exists()) {
            model.save(view.getLoadingPath().getText());
        } else {
            view.getStatusTextArea().setText("file not founed");
        }

        view.getLoadButton().setText("load");
        view.getLoadButton().setEnabled(true);
    }

    @Override
    public void startTesting() {
        // set button
        view.getTestButton().setText("Testing...");
        view.getTestButton().setEnabled(false);
        // print text
        String statusString = "Load data...";
        view.getStatusTextArea().setText(statusString);
        // get data path
        String dataTraingPath = view.getDataSetPathField().getText();
        String labelTrainingPath = view.getLabelSetPathField().getText();
        String dataTestingPath = view.getDataTestSetPathField().getText();
        String labelTestingPath = view.getLabelTestSetPathField().getText();
        boolean checkTrainingData = model.loadTrainingData(dataTraingPath, labelTrainingPath);
        boolean checkTestingData = model.loadTestingData(dataTestingPath, labelTestingPath);
        if (checkTrainingData && checkTestingData) {
            statusString += model.getDataInfo() + "\nTesting...";
            view.getStatusTextArea().setText(statusString);
        } else {
            statusString += "ERROR!";
            view.getStatusTextArea().setText(statusString);
            return;
        }
        // test
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String statusString = view.getStatusTextArea().getText();
                try {
                    long startTime = System.currentTimeMillis();
                    double accuracy = model.test();
                    long endTime = System.currentTimeMillis();
                    statusString += "time: " + (endTime - startTime) + " mls, accuracy: " + accuracy + "\n";
                    view.getStatusTextArea().setText(statusString);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // reset button
                view.getTestButton().setText("test");
                view.getTestButton().setEnabled(true);
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    @Override
    public void showTrainingImage() {
        imgUtils = ImgUtils.getInstance("show training image");
        BufferedImage image = this.view.getInputPanel().getBufferedImage();
        ImgUtils.getInstance("show training image").showImage(image, this.model.predict(image).findMaxIndex() + "");

        if (!imgUtils.getVisible()) {
            imgUtils.setVisible(true);
        }
    }

    @Override
    public void showPredictImage() {
        imgUtils = ImgUtils.getInstance("show predict image");
        imgUtils.showImage(view.getInputPanel().getBufferedImage());

        if (!imgUtils.getVisible()) {
            imgUtils.setVisible(true);
        }
    }
}
