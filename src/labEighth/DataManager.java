package labEighth;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.nio.file.Paths;
import java.lang.reflect.Method;

public class DataManager
{
    private List<String> data = new ArrayList<>();
    private List<Object> processors = new ArrayList<>();

    // Регистрация обработчиков данных
    public void registerDataProcessor(Object processor)
    {
        processors.add(processor);
    }

    // Загрузка данных
    public void loadData(String source)
    {
        try
        {
            data = Files.readAllLines(Paths.get(source));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Методы для получения и установки данных
    public List<String> getData()
    {
        return data;
    }

    public void setData(List<String> newData)
    {
        this.data = newData;
    }

    // Обработка данных
    public void processData()
    {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (Object processor : processors)
        {
            for (Method method : processor.getClass().getMethods())
            {
                if (method.isAnnotationPresent(DataProcessor.class))
                {
                    executorService.submit(() ->
                    {
                        try
                        {
                            method.invoke(processor, this);
                        } catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    });
                }
            }
        }

        executorService.shutdown();
        try
        {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    // Сохранение данных
    public void saveData(String destination)
    {
        try
        {
            Files.write(Paths.get(destination), data);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
