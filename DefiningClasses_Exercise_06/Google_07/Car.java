package Google_07;

public class Car {
    private String carModel;

    private int carSpeed;

    public Car(String carModel, int carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getCarSpeed() {
        return carSpeed;
    }

    @Override
    public String toString() {
        return getCarModel() + " " + getCarSpeed();
    }
}
