package cms.model.vehicle;

public class Van {
    String reg, make, model;
    int year;
    double odo, serviceInterval;

    String display;

    public Van(String reg, String make, String model, int year, double odo, double serviceInterval) {
        this.reg = reg;
        this.make = make;
        this.model = model;
        this.year = year;
        this.odo = odo;
        this.serviceInterval = serviceInterval;
    }

    public String toString(){
        display = "Van: Reg_Number: " + reg + ", Make: " + make + ", Model: " + model + ", Year: " + year + "\nOdometer: " + odo + "km, Last Service: 0.00km, Service Interval: " + serviceInterval;
        return display;
    }
}
