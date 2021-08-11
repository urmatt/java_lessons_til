package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ObjectArrays {
    static Product[] products = new Product[]{
            new Product(1000, "Apple", "iPhone 12 mini"),
            new Product(1100, "Apple", "iPhone 12"),
            new Product(1200, "Apple", "iPhone 12 Pro"),
            new Product(700, "Xiaomi", "Mi 12 Lite"),
            new Product(800, "Xiaomi", "Mi 12"),
            new Product(990, "Xiaomi", "Mi 12 Pro"),
            new Product(800, "Samsung", "A10 a"),
            new Product(900, "Samsung", "A10 b"),
            new Product(970, "Samsung", "A10 c"),
    };

    public static void main(String[] args) {
//        System.out.println("Samsung: " + sumOfProductFor("Samsung"));
//        System.out.println("Xiaomi: " + sumOfProductFor("Xiaomi"));
//        System.out.println("Apple: " + sumOfProductFor("Apple"));
//
        List<Product> nameProducts = searchByName("M");
            for (Product pr : nameProducts) {
                printProductInfo(pr);
            }

//        List<Product> findProd = searchInPrice(900, 1100);
//        for (Product pr : findProd) {
//            printProductInfo(pr);
//        }
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
            if (fromPrice <= product.price && toPrice >= product.price){
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
        } else {
            System.out.println("Product is null");
        }
    }

    static class Product {
        int price;
        String owner;
        String name;

        Product(int price, String owner, String name) {
            this.price = price;
            this.owner = owner;
            this.name = name;
        }
    }
}
