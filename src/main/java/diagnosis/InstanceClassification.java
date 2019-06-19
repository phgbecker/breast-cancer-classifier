package diagnosis;

import diagnosis.attribute.DiagnosisClass;
import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;

import java.io.IOException;
import java.util.HashMap;

public class InstanceClassification {

    public static void main(String[] args) throws Exception {
        // Load classifier model
        ClassifierModel<J48> classifierModel = new ClassifierModel<>();
        J48 j48 = loadModel(classifierModel);

        // Load dataset
        Instances dataSet = loadDataSet(classifierModel);

        // Parse a JSON file to an Instance
        BreastCancerInstance breastCancerInstance = BreastCancerInstance.deserializeFromJson("breast-cancer-instance.json");
        Instance instance = setUpInstance(dataSet, breastCancerInstance);

        // Classify instance
        classifyInstance(j48, instance);
    }

    private static J48 loadModel(ClassifierModel<J48> classifierModel) throws IOException, ClassNotFoundException {
        J48 j48 = classifierModel.loadModel("breast-cancer.model");

        System.out.println("MODEL:");
        System.out.println(j48);

        return j48;
    }

    private static Instances loadDataSet(ClassifierModel<J48> classifierModel) throws IOException {
        Instances dataSet = classifierModel.loadDataSetFromArff("breast-cancer.arff");
        dataSet.setClassIndex(dataSet.numAttributes() - 1);

        System.out.println("DATASET:");
        System.out.println(dataSet);

        return dataSet;
    }

    private static Instance setUpInstance(Instances dataSet, BreastCancerInstance breastCancerInstance) {
        Instance instance = breastCancerInstance.getInstance(dataSet);

        System.out.println();
        System.out.print("INSTANCE: ");
        System.out.println(instance);

        return instance;
    }

    private static void classifyInstance(J48 logistic, Instance instance) throws Exception {
        HashMap<Integer, DiagnosisClass> diagnosisMap = new HashMap<>();
        diagnosisMap.put(0, DiagnosisClass.NO_RECURRENCE_EVENTS);
        diagnosisMap.put(1, DiagnosisClass.RECURRENCE_EVENTS);

        System.out.println();
        System.out.print("DIAGNOSIS: ");
        System.out.println(diagnosisMap.get((int) logistic.classifyInstance(instance)).getDescription());

        double[] distributionForInstance = logistic.distributionForInstance(instance);
        diagnosisMap.forEach((index, diagnosis) ->
                System.out.println(diagnosis.getDescription() + "\t-> " + distributionForInstance[index])
        );
    }
}
