package wehicle;

public class Car {

    private String productionDate;  // дата производства (неизменна после создания объекта)
    private String engineType;      // тип двигателя
    private double maxSpeed;        // максимальная скорость машины (если она новая)
    private double accelTime;       // время разгона до 100км/ч
    private int passengersMax;   // пассажировместимость
    private int passengersNum;   // кол-во пассажиров внутри в данный момент
    private double curSpeed;        // текущая скорость
    CarWheel[] wheels = new CarWheel[4];    // массив колес
    CarDoor[] doors = new CarDoor[4];       // массив дверей

    public  Car(String productionDate) {
        this(productionDate, "empty", 0.0, 0.0, 0, 0, 0.0);
    }

    public  Car(String productionDate, String engineType, double maxSpeed, double accelTime, int passengersMax,
                int passengersNum, double curSpeed) {
        this.productionDate = productionDate;
        this.engineType = engineType;
        this.maxSpeed = maxSpeed;
        this.accelTime = accelTime;
        this.passengersMax = passengersMax;
        this.passengersNum = passengersNum;
        this.curSpeed = curSpeed;
    }


}
