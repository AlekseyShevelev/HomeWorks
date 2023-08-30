public class Client {
    private String lastName;
    private String firstName;
    private String middleName;
    private int phone;
    
    public Client(String lastName, String firstName, String middleName, int phone) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("<%s><%s><%s><%d>", lastName, firstName, middleName, phone);
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getPhone() {
        return phone;
    }
}
