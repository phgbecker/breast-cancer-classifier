package classifier;

public class Classifier {

    public static void main(String[] args) throws Exception {
        BreastCancerClassifier classifier = new BreastCancerClassifier();

        classifier
                .loadModel("breast-cancer.model")
                .loadDataSet("breast-cancer.arff")
                .classifyInstance("breast-cancer-instance.json");
    }
}
