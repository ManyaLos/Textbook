package main.java.com.epam.student_practice.textbook;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Manager extends Human {
    String departmentName;

    public Manager(String lastName, String name, Date dateOfBirth, String phoneNumber, String departmentName){
        super(lastName, name, dateOfBirth, phoneNumber);
        this.departmentName = departmentName;
    }

    /**
     * display of class instance data
     * @return a string containing the class fields, separated by a space
     */
    @Override
    public String toString(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        return "manager "+ lastName + " " + name + " " + formatter.format(dateOfBirth) + " " + phoneNumber + " " + departmentName;
    }
}
