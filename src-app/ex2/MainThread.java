package ex2;

public class MainThread extends Thread {

	private int a;
	private int b;

	private boolean c;


	public MainThread(String name, int n) {
		super(name);
		a = n;
	}

	private static int factorial(int a) {
		int fact = 1;
		for (int i = 1; i <= a; i++){
			fact = fact * i;
		}

		return fact;
	}

	public void run() {
		b = factorial(a);
		c = b % 2 == 0 ? true : false;
		new String("Factorial value: " + b + (c ? " even" : " odd"));
	}
}
