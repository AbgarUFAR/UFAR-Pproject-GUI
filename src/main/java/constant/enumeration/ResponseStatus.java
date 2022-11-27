package constant.enumeration;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ResponseStatus {
    SUCCESS("success"),
    ERROR("error");

    private final String value;

    @Override
    public String toString() {
        return value;
    }
}
