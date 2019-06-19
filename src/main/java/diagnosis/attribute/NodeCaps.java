package diagnosis.attribute;

import lombok.Getter;

@Getter
public enum NodeCaps {
    YES("yes"),
    NO("no");

    private final String value;

    NodeCaps(String value) {
        this.value = value;
    }
}
