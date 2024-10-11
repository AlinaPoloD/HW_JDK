package manypotok.HW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Main {
    private static final int COUNT_PHILOSOPH =5;


    /*В качестве задачи предлагается решить
классическую задачу про обедающих философов
Условие:
● Есть пять философов (потоки), которые могут либо
обедать (выполнение кода) либо размышлять
(ожидание).
● Каждый философ должен пообедать три раза. Каждый
прием пищи длиться 500 миллисекунд
● После каждого приема пищи философ должен
размышлять
● Не должно возникнуть общей блокировки
● Философы не должны есть больше одного раза подряд
*/
    public static void main(String[] args) {


        // Создаем экземпляр DiningPhilosophers и запускаем программу
        Table tableWithPhilosophers = new Table(5);
        tableWithPhilosophers.startEat();



        }
    }

