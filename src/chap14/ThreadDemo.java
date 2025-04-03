package chap14;

public class ThreadDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                while(true)
                    System.out.println("hello thread1");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                while(true)
                    System.out.println("goodbye thread2");
            }
        });

        t1.start();
        t2.start();
    }
}
