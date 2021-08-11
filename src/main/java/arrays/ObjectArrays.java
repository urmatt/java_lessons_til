package arrays;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ObjectArrays {

    static Category smartphone = new Category("Smartphone");
    static Category monitor = new Category("Monitor");
    static Category cpu = new Category("CPU");

    static Product[] products = new Product[]{
            new Product(1000, "Apple", "iPhone 12 mini", smartphone),
            new Product(1100, "Apple", "iPhone 12", smartphone),
            new Product(1200, "Apple", "iPhone 12 Pro", smartphone),
            new Product(700, "Xiaomi", "Mi 12 Lite", smartphone),
            new Product(800, "Xiaomi", "Mi 12", smartphone),
            new Product(990, "Xiaomi", "Mi 12 Pro", smartphone),
            new Product(800, "Samsung", "A10 a", smartphone),
            new Product(900, "Samsung", "A10 b", smartphone),
            new Product(970, "Samsung", "A10 c", smartphone),
            new Product(400, "Samsung", "X10", monitor),
            new Product(550, "Samsung", "Y20", monitor),
            new Product(350, "Intel", "Core i5", cpu),
            new Product(420, "AMD", "Radeon X", cpu),
    };

    public static void main(String[] args) {
        for (Product pr : products) {
            printProductInfo(pr);
        }

        Map<Category, List<Product>> categorised = new HashMap<>();

        for (Product prod :
                products) {
            if (categorised.get(prod.category) == null)
                categorised.put(prod.category, new ArrayList<>());

        }

        /* TODO:
         {
            Category : [Product, ...]
         }

         Заполнить Map "categorised" продуктами
         */
    }

    private static int sumOfProductFor(String owner) {
        int a = 0;
        for (Product pro : products) {
            if (owner.equals(pro.owner)) {
                a += pro.price;
            }
        }
        return a;
    }

    /**
     * Поиск по совпадению начала имени
     *
     * @param name
     * @return
     */
    private static List<Product> searchByName(String name) {
        List<Product> findName = new ArrayList<>();
        for (Product prod : products) {
            if (prod.name.startsWith(name)) {
                findName.add(prod);
            }
        }
        return findName;
    }

    private static List<Product> searchInPrice(int fromPrice, int toPrice) {//from 900 to 1000
        List<Product> findProducts = new ArrayList<>();
        for (Product product : products) {
            // 990
            //        900 <= 990           &&    1000 >= 990
            if (fromPrice <= product.price && toPrice >= product.price) {
                findProducts.add(product);
            }
        }
        return findProducts;
    }

    private static void printProductInfo(Product product) {
        if (product != null) {
            System.out.println("Product name: " + product.name);
            System.out.println("owner: " + product.owner);
            System.out.println("price: " + product.price);
            System.out.println("Category: " + product.category.name);
            System.out.println("---------------------------");
        } else {
            System.out.println("Product is null");
        }
    }

    static class Category {
        String name;

        Category(String name) {
            this.name = name;
        }
    }

    static class Product {
        int price;
        String owner;
        String name;
        Category category;

        Product(int price, String owner, String name, Category category) {
            this.price = price;
            this.owner = owner;
            this.name = name;
            this.category = category;
        }
    }
}
