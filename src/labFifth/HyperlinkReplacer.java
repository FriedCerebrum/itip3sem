package labFifth;

public class HyperlinkReplacer {
    public static void main(String[] args) {
        // Исходный текст, в котором мы будем заменять ссылки на гиперссылки.
        String text = "Visit my website at https://example.com for more information.";

        // Заменяем все найденные ссылки на гиперссылки в тексте и сохраняем результат в переменную.
        String replacedText = replaceLinksInText(text);

        // Выводим замененный текст на экран.
        System.out.println(replacedText);
    }

    // Метод для замены ссылок на гиперссылки в тексте.
    private static String replaceLinksInText(String text) {
        // Регулярное выражение для поиска ссылок в тексте.
        String regex = "(https?://\\S+)";

        // Заменяем найденные ссылки на гиперссылки в тексте.
        String replacedText = text.replaceAll(regex, "<a href=\"$1\">$1</a>");

        return replacedText;
    }
}
