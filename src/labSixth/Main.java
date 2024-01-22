package labSixth;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        // Создаем экземпляр класса TopWords и вызываем его метод
        System.out.println("задание 1");
        TopWords topWords = new TopWords();
        topWords.findTopWordsInFile("C:\\Users\\Ванус\\Desktop\\РАБоты\\It and programming\\labs\\ggwp\\src\\labSixth\\список.txt");

        System.out.println("задание 2");

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Верхний элемент стека: " + stack.peek());

        System.out.println("Извлеченные элементы стека:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        stack.push(4);
        stack.push(5);

        System.out.println("Извлеченные элементы стека:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println("задание 3");
        SalesManager manager = new SalesManager();

        Product apple = new Product("Apple", 10.0);
        Product orange = new Product("Orange", 15.0);
        Product banana = new Product("Banana", 7.0);

        manager.addProduct(apple);
        manager.addProduct(orange);
        manager.addProduct(apple);

        manager.printProducts();
        System.out.println("Общая сумма продаж: " + manager.getTotalSales());
        Product mostPopular = manager.getMostPopularProduct();
        if (mostPopular != null) {
            System.out.println("Самый популярный товар: " + mostPopular.getName());
        }
    }
}