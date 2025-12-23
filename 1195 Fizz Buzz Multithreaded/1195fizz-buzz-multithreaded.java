// 1) Using Semaphore

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    private int curr = 1;

    private Semaphore num = new Semaphore(1);
    private Semaphore fizz = new Semaphore(0);
    private Semaphore buzz = new Semaphore(0);
    private Semaphore fizzbuzz = new Semaphore(0);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(true) {
            fizz.acquire();
            if(curr > n) break;

            printFizz.run();
            curr++;
            releaseNext();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(true) {
            buzz.acquire();
            if(curr > n) break;

            printBuzz.run();
            curr++;
            releaseNext();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(true) {
            fizzbuzz.acquire();
            if(curr > n) break;

            printFizzBuzz.run();
            curr++;
            releaseNext();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(true) {
            num.acquire();
            if(curr > n) break;

            if(curr % 3 == 0 && curr % 5 == 0) {
                fizzbuzz.release();
            } else if(curr % 3 == 0) {
                fizz.release();
            } else if(curr % 5 == 0) {
                buzz.release();
            } else {
                printNumber.accept(curr);
                curr++;
                releaseNext();
            }
        }
    }

    private void releaseNext() {
        if(curr > n) {
            fizz.release();
            buzz.release();
            fizzbuzz.release();
            num.release();
        } else if(curr % 3 == 0 && curr % 5 == 0) {
            fizzbuzz.release();
        } else if(curr % 3 == 0) {
            fizz.release();
        } else if(curr % 5 == 0) {
            buzz.release();
        } else {
            num.release();
        }
    }
} 






// 2) Using Mutex + wait/notify

// class FizzBuzz {
//     private int n;
//     private int i = 1;

//     public FizzBuzz(int n) {
//         this.n = n;
//     }

//     // printFizz.run() outputs "fizz".
//     public synchronized void fizz(Runnable printFizz) throws InterruptedException {
//         while(i <= n) {
//             while(i <= n && !(i % 3 == 0 && i % 5 != 0)) {
//                 wait();
//             }
//             if(i > n) return;

//             printFizz.run();
//             i++;
//             notifyAll();
//         }
//     }

//     // printBuzz.run() outputs "buzz".
//     public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
//         while(i <= n) {
//             while(i <= n && !(i % 3 != 0 && i % 5 == 0)) {
//                 wait();
//             }
//             if(i > n) return;

//             printBuzz.run();
//             i++;
//             notifyAll();
//         }
//     }

//     // printFizzBuzz.run() outputs "fizzbuzz".
//     public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
//         while(i <= n) {
//             while(i <= n && !(i % 3 == 0 && i % 5 == 0)) {
//                 wait();
//             }
//             if(i > n) return;

//             printFizzBuzz.run();
//             i++;
//             notifyAll();
//         }
//     }

//     // printNumber.accept(x) outputs "x", where x is an integer.
//     public synchronized void number(IntConsumer printNumber) throws InterruptedException {
//         while(i <= n) {
//             while(i <= n && !(i % 3 != 0 && i % 5 != 0)) {
//                 wait();
//             }
//             if(i > n) return;

//             printNumber.accept(i);
//             i++;
//             notifyAll();
//         }
//     }
// } 