public class Demo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread t1 = new Thread(myThread);
        Thread t2 = new Thread(myThread);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}

class MyThread implements Runnable {
    private int i=1;
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                //记得唤醒t1线程
                //t2线程执行过程中把t1唤醒了，但是由于t2仍然占用对象锁，所以即使t1醒了，也不会往下执行。
                this.notify();
                if(i>100) {break;}
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " "+i++);
                try {
                    //让其中一个线程等待，这个线程可能是t1，也可能是t2
                    //假设t1线程等待
                    //t1线程进入无限等待状态，并且等待的时候，不占对象锁
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
