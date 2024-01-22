package labThird;

public class WarehouseExample {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        // Добавляем продукты
        warehouse.addProduct("123", new Warehouse.Product("Apple", 1.5, 100));
        warehouse.addProduct("124", new Warehouse.Product("Banana", 1.2, 150));
        warehouse.addProduct("125", new Warehouse.Product("orange", 2.1, 33));

        // Находим продукт по штрих-коду и выводим информацию
        Warehouse.Product product = warehouse.findProduct("123");
        if (product != null) {
            System.out.println("Product name: " + product.getName());
            System.out.println("Product price: " + product.getPrice());
            System.out.println("Product quantity: " + product.getQuantity());
        } else {
            System.out.println("Product not found!");
        }

        // Удаляем продукт
        warehouse.removeProduct("123");
    }
}
