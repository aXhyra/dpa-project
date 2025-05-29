package ex2;

public class Main {

    private final static int N_THREADS = 10;
    private static int N = 1;

    public static void main(String[] args) {
        for (int i = 0; i < N_THREADS; i++) {
            new MainThread("Application Thread "+ i, N++).start();
        }
    }

}
