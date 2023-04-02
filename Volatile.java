//Stop a thread from execution Thread.stop is deprecated now, we can use his technique instead
public class Volatile {
    private static volatile boolean flag = false;

    public static void setFlag() {
        flag = true;
    }

    public static void doSomething() {
        while (!flag) {
            // Normal Thread execution
            System.out.println("Application is Terminated now!");
        }
        System.out.println("Application is Terminated now!");
    }

    public static void main(String[] args) {
        setFlag();//Set terminate flag to true
        doSomething();
    }

}
