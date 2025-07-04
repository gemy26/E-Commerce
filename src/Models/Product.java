package Models;

import Models.Strategies.ExpirationStrategy;
import Models.Strategies.ShippingStrategy;

import java.time.LocalDate;

public class Product {
    private final String name;
    private final double price;
    private  int quantity;
    private final ExpirationStrategy expirationStrategy;
    private final ShippingStrategy shippingStrategy;

    public Product(String name, double price, int quantity,
                   ExpirationStrategy expirationStrategy,
                   ShippingStrategy shippingStrategy) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expirationStrategy = expirationStrategy;
        this.shippingStrategy = shippingStrategy;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isExpired() {
        return expirationStrategy.isExpired();
    }

    public LocalDate getExpiryDate() {
        return expirationStrategy.getExpiryDate();
    }

    public boolean requiresShipping() {
        return shippingStrategy.requiresShipping();
    }

    public Double getWeight() {
        return shippingStrategy.getWeight();
    }

    public void reduceQuantity(int quantity) {
        this.quantity -= quantity;
    }


    @Override
    public String toString() {
        return "Models.Product [name=" + name + ", price=" + price + ", quantity=" + quantity + ", expirationStrategy=" + expirationStrategy.getExpiryDate() + ", shippingStrategy=" + shippingStrategy.getWeight() + "]";
    }
}
