package task1;

import java.io.Serializable;

public class Student implements Serializable {
    String name;
    int age;
    transient Double GPA;

    public Student(java.lang.String name, int age) {
        this.name = name;
        this.age = age;
    }

    public java.lang.String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public java.lang.String toString() {
        return "Student{" +
                "name=" + name +
                ", age=" + age +
                ", GPA=" + GPA +
                '}';
    }
}
