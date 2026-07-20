import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private Semaphore zeroSem = new Semaphore(1); // Start with zero permitted
    private Semaphore oddSem = new Semaphore(0);  // Odd starts locked
    private Semaphore evenSem = new Semaphore(0); // Even starts locked

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zeroSem.acquire();
            printNumber.accept(0);
            if (i % 2 == 1) {
                oddSem.release();  // Unblock odd thread
            } else {
                evenSem.release(); // Unblock even thread
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            evenSem.acquire();
            printNumber.accept(i);
            zeroSem.release();    // Unblock zero thread
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            oddSem.acquire();
            printNumber.accept(i);
            zeroSem.release();    // Unblock zero thread
        }
    }
}
