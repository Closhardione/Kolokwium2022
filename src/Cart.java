import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static class MultipleProducts{
        public final Product product;
        public final int amount;

        public MultipleProducts(Product product, int amount) {
            this.product = product;
            this.amount = amount;
        }

    }
    public List<MultipleProducts> products= new ArrayList<>();
    public void addProduct(Product product, int amount){
        products.add(new MultipleProducts(product,amount));
    }
    public double getPrice(int year, int month){
        double totalPrice=0;
        for(var multipleProduct : products){
            totalPrice+=(multipleProduct.product.getPrice(year, month)*multipleProduct.amount);
        }
        return totalPrice;
    }
    public double getInflation(int year1, int month1, int year2, int month2){
        double price1 = getPrice(year1,month1);
        double price2 = getPrice(year2, month2);
        if(Product.priceIndex(year1,month1)<Product.priceIndex(year2,month2)){
            int months = ((year2-year1)*12 +(month2-month1));
            return (price2 - price1) / price1 * 100 / months * 12;
        }
        else {
            int months = ((year2-year1)*12 +(month2-month1));
            return (price1-price2)/price2 *100/months*12;
        }
    }
}
