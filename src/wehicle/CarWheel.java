package wehicle;

public class CarWheel {

    private double wearOut;             // Состояние целостности шины (дробное число от 0-стерта до 1-новая)

    public CarWheel() {
        this(0.0);
    } // должен присвоить переменным значения на случай если данных нет

    public CarWheel(double wearOut) {
        this.wearOut = wearOut;
    } // принимает состояние шины и присваивает это значение переменной внутри объекта

    public void newWheel() {
        wearOut = 1.0;
    } // Сменить шину на новую

    public void wear(double wear) {
        wearOut = wearOut * wear / 100.0;
    } // Стереть шину на X%

    public double state() {
        return wearOut;
    } // Получить состояние (return)

    public void show() {
        System.out.println("Состояние колеса " + wearOut);
    } // Вывести в консоль данные об объекте
}
