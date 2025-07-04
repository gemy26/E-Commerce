import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShippingService{
    private final double SHIPPING_PER_KG = 2.0;
    private final double BASE_FEE = 5.0;

    public double calculateFee(List<ShippingServiceInterface> shippableItems) {
        double totalFee = BASE_FEE;
        double totalWeight = 0;
        for (ShippingServiceInterface item : shippableItems) {
            totalWeight += item.getWeight();
        }
        totalFee += (totalWeight * SHIPPING_PER_KG);
        return totalFee;
    }

}
