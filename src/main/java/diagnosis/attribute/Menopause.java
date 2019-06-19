package diagnosis.attribute;

import lombok.Getter;

@Getter
public enum Menopause {
    LT40("lt40"),
    GE40("ge40"),
    PREMENO("premeno");

    private final String value;

    Menopause(String value) {
        this.value = value;
    }
}
