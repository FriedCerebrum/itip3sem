package labEighth;

import java.util.stream.Collectors;

public class DataFilter
{

    @DataProcessor
    public void filterMethod(DataManager dataManager)
    {
        dataManager.setData(dataManager.getData().stream()
                .filter(line -> line.toLowerCase().contains("aboba"))
                .collect(Collectors.toList()));
    }

}
