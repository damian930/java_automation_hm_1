import java.util.Objects;

public class WaterBottleInCorrect extends WaterBottleCorrect{
    WaterBottleInCorrect(String brand, int volume, String measurementSystem) {
        super(brand, volume, measurementSystem);
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public int hashCode() {
        return super.getBrand().charAt(0);
    }
}

