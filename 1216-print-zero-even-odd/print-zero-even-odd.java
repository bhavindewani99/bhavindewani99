class ZeroEvenOdd {
    private int n;
    private int turn = 0;
    private final Object lock = new Object();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            synchronized (lock) {
                while (turn != 0) {
                    lock.wait(); // Wait until it's zero's turn
                }
                printNumber.accept(0); // Print 0
                turn = (i % 2 == 0) ? 2 : 1; // Switch to even or odd
                lock.notifyAll(); // Notify all waiting threads
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            synchronized (lock) {
                while (turn != 2) {
                    lock.wait(); // Wait until it's even's turn
                }
                printNumber.accept(i); // Print even number
                turn = 0; // Switch to zero's turn
                lock.notifyAll(); // Notify all waiting threads
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            synchronized (lock) {
                while (turn != 1) {
                    lock.wait(); // Wait until it's odd's turn
                }
                printNumber.accept(i); // Print odd number
                turn = 0; // Switch to zero's turn
                lock.notifyAll(); // Notify all waiting threads
            }
        }
    }
}
