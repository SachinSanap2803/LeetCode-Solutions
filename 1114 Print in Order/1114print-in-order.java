// 1) Using Semaphore

import java.util.concurrent.Semaphore;

class Foo {
    private Semaphore s1 = new Semaphore(0);
    private Semaphore s2 = new Semaphore(0);

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        s1.release();    // allow second()
    }

    public void second(Runnable printSecond) throws InterruptedException {
        s1.acquire();     // wait for first()
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        s2.release();     // allow third()
    }

    public void third(Runnable printThird) throws InterruptedException {
        s2.acquire();    // wait for second()
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
} 








// 2) Synchronized + wait/notify

// class Foo {
//     private int turn = 1;

//     public Foo() {
        
//     }

//     public synchronized void first(Runnable printFirst) throws InterruptedException {
//         while(turn != 1) {
//             wait();
//         }
//         // printFirst.run() outputs "first". Do not change or remove this line.
//         printFirst.run();
//         turn = 2;
//         notifyAll();
//     }

//     public synchronized void second(Runnable printSecond) throws InterruptedException {
//         while(turn != 2) {
//             wait();
//         }
//         // printSecond.run() outputs "second". Do not change or remove this line.
//         printSecond.run();
//         turn = 3;
//         notifyAll();
//     }

//     public synchronized void third(Runnable printThird) throws InterruptedException {
//         while(turn != 3) {
//             wait();
//         }
//         // printThird.run() outputs "third". Do not change or remove this line.
//         printThird.run();
//     }
// } 