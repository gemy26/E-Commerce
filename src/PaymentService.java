import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PaymentService {
    private ShippingService shippingService;

    public PaymentService() {
        this.shippingService = new ShippingService();
    }

    public void checkOut(Customer customer, Cart cart) {
        double cartTotal = cart.getTotal();

        List<ShippingServiceInterface> shippableItems = new ArrayList<>();
        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            if (product.requiresShipping()) {
                for (int i = 0; i < item.getQuantity(); i++) {
                    shippableItems.add(new ShippingServiceInterface() {
                        @Override
                        public String getName() { return product.getName(); }
                        @Override
                        public double getWeight() { return product.getWeight(); }
                    });
                }
            }
        }

        double shippingTotal = shippingService.calculateFee(shippableItems);

        double totalAmount = cartTotal + shippingTotal;

        if (customer.getBalance() < totalAmount) {
            throw new IllegalArgumentException("Insufficient balance. Required: $" + totalAmount +
                    ", Available: $" + customer.getBalance());
        }


        customer.reduceBalance(totalAmount);

        for (CartItem item : cart.getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %-12s %.0f%n",
                    item.getQuantity(),
                    item.getProduct().getName(),
                    item.getTotalPrice());
        }
        System.out.println("---------------------");
        System.out.printf("Subtotal         %.0f%n", cartTotal);
        System.out.printf("Shipping         %.0f%n", shippingTotal);
        System.out.printf("Amount           %.0f%n", totalAmount);
        System.out.printf("Customer balance after payment: $%.2f%n", customer.getBalance());

        cart.clear();
    }
}
