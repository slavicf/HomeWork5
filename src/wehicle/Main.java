package wehicle;

import java.util.Scanner;

public class Main {

    static Car car;
    static Scanner scanner = new Scanner(System.in);

    static void passengers() {
        System.out.println("" +
                "1 - Посадить 1 пассажира в машину\n" +
                "2 - Высадить 1 пассажира\n" +
                "3 - Высадить всех пассажиров");
        int action = scanner.nextInt();
        if (action == 1) car.incPassengers();
        else if (action == 2) car.decPassengers();
        else if (action == 3) car.outAllPassengers();
    }

    static void carDoors() {
        System.out.println("Введите индекс двери 0 - " + (car.doors.length - 1));
        int i = scanner.nextInt();
        System.out.println("" +
                "1 - Открыть дверь\n" +
                "2 - Закрыть дверь\n" +
                "3 - Открыть/закрыть дверь\n" +
                "4 - Открыть окно\n" +
                "5 - Закрыть окно\n" +
                "6 - Открыть/закрыть окно\n" +
                "7 - Получить дверь по индексу");
        int action = scanner.nextInt();
        if (action == 1) car.doors[i].openDoor();
        else if (action == 2) car.doors[i].closeDoor();
        else if (action == 3) car.doors[i].toggleDoor();
        else if (action == 4) car.doors[i].openWindow();
        else if (action == 5) car.doors[i].closeWindow();
        else if (action == 6) car.doors[i].toggleWindow();
        else if (action == 7) {
            CarDoor door = car.getDoor(i);
            door.show();
        }
    }

    static void carWheels() {
        System.out.println("Введите индекс колеса 0 - " + (car.wheels.length - 1));
        int i = scanner.nextInt();
        System.out.println("" +
                "1 - Сменить шину на новую\n" +
                "2 - Стереть шину на X%\n" +
                "3 - Получить состояние\n" +
                "4 - Получить колесо по индексу\n" +
                "5 - Снять все колеса с машины\n" +
                "6 - Установить на машину X новых колес");
        int action = scanner.nextInt();
        if (action == 1) car.wheels[i].newWheel();
        else if (action == 2) {
            System.out.println("введите Х:");
            car.wheels[i].wear(scanner.nextInt());
        }
        else if (action == 3) car.wheels[i].show();
        else if (action == 4) {
            CarWheel wheel = car.getWheel(i);
            wheel.show();
        }
        else if (action == 5) car.removeAllWheels();
        else if (action == 6) {
            System.out.println("введите Х:");
            car.addWheels(scanner.nextInt());
        }
    }

    public static void main(String[] args) {
        System.out.println("Введите параметры автомобиля:");
        System.out.print("Дата производства: ");
        String production = scanner.nextLine();
        System.out.print("Тип двигателя: ");
        String engine = scanner.nextLine();
        System.out.print("Максимальная скорость машины: ");
        int maxSpeed = scanner.nextInt();
        System.out.print("Время разгона до 100км/ч: ");
        int acceleration = scanner.nextInt();
        System.out.print("Пассажировместимость: ");
        int maxPassengers = scanner.nextInt();
        System.out.print("К-во пассажиров внутри в данный момент: ");
        int curPassengers = scanner.nextInt();
        System.out.print("Текущая скорость: ");
        int curSpeed = scanner.nextInt();

        car = new Car(production, engine, maxSpeed, acceleration, maxPassengers, curPassengers, curSpeed);

        do {
            System.out.println("\nВведите индекс действия:\n" +
                    "1 - Вывести в консоль данные об объекте\n" +
                    "2 - Изменить текущую скорость\n" +
                    "3 - Действия с пассажирами\n" +
                    "4 - Действия с дверьми\n" +
                    "5 - Действия с колёсами\n" +
                    "0 - Выход");

            boolean exit = false;
            int action = scanner.nextInt();
            if (action == 1) car.show();
            else if (action == 2) {
                System.out.println("Введите текущую скорость");
                car.setSpeed(scanner.nextInt());
            }
            else if (action == 3) passengers();
            else if (action == 4) carDoors();
            else if (action == 5) carWheels();
            else break;
        } while (true);
    }
}
