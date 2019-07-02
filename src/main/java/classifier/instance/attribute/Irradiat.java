package classifier.instance.attribute;

import lombok.Getter;

@Getter
public enum Irradiat {
    YES("yes"),
    NO("no");

    private final String value;

    Irradiat(String value) {
        this.value = value;
    }
}
