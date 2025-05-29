package ex5;

public class Main {


    private static int N_THREADS = 10;

    public static void main(String[] args) {
	for (int i = 1; i <= N_THREADS; i++) {
	    new ex6.MainThread("App Thread: " + i, i).start();
	}
    }
}
