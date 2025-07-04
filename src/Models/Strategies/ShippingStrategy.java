package Models.Strategies;

public interface ShippingStrategy {
    boolean requiresShipping();
    double getWeight();
}
