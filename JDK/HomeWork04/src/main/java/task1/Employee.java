package task1;

public class Employee {
    private String number;
    private String phone;
    private String fio;
    private int seniority;

    public Employee(String number, String phone, String fio, int seniority) {
        this.number = number;
        this.phone = phone;
        this.fio = fio;
        this.seniority = seniority;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    @Override
    public String toString() {
        return String.format("Сотрудник № %s, %s, тел.: %s, стаж %d",
                number, fio, phone, seniority);
    }
}
