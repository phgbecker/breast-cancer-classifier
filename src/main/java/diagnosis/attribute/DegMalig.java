package diagnosis.attribute;

import lombok.Getter;

@Getter
public enum DegMalig {
    ONE("1"),
    TWO("2"),
    THREE("3");

    private final String value;

    DegMalig(String value) {
        this.value = value;
    }
}
