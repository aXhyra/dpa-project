package ex3;

public class Main {

    private final static int N_THREADS = 10;

    public static void main(String[] args) {
        for (int i = 0; i < N_THREADS; i++) {
            new MainThread("APPLICATION THREAD: "+ i).start();
        }
    }

}
