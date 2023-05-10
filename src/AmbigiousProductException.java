import java.util.List;

public class AmbigiousProductException extends Exception{
    private List<String> products;

    public AmbigiousProductException(List<String> products) {
        this.products = products;
    }
}
