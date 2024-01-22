package labFifth;
import java.util.regex.*;

public class WordFinder {
    public static void main(String[] args) {
        // Исходный текст, в котором мы будем искать слова, начинающиеся с заданной буквы.
        String text = "Hello world! This is a test.";

        // Буква, с которой начинаются искомые слова.
        String letter = "T";

        // Используем регулярное выражение для поиска слов, начинающихся с заданной буквы.
        String regex = "\\b" + letter + "\\w*\\b";

        // Извлекаем и выводим все найденные слова в тексте.
        findAndPrintWords(text, regex);
    }

    // Метод для поиска и вывода всех найденных слов, начинающихся с заданной буквы.
    private static void findAndPrintWords(String text, String regex) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            // matcher.group() возвращает найденное слово как строку.
            System.out.println(matcher.group());
        }
    }
}
