public abstract class Product {
 private String name;

    public String getName() {
        return name;
    }
    public abstract double getPrice(int year, int month);
}
