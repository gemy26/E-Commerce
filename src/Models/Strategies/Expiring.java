package Models.Strategies;

import java.time.LocalDate;

public class Expiring implements ExpirationStrategy {
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