package jdbchomework.console;

import org.apache.commons.lang3.StringUtils;

import java.util.function.Predicate;

public enum InputType {
    STRING(input -> true, ""),
    INTEGER(StringUtils::isNumeric, "Error! Please enter a number"),
    LIST(input -> input.matches("[0-9 ]+"), "Error! Please enter numbers separated by spaces");

    private String errorMessage;
    private Predicate<String> isValid;

    InputType(Predicate<String> value, String errorMessage) {
        this.errorMessage = errorMessage;
        this.isValid = value;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Predicate<String> getIsValid() {
        return isValid;
    }
}
