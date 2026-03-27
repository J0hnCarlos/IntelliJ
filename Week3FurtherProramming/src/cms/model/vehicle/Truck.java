package cms.model.vehicle;

public class Truck {

    String reg, make, model;
    int year, capacity;
    double odo, serviceInterval;

    public Truck(String reg, String make, String model, int year, double odo, double serviceInterval, int capacity ) {
        this.reg = reg;
        this.make = make;
        this.model = model;
        this.year = year;
        this.capacity = capacity;
        this.odo = odo;
        this.serviceInterval = serviceInterval;
    }
}
