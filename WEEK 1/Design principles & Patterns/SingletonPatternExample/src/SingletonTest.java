public class SingletonTest {

    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        Logger logger3 = Logger.getInstance();

        // Log via different references
        logger1.log("First log message");
        logger2.log("Second log message");
        logger3.log("Third log message");

        // Show actual memory address (hashCode) of each reference
        System.out.println("\nlogger1 hashCode: " + System.identityHashCode(logger1));
        System.out.println("logger2 hashCode: " + System.identityHashCode(logger2));
        System.out.println("logger3 hashCode: " + System.identityHashCode(logger3));

        // Direct == check proves it is literally the same object in memory
        System.out.println("\nlogger1 == logger2 : " + (logger1 == logger2));
        System.out.println("logger2 == logger3 : " + (logger2 == logger3));
        System.out.println("logger1 == logger3 : " + (logger1 == logger3));

        if (logger1 == logger2 && logger2 == logger3) {
            System.out.println("\nSingleton VERIFIED: all three variables point to the same instance.");
        } else {
            System.out.println("\nSingleton FAILED: multiple instances were created.");
        }
    }
}