package labFourth;
// Импорт необходимых библиотек
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// Главный класс программы
public class Main {
    public static void main(String[] args) {
        // Создание объекта пользовательского стека
        CustomStack<Integer> stack = new CustomStack<>();

        try {
            // Добавление элементов в стек
            stack.push(1);
            stack.push(2);
            stack.push(3);

            // Извлечение и вывод элементов из стека
            System.out.println("Pop: " + stack.pop());
            System.out.println("Pop: " + stack.pop());
            System.out.println("Pop: " + stack.pop());

            // Эта строка вызовет исключение, так как стек уже пуст

            System.out.println("Pop: " + stack.pop());



        } catch (CustomEmptyStackException e) {
            // Обработка исключения пустого стека
            System.out.println(e.getMessage());
            // Логирование исключения
            ExceptionLogger.logException(e);
        }
    }
}

// Класс для логирования исключений
class ExceptionLogger {
    public static void logException(Exception e) {
        try (FileWriter writer = new FileWriter("C:\\Users\\Ванус\\Desktop\\РАБоты\\It and programming\\labs\\ggwp\\src\\labFourth\\exceptions.log", true)) {
            writer.write(e.toString() + "\n");
        } catch (IOException ioException) {
            System.out.println("Не удалось записать лог: " + ioException.getMessage());
            ioException.printStackTrace();  // Добавлен вывод стектрейса для диагностики
        }
    }
}



// Класс, реализующий пользовательский стек
class CustomStack<T> {
    // Используем ArrayList для хранения элементов стека
    private ArrayList<T> stack = new ArrayList<>();

    // Метод для добавления элемента в стек
    public void push(T item) {
        stack.add(item);
    }

    // Метод для извлечения элемента из стека
    public T pop() throws CustomEmptyStackException {
        // Проверка на пустоту стека
        if (stack.isEmpty()) {
            throw new CustomEmptyStackException("Стек пуст");
        }
        // Извлечение элемента
        return stack.remove(stack.size() - 1);
    }
}

// Пользовательское исключение для случая пустого стека
class CustomEmptyStackException extends Exception {
    public CustomEmptyStackException(String message) {
        super(message);
    }
}




