public enum CommandWord {
    GO("go"),
    QUIT("quit"),
    HELP("help"),
    LOOK("look"),
    TAKE("take"),
    DROP("drop"),
    GIVE("give"),
    UNKNOWN("?");

    private String commandValue;

    CommandWord(String commandValue) {
        this.commandValue=commandValue;
    }

    @Override
    public String toString() {
        return commandValue;
    }
}
