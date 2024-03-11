package task1;

import java.io.*;

public class Main {
    private static final String FILE_NAME = "student.bin";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student1 = new Student("Иван Петров", 21);
        student1.setGPA(4.5);
        System.out.println(student1);

        try (FileOutputStream fos = new FileOutputStream(FILE_NAME)) {
            ObjectOutputStream ous = new ObjectOutputStream(fos);
            ous.writeObject(student1);
            System.out.println("Объект Student сериализован.");
        }

        Student student2;

        try (FileInputStream fis = new FileInputStream(FILE_NAME)) {
            ObjectInputStream ois = new ObjectInputStream(fis);
            student2 = (Student) ois.readObject();
            System.out.println("Объект Student десериализован.");
        }

        System.out.println(student2);
    }
}
