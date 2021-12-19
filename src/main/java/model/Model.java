package model;


import dataReader.iDataReader;
import dataType.Vector;
import net.iNet;
import utils.ImgUtils;

import java.awt.image.BufferedImage;

public class Model implements iModel {

    // fields
    iNet net;
    iDataReader dataReader;

    // constructor
    public Model() {
    }

    // methods
    public iModel setNet(iNet net) {
        try {
            this.net = net;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public iModel setDataReader(iDataReader dataReader) {
        try {
            this.dataReader = dataReader;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public iNet getNet() {
        return this.net;
    }

    public iDataReader getDataReader() {
        return this.dataReader;
    }

    public String getNetInfo() {
        return "Le Tan Phat - 18130173\n\n" +
                "HandwrittenDigitRecognition\n" +
                "---------------------------------\n\n" +
                net.getInfo();
    }

    public String getDataInfo() {
        return dataReader.getNumOfTrainImgs() + " training examples" + ", " + dataReader.getNumOfTestImgs() + " testing examples";
    }


//    ImgUtils.getInstance("input image").showImage(bufferedImage);

    public Vector predict(BufferedImage bufferedImage) {
        // divisor to normalize pixel
        double divisor = 1;
        if (dataReader.getNormalization()) {
            divisor = 255;
        }
        //
        return net.predict(Vector.create(ImgUtils.convertImageToArray(bufferedImage, divisor)));
    }

    public boolean loadTrainingData(String dataSetPath, String labelSetPath) {
        try {
            return this.dataReader.loadTrainingData(dataSetPath) && this.dataReader.loadTrainingLabel(labelSetPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean loadTestingData(String dataSetPath, String labelSetPath) {
        try {
            return this.dataReader.loadTestingData(dataSetPath) && this.dataReader.loadTestingLabel(labelSetPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public long train() {
        try {
            return this.net.train(dataReader.getTrainingData(), dataReader.getTrainingLabel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public double test() {
        try {
            return this.net.test(dataReader.getTestingData(), dataReader.getTestingLabel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean save(String savingPath) {
        try {
            return this.net.saveCurrentNet(savingPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean load(String loadingPath) {
        try {
            return this.net.loadTrainedNet(loadingPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
