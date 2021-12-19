package controller;

public interface iController {

    public void startTraining();

    public void startPredicting();

    public void startSaving(String savingPath);

    public void startLoading(String loadingPath);

    public void startTesting();

    public void showTrainingImage();

    public void showPredictImage();

}
