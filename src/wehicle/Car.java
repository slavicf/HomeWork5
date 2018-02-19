package wehicle;

public class Car {

    private String productionDate;          // дата производства (неизменна после создания объекта)
    private String engineType;              // тип двигателя
    private double maxSpeed;                // максимальная скорость машины (если она новая)
    private double accelTime;               // время разгона до 100км/ч
    private int maxPassengers;              // пассажировместимость
    private int numPassengers;              // кол-во пассажиров внутри в данный момент
    private double curSpeed;                // текущая скорость
    CarWheel[] wheels = new CarWheel[4];    // массив колес
    CarDoor[] doors = new CarDoor[4];       // массив дверей

    public  Car(String productionDate) {    // Конструктор с датой производства.
        this(productionDate, "empty", 0.0, 0.0, 0, 0, 0.0);
    }

    public  Car(String productionDate, String engineType, double maxSpeed, double accelTime, int maxPassengers, int numPassengers, double curSpeed) {
        this.productionDate = productionDate;
        this.engineType = engineType;
        this.maxSpeed = maxSpeed;
        this.accelTime = accelTime;
        this.maxPassengers = maxPassengers;
        this.numPassengers = numPassengers;
        this.curSpeed = curSpeed;
        for (int i = 0; i < wheels.length; i++) {
            wheels[i] = new CarWheel();
        }
        for (int i = 0; i < doors.length; i++) {
            doors[i] = new CarDoor();
        }
    } // Конструктор со всеми полями, кроме массива колес и массива дверей.

    public void setSpeed(double speed) {
        curSpeed = speed;
        if (curSpeed > maxSpeed) curSpeed = maxSpeed;
    } // Изменить текущую скорость

    public void incPassengers() {
        if (numPassengers < maxPassengers) numPassengers++;
    } // Посадить 1 пассажира в машину

    public void decPassengers() {
        if (numPassengers > 0) numPassengers--;
    } // Высадить 1 пассажира

    public void outAllPassengers() {
        numPassengers = 0;
    } // Высадить всех пассажиров

    public CarDoor getDoor(int index) {
        return this.doors[index];
    } // Получить дверь по индексу

    public CarWheel getWheel(int index) {
        return this.wheels[index];
    } // Получить колесо по индексу

    public void removeAllWheels() {
        wheels = new CarWheel[0];
    } // Снять все колеса с машины

    public void addWheels(int numWheels) {
        CarWheel[] temp = new CarWheel[wheels.length + numWheels];
        for (int i = 0; i < temp.length; i++) {
            if (i < wheels.length) {
                temp[i] = wheels[i];
            } else {
                temp[i] = new CarWheel(1.0);
            }
        }
        wheels = temp;
    } // Установить на машину X новых колес

    public double computeMaxSpeed() {
        if (numPassengers == 0) return 0.0; // Максимальная скорость равна 0 если в машине нет ни одного пассажира, так как некому ее вести
        double temp = 1.0;
        for (int i = 0; i < wheels.length; i++) {
            if (temp > wheels[i].state()) temp = wheels[i].state();
        }
        return maxSpeed * temp;             // Максимальная скорость новой машины множиться на самое стертое колесо в машине
    } // Вычислить текущую возможную максимальную скорость

    public void show() {
        System.out.println("\nДата производства: " + productionDate);
        System.out.println("Тип двигателя: " + engineType);
        System.out.println("Максимальная скорость машины: " + maxSpeed);
        System.out.println("Время разгона до 100км/ч: " + accelTime);
        System.out.println("Пассажировместимость: " + maxPassengers);
        System.out.println("К-во пассажиров внутри в данный момент: " + numPassengers);
        System.out.println("Текущая скорость: " + curSpeed + "\n");

        for (int i = 0; i < wheels.length; i++) {
            System.out.print("Колесо " + i + ": ");
            wheels[i].show();
        } // Вывод состояния колёс
        System.out.println();

        for (int i = 0; i < doors.length; i++) {
            System.out.print("Дверь " + i + ": ");
            doors[i].show();
        } // Вывод состояния дверей

        System.out.println("Максимальная скорость:" + computeMaxSpeed());  // вычисленная максимальную скорость в зависимости от целостности колес и наличия водителя

    } // Вывести в консоль данные об объекте

    public static void main(String[] args) {
        Car car1 = new Car("1.01.1980", "Jet engine", 500.0, 0.5, 5, 1, 0.0);
        for (int i = 0; i < car1.wheels.length; i++) {
            car1.wheels[i].newWheel();
        }
        car1.wheels[3].wear(33.0);
//        car1.decPassengers();
        car1.show();
    }
}
