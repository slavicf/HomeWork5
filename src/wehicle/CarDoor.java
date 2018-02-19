package wehicle;

public class CarDoor {              // На прямую к переменным этого класса никто не может, только через методы

    private boolean doorState;   // состояние двери(открыта/закрыта)
    private boolean windowState; // состояние окна (открыто/закрыто)

    public CarDoor() {
        this(false, false);
    }   // должен присвоить переменным значения на случай если данных нет

    public CarDoor(boolean door, boolean window) {
        doorState = door;
        windowState = window;
    } // принимает оба состояния, двери и окна и присваивает эти значения переменным внутри объекта

    public void openDoor() {
        if (!doorState) toggleDoor();
    } // открыть дверь

    public void closeDoor() {
        if (doorState) toggleDoor();
    } // закрыть дверь

    public void toggleDoor() {
        doorState = !doorState;
    } // открыть/закрыть дверь

    public void openWindow() {
        if (!windowState) toggleWindow();
    } // открыть окно

    public void closeWindow() {
        if (windowState) toggleWindow();
    } // закрыть окно

    public void toggleWindow() {
        windowState = !windowState;
    } // открыть/закрыть окно

    public void show() {
        System.out.println("CarDoor state");
        System.out.println("Car door - " + (doorState ? "opened" : "closed"));
        System.out.println("Car window - " + (windowState ? "opened" : "closed\n"));
    } // Вывести в консоль данные об объекте
}
