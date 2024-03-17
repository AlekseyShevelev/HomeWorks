package task1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    /**
     * Условие:
     * Создать проект с использованием Maven или Gradle, добавить в него несколько зависимостей и написать код, использующий эти зависимости.
     * Пример решения:
     * 1. Создайте новый Maven или Gradle проект, следуя инструкциям из блока 1 или блока 2.
     * 2. Добавьте зависимости org.apache.commons:commons-lang3:3.14.0 и com.google.code.gson:gson:2.10.1.
     * 3. Создайте класс Person с полями firstName, lastName и age.
     * 4. Используйте библиотеку commons-lang3 для генерации методов toString, equals и hashCode.
     * 5. Используйте библиотеку gson для сериализации и десериализации объектов класса Person в формат JSON.
     */
    public static void main(String[] args) {
        Person person1 = new Person("Иван", "Петров", 25);
        Person person2 = new Person("Иван", "Петров", 27);

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person1.equals(person2));
        System.out.println("person1: " + person1.hashCode() + "; person2: " + person2.hashCode());

        String personJson = personToJson(person1);
        System.out.println(personJson);
        System.out.println(personFromJson(personJson));
    }

    private static String personToJson(Person person) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        return gson.toJson(person);
    }

    private static Person personFromJson(String json) {
        return new Gson().fromJson(json, Person.class);
    }
}
