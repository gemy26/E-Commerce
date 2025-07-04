package Models.Strategies;

public class Shippable implements ShippingStrategy {
    private final double weight;
    public Shippable(double weight) { this.weight = weight; }

    @Override
    public boolean requiresShipping()
    {
        return true;
    }

    @Override
    public double getWeight()
    {
        return weight;
    }
}