package labEighth;

public class DataAggregator {

    @DataProcessor
    public void aggregateMethod(DataManager dataManager) {
        long count = dataManager.getData().stream()
                .filter(line -> line.contains("boba")) // Здесь можно указать критерий для фильтрации
                .count();
        System.out.println("Количество строк отвечающих критерию: " + count);
    }
}
