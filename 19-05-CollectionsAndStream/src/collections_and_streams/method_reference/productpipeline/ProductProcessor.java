package collections_and_streams.method_reference.productpipeline;

import java.util.Arrays;
import java.util.List;

public class ProductProcessor {
    public void sendNotification(ProductNotification notification) {
        System.out.println(notification);
    }

    public static void main(String[] args) {

        List<Product> products = Arrays.asList(
                new Product(101, "iPhone", 85000, "ELECTRONICS"),
                new Product(102, "LED TV", 45000, "ELECTRONICS"),
                new Product(103, "Shoes", 5000, "FASHION"),
                new Product(104, "Refrigerator", 39000, "ELECTRONICS"),
                new Product(105, "Book", 1200, "STATIONERY"),
                new Product(106, "Laptop", 92000, "ELECTRONICS")
        );

        DiscountService discountService = new DiscountService();
        ProductProcessor processor = new ProductProcessor();

        products.stream()
                .filter(ProductUtils::isValid)
                .sorted(ProductUtils::compareByPrice)
                .map(discountService::applyDiscount)
                .map(p ->
                        new ProductNotification(p.getId(),
                                "Price dropped for ELECTRONICS product!"))
                .forEach(processor::sendNotification);
    }
}
