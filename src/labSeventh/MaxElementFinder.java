package labSeventh;

import java.util.ArrayList;
import java.util.List;

public class MaxElementFinder {
    private int[][] matrix;
    private List<Integer> maxElements;

    public MaxElementFinder(int[][] matrix) {
        this.matrix = matrix;
        this.maxElements = new ArrayList<>();  //constructor
    }

    public static void main(String[] args)
    {
        int[][] matrix = {
                {1, 3, 5},
                {7, 9, 90},
                {13, 15, 17}
        };
        MaxElementFinder finder = new MaxElementFinder(matrix);
        finder.findMaxElement();
    }

    public void findMaxElement()
    {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++)
        {
            final int row = i;
            Thread thread = new Thread(() ->
            {
                int maxInRow = findMaxInRow(row);
                synchronized (maxElements)
                {
                    maxElements.add(maxInRow);
                }
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads)
        {
            try
            {
                thread.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        int maxElement = maxElements.stream().max(Integer::compareTo).orElse(Integer.MIN_VALUE);       //-2**31
        System.out.println("Maximum element in the matrix is: " + maxElement);
    }

    private int findMaxInRow(int row)
    {
        int max = matrix[row][0];
        for (int i = 1; i < matrix[row].length; i++)
        {
            if (matrix[row][i] > max)
            {
                max = matrix[row][i];
            }
        }
        return max;
    }
}
