package chap14;

public class ThreadDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    while(true) {
                        Thread.sleep(1);
                        System.out.println("hello thread1");
                    }
                } catch(InterruptedException ex) {

                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    while(true) {
                        Thread.sleep(1);
                        System.out.println("goodbye thread2");
                    }
                } catch(InterruptedException ex) {
                    
                }
            }
        });

        t1.start();
        t2.start();
    }
}
