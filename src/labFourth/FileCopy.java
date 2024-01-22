package labFourth;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        // Имена исходного и целевого файлов
        String sourceFile = "C:\\Users\\Ванус\\Desktop\\РАБоты\\It and programming\\labs\\ggwp\\src\\labFourth\\source.txt";
        String destFile = "C:\\Users\\Ванус\\Desktop\\РАБоты\\It and programming\\labs\\ggwp\\src\\labFourth\\destination.txt";

        // Инициализация потоков для чтения и записи файла
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // Открытие потока для чтения исходного файла
            fis = new FileInputStream(sourceFile);

            // Открытие потока для записи в целевой файл
            fos = new FileOutputStream(destFile);

            // Переменная для хранения прочитанных байтов
            int bytesRead;

            // Буфер для хранения данных, которые будут скопированы
            byte[] buffer = new byte[1024];

            // Чтение и копирование данных из исходного файла в целевой
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            // Вывод сообщения об успешной операции
            System.out.println("Файл успешно скопирован");

        } catch (IOException e) {
            // Обработка исключений, связанных с вводом-выводом
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        } finally {
            try {
                // Закрытие потока чтения файла, если он был открыт
                if (fis != null) {
                    fis.close();
                }

                // Закрытие потока записи файла, если он был открыт
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                // Обработка исключений при закрытии файлов
                System.out.println("Ошибка при закрытии файлов: " + e.getMessage());
            }
        }
    }
}

