public class Thread02 implements Runnable {

    @Override
    public void run() {
        while(true) {
            System.out.println("스레드-02");
        }
    }
}
