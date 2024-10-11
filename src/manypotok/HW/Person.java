package manypotok.HW;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Person extends Thread{

    private int id;
    private Semaphore leftFork;
    private Semaphore rightFork;
    private int countEat;


    public Person(int id,Semaphore leftFork, Semaphore rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        countEat = 0;

    }

    @Override
    public void run() {


            try {
                while (countEat < 3) {

                    think();
                    leftFork.acquire();
                    rightFork.acquire();
                    eat();
                    leftFork.release();
                    rightFork.release();


                }
            }
            catch(InterruptedException e){
                    e.printStackTrace();
                }








    }



    private void eat() {
        try {
            Thread.sleep(500);
            ++countEat;
            System.out.println(id + "закончил есть" + countEat + "раз");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        }

    private void think() {
        try {
            Thread.sleep(new Random().nextInt(100,500));
            System.out.println(id + "размышляет");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }
