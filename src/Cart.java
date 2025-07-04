import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void add(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be more than 0");
        }

        if (product.getQuantity() < quantity) {
            throw new IllegalArgumentException("Insufficient quantity");
        }

        if (product.isExpired()) {
            throw new IllegalArgumentException("Product is expired");
        }

        for (CartItem item : items) {
            if (item.getProduct().equals(product)) {
                int newQuantity = item.getQuantity() + quantity;
                if (product.getQuantity() < newQuantity) {
                    throw new IllegalArgumentException("Insufficient quantity");
                }
                items.remove(item);
                items.add(new CartItem(product, newQuantity));
                return;
            }
        }

        items.add(new CartItem(product, quantity));
    }


    public List<CartItem> getItems() {
        return new ArrayList<>(items);
    }

    public double getTotal() {
        double CartTotal = 0;
        for (CartItem item : items) {
            CartTotal += item.getProduct().getPrice() * item.getQuantity();
        }
        return CartTotal;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }
}
