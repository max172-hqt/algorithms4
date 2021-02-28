import edu.princeton.cs.algs4.StdOut;

public class HelloGoodbye {
    public HelloGoodbye() {}

    public static void main(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Invalid arguments");
        }

        StdOut.println("Hello " + args[0] + " and " + args[1]);
        StdOut.println("Goodbye " + args[1] + " and " + args[0]);
    }
}
