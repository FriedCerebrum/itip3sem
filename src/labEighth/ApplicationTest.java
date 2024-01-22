package labEighth;

public class ApplicationTest
{
    public static void main(String[] args)
    {
        DataManager dataManager = new DataManager();

        // Загрузка данных из файла
        dataManager.loadData("C:\\Users\\Ванус\\Desktop\\РАБоты\\It and programming\\labs\\ggwp\\src\\labEighth\\Input.txt");

        // Регистрация и применение обработчиков
        DataFilter filter = new DataFilter();
        DataAggregator aggregator = new DataAggregator();


        dataManager.registerDataProcessor(filter);
        dataManager.registerDataProcessor(aggregator);


        dataManager.processData();

        // Сохранение обработанных данных в файл
        dataManager.saveData("C:\\Users\\Ванус\\Desktop\\РАБоты\\It and programming\\labs\\ggwp\\src\\labEighth\\Output.txt");
    }
}

