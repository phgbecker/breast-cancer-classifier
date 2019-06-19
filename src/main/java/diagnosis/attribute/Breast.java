package diagnosis.attribute;

import lombok.Getter;

@Getter
public enum Breast {
    LEFT("left"),
    RIGHT("right");

    private final String value;

    Breast(String value) {
        this.value = value;
    }
}
