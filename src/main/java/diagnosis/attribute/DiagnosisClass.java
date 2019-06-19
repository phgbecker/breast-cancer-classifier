package diagnosis.attribute;

import lombok.Getter;

@Getter
public enum DiagnosisClass {
    NO_RECURRENCE_EVENTS("no-recurrence-events", "No recurrence events"),
    RECURRENCE_EVENTS("recurrence-events", "Recurrence events");

    private final String value;
    private final String description;

    DiagnosisClass(String value, String description) {
        this.value = value;
        this.description = description;
    }
}
