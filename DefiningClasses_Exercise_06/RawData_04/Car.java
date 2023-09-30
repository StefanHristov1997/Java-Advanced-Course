package RawData_04;

import java.util.LinkedHashMap;

public class Car {

    private String model;
    private Engine engine;

    private Cargo cargo;

    private LinkedHashMap<Double, Integer> tires;


    public Car(String model, Engine engine, Cargo cargo, LinkedHashMap<Double, Integer> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public LinkedHashMap<Double, Integer> getTires() {
        return tires;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return getModel();
    }
}
