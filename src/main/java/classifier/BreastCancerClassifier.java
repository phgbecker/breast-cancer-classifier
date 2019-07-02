package classifier;

import classifier.instance.BreastCancerInstance;
import classifier.instance.attribute.DiagnosisClass;
import classifier.model.ClassifierModel;
import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;

import java.io.IOException;
import java.util.HashMap;

public class BreastCancerClassifier {
    private J48 j48;
    private Instances dataSet;

    public BreastCancerClassifier loadModel(String fileName) throws IOException, ClassNotFoundException {
        j48 = new ClassifierModel<J48>().loadModel(fileName);

        return this;
    }

    public BreastCancerClassifier loadDataSet(String fileName) throws IOException {
        dataSet = ClassifierModel.loadDataSetFromArff(fileName);
        dataSet.setClassIndex(dataSet.numAttributes() - 1);

        return this;
    }

    private Instance setUpInstance(BreastCancerInstance fertilityInstance) {
        Instance instance = fertilityInstance.getInstance(dataSet);

        System.out.println();
        System.out.print("INSTANCE: ");
        System.out.println(instance);

        return instance;
    }

    public void classifyInstance(String fileName) throws Exception {
        BreastCancerInstance fertilityInstance = BreastCancerInstance.deserializeFromJson(fileName);
        Instance instance = setUpInstance(fertilityInstance);
        classifyInstance(instance);
    }

    private void classifyInstance(Instance instance) throws Exception {
        HashMap<Integer, DiagnosisClass> diagnosisMap = new HashMap<>();
        diagnosisMap.put(0, DiagnosisClass.RECURRENCE_EVENTS);
        diagnosisMap.put(1, DiagnosisClass.NO_RECURRENCE_EVENTS);

        System.out.println();
        System.out.print("DIAGNOSIS: ");
        System.out.println(diagnosisMap.get((int) j48.classifyInstance(instance)).getDescription());

        double[] distributionForInstance = j48.distributionForInstance(instance);
        diagnosisMap.forEach((index, diagnosis) ->
                System.out.println(diagnosis.getDescription() + "\t-> " + distributionForInstance[index])
        );
    }
}
