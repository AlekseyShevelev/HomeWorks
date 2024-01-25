package task2;

import java.time.LocalDate;

public class Customer {
    public enum Gender {
        MALE,
        FEMALE,
        UNKNOWN
    }

    private String fio;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String phone;

    public Customer(String fio, LocalDate dateOfBirth, Gender gender, String phone) {
        this.fio = fio;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phone = phone;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "fio='" + fio + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phone='" + phone + '\'' +
                '}';
    }
}
