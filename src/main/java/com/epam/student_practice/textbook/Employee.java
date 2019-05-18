package main.java.com.epam.student_practice.textbook;

public class Employee extends Human{
    String managerName;

    public Employee(String lastName, String name, int dateOfBirth, String phoneNumber, String managerName){
        super(lastName, name, dateOfBirth, phoneNumber);
        this.managerName = managerName;
    }

    @Override
    public String toString(){
        return "employee " + lastname + " " + name + " " + dateOfBirth + " " + phoneNumber + " " + managerName;
    }
}
