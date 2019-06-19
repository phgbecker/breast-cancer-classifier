package diagnosis;

import org.junit.Test;
import weka.classifiers.trees.J48;
import weka.core.Instances;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassifierModelTest {

    @Test
    public void givenFileName_whenLoadModel_thenIsInstanceOfLogistic() throws IOException, ClassNotFoundException {
        assertThat(
                new ClassifierModel<>().loadModel("breast-cancer.model")
        ).isInstanceOf(J48.class);
    }

    @Test
    public void givenFileName_whenloadDataSetFromArff_thenIsInstanceOfInstances() throws IOException {
        assertThat(
                new ClassifierModel<>().loadDataSetFromArff("breast-cancer.arff")
        ).isInstanceOf(Instances.class);
    }
}
