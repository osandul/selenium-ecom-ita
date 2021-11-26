package enums.elements;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TableFields {
    INPUT_DATA("inputData"),
    FIELD_NAME("fieldName");

    private final String name;

    @Override
    public String toString() {
        return name;
    }
}
