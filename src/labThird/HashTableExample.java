package labThird;

public class HashTableExample {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>();
        //Внесём
        hashTable.put("One", 1);
        hashTable.put("Two", 2);
        hashTable.put("Three", 3);
        //Узнаем размер
        System.out.println("Size: " + hashTable.size());
        //Запросим
        System.out.println("Value for 'Two': " + hashTable.get("Two"));
        //Удалим
        hashTable.remove("Two");
        //Запросим после удаления.Узнаем размер
        System.out.println("Value for 'Two': " + hashTable.get("Two"));
        System.out.println("Size: " + hashTable.size());
    }
}

