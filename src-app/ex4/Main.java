package ex4;

public class Main {

    private static int N_THREADS = 10;
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
	for (int i = 1; i <= N_THREADS; i++) {
	    new ex4.MainThread(i).start();
	}

    }
}
