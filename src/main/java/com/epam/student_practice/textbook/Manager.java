package main.java.com.epam.student_practice.textbook;

public class Manager extends Human {
    String departmentName;

    public Manager(String lastName, String name, int dateOfBirth, String phoneNumber, String departmentName){
        super(lastName, name, dateOfBirth, phoneNumber);
        this.departmentName = departmentName;
    }

    @Override
    public String toString(){
        return "manager "+ lastname + " " + name + " " + dateOfBirth + " " + phoneNumber + " " + departmentName;
    }
}
