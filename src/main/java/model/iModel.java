package model;


import dataReader.iDataReader;
import dataType.Vector;
import net.iNet;

import java.awt.image.BufferedImage;

public interface iModel {

    public iModel setNet(iNet net);

    public iModel setDataReader(iDataReader dataReader);

    public iNet getNet();

    public iDataReader getDataReader();

    public String getNetInfo();

    public String getDataInfo();

    public Vector predict(BufferedImage bufferedImage);

    public boolean loadTrainingData(String dataSetPath, String labelSetPath);

    public boolean loadTestingData(String dataSetPath, String labelSetPath);

    public long train();

    public double test();

    public boolean save(String savingPath);

    public boolean load(String loadingPath);
}
