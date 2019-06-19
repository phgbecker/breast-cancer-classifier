package diagnosis;

import weka.classifiers.AbstractClassifier;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ClassifierModel<T extends AbstractClassifier> {

    public T loadModel(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream classifier = new ObjectInputStream(new FileInputStream(fileName))) {
            return (T) classifier.readObject();
        }
    }

    public Instances loadDataSetFromArff(String fileName) throws IOException {
        ArffLoader arffLoader = new ArffLoader();
        arffLoader.setSource(new File(fileName));

        return arffLoader.getDataSet();
    }
}
