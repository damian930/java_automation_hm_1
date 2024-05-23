import java.util.Objects;

/*public class WaterBottleInCorrect extends WaterBottleCorrect{
    WaterBottleInCorrect(String brand, int volume, String measurementSystem) {
        super(brand, volume, measurementSystem);
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getBrand(), super.getVolume(), super.getMeasurementSystem());
    }
}*/

public class WaterBottleInCorrect {
    private String brand;
    private int volume;
    private final String measurementSystem;

    WaterBottleInCorrect(String brand, int volume, String measurementSystem) {
        this.brand = brand;
        this.volume = volume;
        this.measurementSystem = measurementSystem;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(5) + this.getBrand().charAt(0);
    }

    @Override
    public String toString() {
        return '(' + brand + ", " + volume + ", " + measurementSystem + ')';
    }

    public String getBrand() {
        return this.brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getMeasurementSystem() {
        return this.measurementSystem;
    }
}
