import animals.Animals;
import birds.Duck;
import generaldata.Commands;
import pets.Cat;
import pets.Dog;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        Dog dog = new Dog("Иван", 5, 6, "белый");
        Cat cat = new Cat("Маша", 4, 3, "черная");
        Duck duck = new Duck("Лиза", 2, 5, "желтая");
        List<Animals> animals;
        animals = new ArrayList<>();
        animals.add(dog);
        animals.add(cat);
        animals.add(duck);
        Scanner scan = new Scanner(System.in);

        boolean menu = true;
        while (menu) {
            System.out.println("Меню");
            System.out.println("Введите add для добавления");
            System.out.println("Введите list для печати списка");
            System.out.println("Введите exit для выхода");

            String input = scan.next().toUpperCase(Locale.ROOT).trim();

            Commands command = Commands.of(input);
            switch (command) {
                case ADD -> {
                    System.out.println("Выберите животное: cat/dog/duck");
                    input = scan.next();

                    String name;
                    int age;
                    int weight;
                    String color;

                    System.out.println("Введите имя животного");
                    name = scan.next();
                    System.out.println("Введите возраст животного");
                    age = Integer.parseInt(scan.next());
                    System.out.println("Введите вес животного");
                    weight = Integer.parseInt(scan.next());
                    System.out.println("Введите цвет животного");
                    color = scan.next();

                    Animals animal;
                    switch (input) {
                        case "cat" -> animal = new Cat(name, age, weight, color);
                        case "dog" -> animal = new Dog(name, age, weight, color);
                        case "duck" -> animal = new Duck(name, age, weight, color);
                        default -> {
                            System.out.println("Неверный выбор");
                            animal = null;
                        }
                    }
                    if (animal != null) {
                        animals.add(animal);
                        animal.say();
                        System.out.println("Животное добавлено");
                    }
                }
                case LIST -> animals.forEach(System.out::println);
                case EXIT -> {
                    System.out.println("Выход из программы");
                    menu = false;
                }
                default -> System.out.println("Неверное значение");
            }
        }
        System.out.println("Выход произведен...");
    }

}

