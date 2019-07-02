package classifier.instance.attribute;

import lombok.Getter;

@Getter
public enum InvNodes {
    NODES_0_2("0-2"),
    NODES_3_5("3-5"),
    NODES_6_8("6-8"),
    NODES_9_11("9-11"),
    NODES_12_14("12-14"),
    NODES_15_17("15-17"),
    NODES_18_20("18-20"),
    NODES_21_23("21-23"),
    NODES_24_26("24-26"),
    NODES_27_29("27-29"),
    NODES_30_32("30-32"),
    NODES_33_35("33-35"),
    NODES_36_39("36-39");

    private final String value;

    InvNodes(String value) {
        this.value = value;
    }
}
