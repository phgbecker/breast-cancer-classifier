package diagnosis.attribute;

import lombok.Getter;

@Getter
public enum BreastQuad {
    LEFT_UP("left_up"),
    LEFT_LOW("left_low"),
    RIGHT_UP("right_up"),
    RIGHT_LOW("right_low"),
    CENTRAL("central");

    private final String value;

    BreastQuad(String value) {
        this.value = value;
    }
}
