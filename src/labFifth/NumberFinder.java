package labFifth;
import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        // Исходный текст, в котором мы будем искать числа.
        String text = "The price of the product is $1999";

        // Используем регулярное выражение для поиска чисел с плавающей точкой в числах, которые есть в строке.
        String regex = "\\d+\\.\\d+";

        // Извлекаем и выводим все найденные числа в тексте.
        findAndPrintNumbers(text, regex);
    }

    // Метод для поиска и вывода всех найденных чисел с плавающей точкой в тексте.
    private static void findAndPrintNumbers(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            // matcher.group() возвращает найденное число как строку.
            System.out.println(matcher.group());
        }
    }
}
