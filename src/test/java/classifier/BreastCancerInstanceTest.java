package classifier;

import classifier.instance.BreastCancerInstance;
import classifier.instance.attribute.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class BreastCancerInstanceTest {
    private BreastCancerInstance breastCancerInstance;

    @Before
    public void setUp() {
        breastCancerInstance = new BreastCancerInstance(
                Age.AGE_30_39,
                Menopause.LT40,
                TumorSize.SIZE_0_4,
                InvNodes.NODES_6_8,
                NodeCaps.YES,
                DegMalig.ONE,
                Breast.LEFT,
                BreastQuad.CENTRAL,
                Irradiat.NO
        );
    }

    @Test
    public void givenFileName_whenSerializeToJson_thenWriteToFile() throws IOException {
        breastCancerInstance.serializeToJson("breast-cancer-instance.json");
    }

    @Test
    public void givenFileName_whenDeserializeFromJson_thenIsEquals() throws IOException {
        assertThat(BreastCancerInstance.deserializeFromJson("breast-cancer-instance.json")).isEqualTo(breastCancerInstance);
    }
}
