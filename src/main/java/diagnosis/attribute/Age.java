package diagnosis.attribute;

import lombok.Getter;

@Getter
public enum Age {
    AGE_10_19("10-19"),
    AGE_20_29("20-29"),
    AGE_30_39("30-39"),
    AGE_40_49("40-49"),
    AGE_50_59("50-59"),
    AGE_60_69("60-69"),
    AGE_70_79("70-79"),
    AGE_80_89("80-89"),
    AGE_90_99("90-99");

    private final String value;

    Age(String value) {
        this.value = value;
    }
}
