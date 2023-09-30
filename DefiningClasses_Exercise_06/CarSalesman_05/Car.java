package CarSalesman_05;

public class Car {
    private String model;
    private Engine engine;

    private int weight;

    private String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public Car(String model, Engine engine, int weight) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this.model = model;
        this.engine = engine;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    //"{CarModel}:
//{EngineModel}:
//Power: {EnginePower}
//Displacement: {EngineDisplacement}
//Efficiency: {EngineEfficiency}
//Weight: {CarWeight}
//Color: {CarColor}"
    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();

        print.append(getModel() + ":")
                .append(System.lineSeparator());
        print.append(getEngine().getModel() + ":")
                .append(System.lineSeparator()).
                append("Power: " + getEngine().getPower())
                .append(System.lineSeparator());

        if (getEngine().getDisplacement() != 0) {
            print.append("Displacement: " + getEngine().getDisplacement());
        } else {
            print.append("Displacement: n/a");
        }

        print.append(System.lineSeparator());

        if (engine.getEfficiency() != null) {
            print.append("Efficiency: " + getEngine().getEfficiency());
        } else {
            print.append("Efficiency: n/a");
        }
        print.append(System.lineSeparator());

        if (getWeight() != 0) {
            print.append("Weight: " + getWeight());

        } else {
            print.append("Weight: n/a");
        }

        print.append(System.lineSeparator());

        if (getColor() != null) {
            print.append("Color: " + getColor());
        } else {
            print.append("Color: n/a");
        }

        return print.toString();

    }
}
