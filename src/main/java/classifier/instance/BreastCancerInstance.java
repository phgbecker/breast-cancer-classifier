package classifier.instance;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import classifier.instance.attribute.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

import java.io.File;
import java.io.IOException;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class BreastCancerInstance {
    private Age age;
    private Menopause menopause;
    private TumorSize tumorSize;
    private InvNodes invNodes;
    private NodeCaps nodeCaps;
    private DegMalig degMalig;
    private Breast breast;
    private BreastQuad breastQuad;
    private Irradiat irradiat;

    public void serializeToJson(String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        objectWriter.writeValue(
                new File(fileName),
                this
        );
    }

    public static BreastCancerInstance deserializeFromJson(String fileName) throws IOException {
        return new ObjectMapper().readValue(
                new File(fileName),
                BreastCancerInstance.class
        );
    }

    @JsonIgnore
    public Instance getInstance(Instances dataSet) {
        Instance breastCancerInstance = new DenseInstance(9);
        breastCancerInstance.setDataset(dataSet);

        try {
            breastCancerInstance.setValue(0, getAge().getValue());
            breastCancerInstance.setValue(1, getMenopause().getValue());
            breastCancerInstance.setValue(2, getTumorSize().getValue());
            breastCancerInstance.setValue(3, getInvNodes().getValue());
            breastCancerInstance.setValue(4, getNodeCaps().getValue());
            breastCancerInstance.setValue(5, getDegMalig().getValue());
            breastCancerInstance.setValue(6, getBreast().getValue());
            breastCancerInstance.setValue(7, getBreastQuad().getValue());
            breastCancerInstance.setValue(8, getIrradiat().getValue());
        } catch (NullPointerException e) {
            throw new NullPointerException("Oops, a attribute has not been set. Setup the instance, and try again!");
        }

        return breastCancerInstance;
    }
}
