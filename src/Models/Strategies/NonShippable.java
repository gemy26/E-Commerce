package Models.Strategies;

public class NonShippable implements ShippingStrategy {

    @Override
    public boolean requiresShipping()
    {
        return false;
    }

    @Override
    public double getWeight()
    {
        return 0.0;
    }
}