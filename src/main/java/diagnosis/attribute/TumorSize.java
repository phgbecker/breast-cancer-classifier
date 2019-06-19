package diagnosis.attribute;

import lombok.Getter;

@Getter
public enum TumorSize {
    SIZE_0_4("0-4"),
    SIZE_5_9("5-9"),
    SIZE_10_14("10-14"),
    SIZE_15_19("15-19"),
    SIZE_20_24("20-24"),
    SIZE_25_29("25-29"),
    SIZE_30_34("30-34"),
    SIZE_35_39("35-39"),
    SIZE_40_44("40-44"),
    SIZE_45_49("45-49"),
    SIZE_50_54("50-54"),
    SIZE_55_59("55-59");

    private final String value;

    TumorSize(String value) {
        this.value = value;
    }
}
