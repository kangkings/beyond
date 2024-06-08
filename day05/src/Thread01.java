public class Thread01 extends Thread {
    @Override
    public void run() {
        while(true) {
            System.out.println("스레드-01");
        }
    }
}
