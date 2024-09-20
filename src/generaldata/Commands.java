package generaldata;

public enum Commands {
    ADD,
    LIST,
    EXIT,
    UNKNOWN;

    public static Commands of(String input) {
        for (Commands command : Commands.values()) {
            if (command.name().equals(input)) {
                return command;
            }
        }
        return UNKNOWN;
    }
}
