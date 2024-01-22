package labFifth;
import java.util.regex.*;

public class PasswordValidator {
    public static void main(String[] args) {
        // Пароль, который мы хотим проверить.
        String password = "Password123";

        // Проверяем пароль на корректность и выводим результат на экран.
        if (isValidPassword(password)) {
            System.out.println("Пароль корректен.");
        } else {
            System.out.println("Пароль некорректен.");
        }
    }

    // Метод для проверки корректности пароля.
    public static boolean isValidPassword(String password) {
        // Регулярное выражение для проверки пароля.
        String regex = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$";

        // Проверяем, соответствует ли пароль заданному регулярному выражению.
        return password.matches(regex);
    }
}
