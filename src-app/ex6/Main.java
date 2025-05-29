package ex6;

public class Main {

    private static int N_THREADS = 3;

    public static void main(String[] args) {
	for (int i = 1; i <= N_THREADS; i++) {
	    new MainThread("App Thread: " + i, i).start();
	}
    }
}
