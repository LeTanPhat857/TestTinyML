import controller.Controller;
import controller.iController;
import dataReader.IdxReader;
import dataReader.iDataReader;
import model.Model;
import model.iModel;

import net.ANN.ANN;
import net.activeFunction.ActiveFunc;
import net.iNet;
import net.optimizer.Optimizer;
import net.weightInit.WeightInit;

public class TestTinyML {

    public static void main(String[] args) {
        iNet net = new ANN()
                .addFulConnLayer(64, ActiveFunc.get("relu"),784)
                .addFulConnLayer(32, ActiveFunc.get("sigmoid"))
                .addFulConnLayer(10, ActiveFunc.get("softmax"))
                .setWeightInit(WeightInit.get("randomWeight"))
                .setOptimizer(Optimizer.miniBatch_SGD("ANN",10, 0.5))
                .build();
        // create net
        // create dataReader
        iDataReader dataReader = new IdxReader().setNormalization(true).setNumOfClass(10);
        // create model
        iModel model = new Model().setNet(net).setDataReader(dataReader);
        // create controller
        iController controller = new Controller(model);
    }
}
