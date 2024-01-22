package labSixth;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class TopWords {
    public static void findTopWordsInFile(String args) {
        // Путь к файлу с текстом
        String filePath = "C:\\Users\\Ванус\\Desktop\\РАБоты\\It and programming\\labs\\ggwp\\src\\labSixth\\список.txt";

        try {
            // Создаем сканнер для чтения файла
            Scanner scanner = new Scanner(new File(filePath));
            // Создаем мапу для подсчета количества слов
            Map<String, Integer> wordCountMap = new HashMap<>();
            while (scanner.hasNext()) {
                // Читаем слово и переводим его в нижний регистр
                String word = scanner.next().toLowerCase();
                // Обновляем количество этого слова в мапе
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
            // Создаем список записей для сортировки
            List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordCountMap.entrySet());
            // Сортируем записи по убыванию количества
            sortedEntries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
            int count = 0;
            for (Map.Entry<String, Integer> entry : sortedEntries) {
                // Выводим топ 10 слов с их количеством
                if (count >= 10) break;
                System.out.println(entry.getKey() + ": " + entry.getValue());
                count++;
            }
            // Закрываем сканнер
            scanner.close();
        } catch (IOException e) {
            // В случае ошибки ввода-вывода выводим стек ошибки
            e.printStackTrace();
        }
    }
}

class Stack<T> {
    private Object[] data;
    private int size;

    public Stack(int capacity) {
        // Инициализация стека с указанной емкостью
        data = new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        // Добавление элемента в стек
        if (size == data.length) {
            // Если стек заполнен, увеличиваем его размер
            Object[] newData = new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        data[size++] = element;
    }

    public T pop() {
        // Удаляет и возвращает верхний элемент стека
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        T element = (T) data[--size];
        data[size] = null; // Убираем ссылку на удаленный элемент
        return element;
    }

    public T peek() {
        // Возвращает верхний элемент без его удаления
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        return (T) data[size - 1];
    }

    public boolean isEmpty() {
        // Проверяет, пуст ли стек
        return size == 0;
    }

    public int size() {
        // Возвращает размер стека
        return size;
    }
}
