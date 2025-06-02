package by.clevertec;

import by.clevertec.model.*;
import by.clevertec.util.Util;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static by.clevertec.model.AnimalZoo.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Задачки...");
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
        task11();
        task12();
        task13();
        task14();
        task15();
        task16();
        task17();
        task18();
        task19();
        task20();
        task21();
        task22();
    };


    public static void task1() {
        System.out.println("Задачка 1");
        List<Animal> animals = Util.getAnimals();
//        System.out.println(
//        animals.stream().filter(animal -> animal.getAge()>=10&&animal.getAge()<=20)
//                .sorted(Comparator.comparingInt(Animal::getAge))
//                .map(animal -> new AnimalZoo(animal, AnimalZoo.getIndexAnimal()/7))
//                .collect(Collectors.groupingBy(AnimalZoo::getIndexZoo))
//                .get(2)
//        );

        animals.stream().filter(animal -> animal.getAge()>=10&&animal.getAge()<=20)
                .sorted(Comparator.comparingInt(Animal::getAge))
                .map(animal -> new AnimalZoo(animal, AnimalZoo.getIndexAnimal()/7))
                .collect(Collectors.groupingBy(AnimalZoo::getIndexZoo))
                .get(2)
                .forEach(System.out::println);
    }

    public static void task2() {
        System.out.println("Задачка 2");
        List<Animal> animals = Util.getAnimals();

        animals.stream().filter(animal -> animal.getOrigin().equals("Japanese"))
               .map(animal -> animal.getGender().equals("Female")?animal.getBread().toUpperCase():animal.getBread())
               .forEach(System.out::println);
    }

    public static void task3() {
        System.out.println("Задачка 3");
        List<Animal> animals = Util.getAnimals();

        animals.stream().filter(animal -> animal.getAge()>30 && animal.getOrigin().charAt(0) == 'A')
                .map(animal -> animal.getOrigin())
                .distinct().forEach(System.out::println);

    }

    public static void task4() {
        System.out.println("Задачка 4");

        List<Animal> animals = Util.getAnimals();
        System.out.println(animals.stream()
                        .filter(animal -> animal.getGender().equals("Female"))
                        .count());
    }

    public static void task5() {
        System.out.println("Задачка 5");

        List<Animal> animals = Util.getAnimals();

        System.out.println(animals.stream()
                .filter(animal -> animal.getAge() >= 20 && animal.getAge() <= 30 && animal.getOrigin().equals("Hungarian"))
                .count());

// Второй вариант
        animals.stream()
                .filter(animal -> animal.getAge() >= 20 && animal.getAge() <= 30 && animal.getOrigin().equals("Hungarian"))
                .map(animal -> "Есть")
                .distinct()
                .forEach(System.out::println);
    }

//Взять всех животных. Все ли они пола Male и Female ?
//Ответ вывести в консоль
    public static void task6() {
        System.out.println("Задачка 6");

        List<Animal> animals = Util.getAnimals();

        animals.stream()
                .filter(animal -> !animal.getGender().equals("Male" ) && !animal.getGender().equals("Female" ))
                .map(animal -> "Нет")
                .distinct()
                .forEach(System.out::println);

        System.out.println(animals.stream()
                .allMatch(animal -> animal.getGender().equals("Male") || animal.getGender().equals("Female")));
    }

// Взять всех животных. Узнать что ни одно из них не имеет страну происхождения Oceania.
    public static void task7() {
        System.out.println("Задачка 7");

        List<Animal> animals = Util.getAnimals();

        animals.stream()
                .filter(animal -> !animal.getOrigin().equals("Oceania"))
                .map(animal -> "Животных из такой страны нет")
                .distinct()
                .forEach(System.out::println);

    }

//    Взять всех животных. Отсортировать их породу в стандартном порядке и взять первые 100.
//    Вывести в консоль возраст самого старого животного

    public static void task8() {
        List<Animal> animals = Util.getAnimals();

        System.out.println("Задачка 8");

        animals.stream()
                .sorted(Comparator.comparing(Animal::getBread))
                .limit(100)
                .sorted(Comparator.comparingInt(Animal::getAge).reversed())
                .limit(1)
                .forEach(System.out::println);
    }

//    Взять всех животных. Преобразовать их в породы, а породы в []char
//    Вывести в консоль длину самого короткого массива

    public static void task9() {
        List<Animal> animals = Util.getAnimals();

        System.out.println("Задачка 9");

        animals.stream()
                .map(animal -> animal.getBread().toCharArray().length)
                .sorted()
                .limit(1)
                .forEach(System.out::println);
    }

//    Взять всех животных. Подсчитать суммарный возраст всех животных. Вывести результат в консоль

    public static void task10() {
        List<Animal> animals = Util.getAnimals();

        System.out.println("Задачка 10");

        animals.stream()
                .map(Animal::getAge)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);

    }

//    Взять всех животных. Подсчитать средний возраст всех животных из индонезии (Indonesian). Вывести результат в консоль
    public static void task11() {
        List<Animal> animals = Util.getAnimals();

        System.out.println("Задачка 11");

        Optional op = Optional.of(
                animals.stream()
                .filter(animal -> animal.getOrigin().equals("Indonesian"))
                .collect(Collectors.averagingInt(Animal::getAge))
        );
        op.ifPresent(System.out::println);

    }

//    Во Французский легион принимают людей со всего света, но есть отбор по полу (только мужчины)
//    возраст от 18 до 27 лет. Преимущество отдаётся людям военной категории 1, на втором месте - военная категория 2,
//    и на третьем месте военная категория 3. Отсортировать всех подходящих кандидатов в порядке их
//    приоритета по военной категории. Однако взять на обучение академия может только 200 человек. Вывести их в консоль.

    public static void task12() {
        System.out.println("Задачка 12");

        List<Person> persons = Util.getPersons();
        persons.stream()
                .filter(person -> person.getGender().equals("Male")
                        && Period.between(person.getDateOfBirth(), LocalDate.now()).getYears() >= 18 &&
                           Period.between(person.getDateOfBirth(), LocalDate.now()).getYears() <= 27)
                .sorted(Comparator.comparingInt(Person::getRecruitmentGroup))
                .limit(200)
                .forEach(System.out::println);

    }

    public static void task13() {
        List<House> houses = Util.getHouses();
//        houses.stream() Продолжить ...
    }

    public static void task14() {
        List<Car> cars = Util.getCars();
//        cars.stream() Продолжить ...
    }

    public static void task15() {
        List<Flower> flowers = Util.getFlowers();
//        flowers.stream() Продолжить ...
    }

    public static void task16() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task17() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task18() {
        List<Student> students = Util.getStudents();
        List<Examination> examinations = Util.getExaminations();
//        students.stream() Продолжить ...
    }

    public static void task19() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task20() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task21() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }

    public static void task22() {
        List<Student> students = Util.getStudents();
//        students.stream() Продолжить ...
    }
}
