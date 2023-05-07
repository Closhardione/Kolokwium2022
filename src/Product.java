import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class Product {
 private String name;
 private static List<Product> products = new ArrayList<>();

    public Product(String name) {
        this.name=name;
    }
    public String getName() {
        return name;
    }
    public abstract double getPrice(int year, int month);
    public static void clearProducts(){
        products.clear();
    }
    public static void addProducts(Function<Path, Product> function, Path path){
        List<Product> newProducts = null;
        try {
            newProducts = Files.list(path)
                    .map(csvFilePath -> function.apply(csvFilePath))
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        products.addAll(newProducts);

    }

}
