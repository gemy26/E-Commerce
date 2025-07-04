package Models.Strategies;

import java.time.LocalDate;

public class NonExpiring implements ExpirationStrategy{

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
