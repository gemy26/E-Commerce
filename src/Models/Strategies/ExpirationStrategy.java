package Models.Strategies;

import java.time.LocalDate;

public interface ExpirationStrategy {
    boolean isExpired();
    LocalDate getExpiryDate();
}
