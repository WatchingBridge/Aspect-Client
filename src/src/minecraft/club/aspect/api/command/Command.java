package club.aspect.api.command;

public abstract class Command {
    /**
     * Main method
     */
    public abstract void execute(String command, String[] args);

    /**
     * Command names
     */
    public String[] getName() { return getClass().getAnnotation(CommandInfo.class).names(); }

    /**
     * Command description
     */
    public String getDescription() { return getClass().getAnnotation(CommandInfo.class).description(); }


}
