package gitlet;

/** Driver class for Gitlet, a subset of the Git version-control system.
 *  @author TODO
 */
public class Main {

    /** Usage: java gitlet.Main ARGS, where ARGS contains
     *  <COMMAND> <OPERAND1> <OPERAND2> ... 
     */
    public static void main(String[] args) {
        // TODO: what if args is empty?
        if (args.length == 0) {
            Utils.exitWithError("Must have at least one argument");
        }
        String firstArg = args[0];
        switch(firstArg) {
            case "init":
                validateNumArgs("init", args, 1);
                // TODO: handle the `init` command
                break;
            case "add":
                // TODO: handle the `add [filename]` command
                break;
            // TODO: FILL THE REST IN
            case "commit":
                //TODO
                break;
            case "rm":
                //TODO
                break;
            case "log":
                //TODO
                break;
            case "global-log":
                //TODO
                break;
            case "find":
                //TODO
                break;
            case "status":
                //TODO
                break;
            case "checkout":
                //TODO
                break;
            case "branch":
                //TODO
                break;
            case "rm-branch":
                //TODO
                break;
            case "reset":
                //TODO
                break;
            case "merge":
                //TODO
                break;
            default:
                Utils.exitWithError(String.format("Unknown command: %s", args[0]));
        }
        return;
    }
    /**
     * Checks the number of arguments versus the expected number,
     * throws a RuntimeException if they do not match.
     *
     * @param cmd Name of command you are validating
     * @param args Argument array from command line
     * @param n Number of expected arguments
     */
    public static void validateNumArgs(String cmd, String[] args, int n) {
        if (args.length != n) {
            throw new RuntimeException(
                    String.format("Invalid number of arguments for: %s.", cmd));
        }
    }
}
