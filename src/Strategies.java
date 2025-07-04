import java.time.LocalDate;

interface ExpirationStrategy {
    boolean isExpired();
    LocalDate getExpiryDate();
}

interface ShippingStrategy {
    boolean requiresShipping();
    double getWeight();
}

class NonExpiring implements ExpirationStrategy {

    @Override
    public boolean isExpired()
    {
        return false;
    }

    @Override
    public LocalDate getExpiryDate()
    {
        return null;
    }
}

class Expiring implements ExpirationStrategy {
    private final LocalDate expiryDate;

    public Expiring(LocalDate expiryDate)
    {
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean isExpired()
    {
        return LocalDate.now().isAfter(expiryDate);
    }

    @Override
    public LocalDate getExpiryDate()
    {
        return expiryDate;
    }
}

class NonShippable implements ShippingStrategy {

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

class Shippable implements ShippingStrategy {
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