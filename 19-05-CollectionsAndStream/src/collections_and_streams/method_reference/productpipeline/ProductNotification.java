package collections_and_streams.method_reference.productpipeline;

public class ProductNotification {

    private int id;
    private String message;

    public ProductNotification(int id, String message) {
        this.id = id;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Sending Notification => Product ID: " + id
                + " | " + message;
    }
}
