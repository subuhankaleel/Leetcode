import java.util.concurrent.Semaphore;

class DiningPhilosophers {
    
    // Five semaphores, one for each fork (1 means available)
    private final Semaphore[] forks = new Semaphore[5];
    // Limit the number of philosophers trying to pick up forks at the same time to 4
    private final Semaphore tableLimit = new Semaphore(4);

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new Semaphore(1);
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        
        int leftForkIndex = philosopher;
        int rightForkIndex = (philosopher + 1) % 5;
        
        // 1. Only allow up to 4 philosophers to attempt to grab forks simultaneously
        tableLimit.acquire();
        
        // 2. Lock both forks
        forks[leftForkIndex].acquire();
        forks[rightForkIndex].acquire();
        
        // 3. Perform actions
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        
        // 4. Release both forks
        forks[leftForkIndex].release();
        forks[rightForkIndex].release();
        
        // 5. Leave the table, allowing another philosopher to try
        tableLimit.release();
    }
}
