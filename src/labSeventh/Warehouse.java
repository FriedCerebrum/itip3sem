package labSeventh;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Warehouse {
    private static final int MAX_WEIGHT = 150; // Максимальный допустимый вес на складе
    private int currentWeight = 0; // Текущий вес на складе
    private final Lock lock = new ReentrantLock(); // Создание объекта блокировки
    private final Condition condition = lock.newCondition(); // Создание условия для синхронизации потоков

    public static void main(String[] args)
    {
        Warehouse transfer = new Warehouse();
        transfer.startTransfer();
    }

    public void startTransfer()
    {
        for (int i = 1; i <= 3; i++)
        {
            new Thread(new Loader("Грузчик " + i), "Loader-" + i).start(); // Запуск трех грузчиков в отдельных потоках
        }
    }

    class Loader implements Runnable
    {
        private String name;

        public Loader(String name) {
            this.name = name;
        }


        public void run()
        {
            try
            {
                while (!Thread.currentThread().isInterrupted())
                {
                    int itemWeight = getRandomWeight(); // Генерация случайного веса товара
                    lock.lock(); // Захват блокировки
                    try
                    {
                        while (currentWeight + itemWeight > MAX_WEIGHT)
                        {
                            condition.await(); // Грузчик ждет, если превышен максимальный вес
                        }
                        currentWeight += itemWeight;
                        System.out.println(name + " добавил товар весом " + itemWeight + " кг. Текущий вес: " + currentWeight);

                        if (currentWeight == MAX_WEIGHT)
                        {
                            System.out.println(name + " завершил загрузку. Ожидание других грузчиков...");
                            deliverGoods(); // Грузчик уведомляет о завершении загрузки и сбрасывает вес
                        }
                    }
                    finally
                    {
                        lock.unlock(); // Освобождение блокировки
                    }
                }
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
                System.out.println(name + " был прерван.");
            }
        }

        private void deliverGoods() throws InterruptedException
        {
            lock.lock(); // Захват блокировки
            try
            {
                currentWeight = 0; // Сброс текущего веса
                condition.signalAll(); // Уведомление ожидающих грузчиков
            } finally
            {
                lock.unlock(); // Освобождение блокировки
            }
        }

        private int getRandomWeight() {
            // Максимально возможный вес, который может быть добавлен, без превышения лимита
            int maxPossibleWeight = MAX_WEIGHT - currentWeight;
            // Генерация случайного веса от 1 до maxPossibleWeight
            return (int) (Math.random() * maxPossibleWeight) + 1;
        }

    }
}
