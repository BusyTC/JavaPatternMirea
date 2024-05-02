package practice_2;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Human> humans = List.of(
                new Human(13, "Владимир", "Иванов", LocalDate.of(2004, 10, 14), 65),
                new Human(55, "Алексей", "Петров", LocalDate.of(1963, 4, 3), 105),
                new Human(37, "Дмитрий", "Соколов", LocalDate.of(1966, 1, 2), 25),
                new Human(23, "Андрей", "Пономарев", LocalDate.of(1982, 2, 25), 15),
                new Human(81, "Юрий", "Гончаров", LocalDate.of(2000, 11, 4), 45),
                new Human(18, "Александр", "Зайцев", LocalDate.of(1980, 12, 2), 66),
                new Human(32, "Василий", "Смирнов", LocalDate.of(1999, 8, 25), 15),
                new Human(11, "Леонид", "Прохоров", LocalDate.of(1950, 5, 23), 34)
        );

        humans.stream()
                .sorted(Comparator.comparing(human -> human.birthDate))
                .forEach(System.out::println);
        System.out.println();

        humans.stream()
                .filter(human -> human.age < 50)
                .forEach(System.out::println);
        System.out.println();

        humans.stream()
                .sorted(Comparator.comparing(human -> human.weight))
                .forEach(System.out::println);
        System.out.println();

        String result = humans.stream().map(human -> human.firstName).collect(Collectors.joining(" "));
        System.out.println(result);


    }
}
