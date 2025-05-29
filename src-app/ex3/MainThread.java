package ex3;

public class MainThread extends Thread {


    public MainThread(String name) {
	super(name);
    }

    private void checkAccess(String name) {
	@SuppressWarnings("unused")
	String access = "NOT gratend";
	if (name.equals("APPLICATION THREAD: 6")) {
	    access = "granted";
	}
    }

    public void run() {
	this.checkAccess(this.getName());
    }
}
