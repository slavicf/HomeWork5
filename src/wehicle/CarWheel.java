package wehicle;

public class CarWheel {

    private double wheelShape;          // Состояние целостности шины (дробное число от 0-стерта до 1-новая)

    public CarWheel() {                 // должен присвоить переменным значения на случай если данных нет
        this(0.0);
    }

    public CarWheel(double wheelShape) {    // принимает состояние шины и присваивает это значение переменной внутри объекта
        this.wheelShape = wheelShape;
    }

    public void changeWheel() {         // Сменить шину на новую
        wheelShape = 1.0;
    }

    public void wearWheel(double wheelWear) {   // Стереть шину на X%
        wheelShape = wheelShape * wheelWear / 100.0;
    }

    public double wheelState() {        // Получить состояние (return)
        return wheelShape;
    }

    public void show() {                // Вывести в консоль данные об объекте
        System.out.println("Wheel state - " + wheelShape);
        System.out.println();
    }
}
