import java.nio.file.Path;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Product.addProducts(FoodProduct::fromCsv, Path.of("data/food"));
        Product.addProducts(NonFoodProduct::fromCsv,Path.of("data/nonfood"));
        try {
            Product p1 = Product.getProduct("Bu");
            System.out.println(p1.getPrice(2012, 5));
            Cart cart = new Cart();
            cart.addProduct(Product.getProduct("Benzyna"),100);
            cart.addProduct(Product.getProduct("Jabłka"),20);
            cart.addProduct(Product.getProduct("Wizyta u lekarza"), 2);
            System.out.println(cart.getInflation(2020,1,2022,3));
            System.out.println(cart.getPrice(2022,3));
        } catch (AmbigiousProductException | IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }
}