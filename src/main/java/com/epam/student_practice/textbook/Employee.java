package main.java.com.epam.student_practice.textbook;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee extends Human{
    String managerName;

    public Employee(String lastName, String name, Date dateOfBirth, String phoneNumber, String managerName){
        super(lastName, name, dateOfBirth, phoneNumber);
        this.managerName = managerName;
    }

    /**
     * display of class instance data
     * @return a string containing the class fields, separated by a space
     */
    @Override
    public String toString(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        return "employee " + lastName + " " + name + " " + formatter.format(dateOfBirth) + " " + phoneNumber + " " + managerName;
    }
}
