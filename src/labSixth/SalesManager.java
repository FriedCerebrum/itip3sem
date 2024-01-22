package labSixth;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SalesManager {
    private Set<Product> products;
    private Map<Product, Integer> productCount;

    public SalesManager() {
        products = new HashSet<>();
        productCount = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        productCount.put(product, productCount.getOrDefault(product, 0) + 1);
    }

    public void printProducts() {
        for (Product product : products) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }
    }

    public double getTotalSales() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice() * productCount.get(product);
        }
        return total;
    }

    public Product getMostPopularProduct() {
        Product mostPopular = null;
        int maxCount = 0;
        for (Map.Entry<Product, Integer> entry : productCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostPopular = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return mostPopular;
    }
}

