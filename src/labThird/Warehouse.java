package labThird;

import java.util.LinkedList;

public class Warehouse {
    private LinkedList<ProductEntry>[] table; // Массив связанных списков для хранения товаров
    private int size; // Текущий размер склада
    private static final int DEFAULT_CAPACITY = 16; // Начальная емкость массива

    public Warehouse() {
        table = new LinkedList[DEFAULT_CAPACITY]; // Инициализация массива со списками
        size = 0; // Начальный размер склада
    }

    private int hash(String barcode) {
        return barcode.hashCode() % table.length; // Вычисление хеша для штрих-кода
    }

    public void addProduct(String barcode, Product product) {
        int index = hash(barcode); // Вычисление индекса в массиве
        if (table[index] == null) {
            table[index] = new LinkedList<>(); // Создание нового связанного списка, если он не существует
        }
        for (ProductEntry entry : table[index]) {
            if (entry.getBarcode().equals(barcode)) {
                entry.setProduct(product); // Обновление информации о товаре, если он уже существует
                return;
            }
        }
        table[index].add(new ProductEntry(barcode, product)); // Добавление нового товара
        size++; // Увеличение размера склада
    }

    public Product findProduct(String barcode) {
        int index = hash(barcode); // Вычисление индекса в массиве
        if (table[index] != null) {
            for (ProductEntry entry : table[index]) {
                if (entry.getBarcode().equals(barcode)) {
                    return entry.getProduct(); // Поиск товара по штрих-коду
                }
            }
        }
        return null; // Если товар не найден
    }

    public void removeProduct(String barcode) {
        int index = hash(barcode); // Вычисление индекса в массиве
        if (table[index] != null) {
            for (ProductEntry entry : table[index]) {
                if (entry.getBarcode().equals(barcode)) {
                    table[index].remove(entry); // Удаление товара
                    size--; // Уменьшение размера склада
                    return;
                }
            }
        }
    }

    private static class ProductEntry {
        private String barcode;
        private Product product;

        public ProductEntry(String barcode, Product product) {
            this.barcode = barcode;
            this.product = product;
        }

        public String getBarcode() {
            return barcode;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }
    }

    public static class Product {
        private String name;
        private double price;
        private int quantity;

        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
