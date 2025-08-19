package collections_and_streams.method_reference.productpipeline;

public class DiscountService {
    public Product applyDiscount(Product product) {
        double discountedPrice = product.getPrice() * 0.85;
        return new Product(
                product.getId(),
                product.getName(),
                discountedPrice,
                product.getCategory()
        );
    }
}
