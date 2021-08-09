package arrays;

public class ObjectArrays {
    public static void main(String[] args) {
        Product[] products = new Product[]{
                new Product(1200, "Apple"),
                new Product(700, "Xiaomi"),
                new Product(800, "Samsung"),
        };
    }

    static class Product {
        int price;
        String name;

        Product(int price, String name) {
            this.price = price;
            this.name = name;
        }
    }
}
