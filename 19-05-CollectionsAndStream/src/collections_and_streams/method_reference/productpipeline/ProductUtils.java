package collections_and_streams.method_reference.productpipeline;

public class ProductUtils {
    public static boolean isValid(Product product) {
        return "ELECTRONICS".equalsIgnoreCase(product.getCategory())
                && product.getPrice() > 20000;
    }

    public static int compareByPrice(Product p1, Product p2) {
        return Double.compare(p2.getPrice(), p1.getPrice());
    }
}
