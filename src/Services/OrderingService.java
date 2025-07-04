package Services;

import Interfaces.ShippingServiceInterface;
import Models.CartItem;
import Models.Customer;
import Models.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderingService {
    private ShippingService shippingService;

    public OrderingService() {
        this.shippingService = new ShippingService();
    }

    public void checkOut(Customer customer) {
        double cartTotal = customer.getCart().getTotal();

        if(customer.getCart().isEmpty()){
            throw new IllegalArgumentException("Models.Cart is empty");
        }
        List<ShippingServiceInterface> shippableItems = new ArrayList<>();
        for (CartItem item : customer.getCart().getItems()) {
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

        for (CartItem item : customer.getCart().getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }

        System.out.println("** Checkout receipt **");
        for (CartItem item : customer.getCart().getItems()) {
            System.out.printf("%dx %-12s %.0f%n",
                    item.getQuantity(),
                    item.getProduct().getName(),
                    item.getTotalPrice());
        }
        System.out.println("---------------------");
        System.out.printf("Subtotal         %.0f%n", cartTotal);
        System.out.printf("Shipping         %.0f%n", shippingTotal);
        System.out.printf("Amount           %.0f%n", totalAmount);
        System.out.printf("Models.Customer balance after payment: $%.2f%n", customer.getBalance());

        customer.getCart().clear();
    }
}
