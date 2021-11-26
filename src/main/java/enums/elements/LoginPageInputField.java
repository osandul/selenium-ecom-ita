package enums.elements;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public enum LoginPageInputField {
    EMAIL_INPUT_FIELD("email"),
    PASSWORD_INPUT_FIELD("password");

    private final String xpathField;

    @Override
    public String toString() {
        return xpathField;
    }


}
