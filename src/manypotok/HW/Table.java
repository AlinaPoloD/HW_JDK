package manypotok.HW;

import java.util.concurrent.Semaphore;

public class Table{
    private int countPerson;
    private Semaphore[]forks;


    public Table(int countPerson) {
        this.countPerson = countPerson;
        this.forks = new Semaphore[countPerson];
        for (int i = 0; i < countPerson; i++) {
            forks[i] = new Semaphore(1);
        }
    }

    public void startEat() {
        // Создаем и запускаем философов
        Person[] philosophers = new Person[countPerson];
        for (int i = 0; i < countPerson; i++) {
            Semaphore leftFork = forks[i];
            Semaphore rightFork = forks[(i + 1) % countPerson];
            philosophers[i] = new Person(i+1, leftFork, rightFork);
            philosophers[i].start();
        }


        for (int i = 0; i < countPerson; i++) {
            try {
                philosophers[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Все философы завершили обед.");
    }
}
