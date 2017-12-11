package wehicle;

public class CarDoor {              // На прямую к переменным этого класса никто не может, только через методы

    private boolean doorState;   // состояние двери(открыта/закрыта)
    private boolean windowState; // состояние окна (открыто/закрыто)

    public CarDoor() {
        this(false, false);
    }   // должен присвоить переменным значения на случай если данных нет

    public CarDoor(boolean door, boolean window) {          // принимает оба состояния, двери и окна и присваивает эти значения переменным внутри объекта
        doorState = door;
        windowState = window;
    }

    public void openDoor() {    // открыть дверь
        if (!doorState) toggleDoor();
    }

    public void closeDoor() {   // закрыть дверь
        if (doorState) toggleDoor();
    }

    public void toggleDoor() {  // открыть/закрыть дверь
        doorState = !doorState;
    }

    public void openWindow() {    // открыть окно
        if (!windowState) toggleWindow();
    }

    public void closeWindow() {   // закрыть окно
        if (windowState) toggleWindow();
    }

    public void toggleWindow() {  // открыть/закрыть окно
        windowState = !windowState;
    }

    public void show() {
        System.out.println("CarDoor state");
        System.out.println("Car door - " + (doorState ? "opened" : "closed"));
        System.out.println("Car window - " + (windowState ? "opened" : "closed\n"));
    }
}
