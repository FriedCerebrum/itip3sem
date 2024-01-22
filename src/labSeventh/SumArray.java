package labSeventh;

public class SumArray {
    private int[] array;
    private int sum1 = 0;
    private int sum2 = 0;

    public SumArray(int[] array)
    {
        this.array = array;
    }

    public static void main(String[] args)
    {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Пример массива
        SumArray calculator = new SumArray(array);
        calculator.calculateSum();
    }

    public void calculateSum() {
        Thread thread1 = new Thread(() ->
        {
            for (int i = 0; i < array.length / 2; i++)
            {
                sum1 += array[i];
            }
        });

        Thread thread2 = new Thread(() ->
        {
            for (int i = array.length / 2; i < array.length; i++)
            {
                sum2 += array[i];
            }
        });

        thread1.start();
        thread2.start();

        try
        {
            thread1.join();
            thread2.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("Total sum: " + (sum1 + sum2));
    }
}
