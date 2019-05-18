package main.java.com.epam.student_practice.textbook;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Textbook {
    ArrayList<Employee> employees;
    ArrayList<Manager> managers;
    String pathName;

    public Textbook(){
        employees = new ArrayList<>();
        managers = new ArrayList<>();
        pathName = "C://Users//Manya//Documents//Textbook//src//main//resources//data.txt";

        load();
        sort();
    }

    private void load(){
        try(Scanner scanner = new Scanner(new File(pathName))){
            while (scanner.hasNext()){
                String[] row =scanner.nextLine().split(" ");
                if(row[0] == "employee"){
                    Employee employee = new Employee(row[1], row[2], Integer.parseInt(row[3]), row[4], row[5]);
                    employees.add(employee);
                }
                else{
                    Manager manager = new Manager(row[1], row[2], Integer.parseInt(row[3]), row[4], row[5]);
                    managers.add(manager);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void sort(){
        Collections.sort(employees, Employee.lastNameComporator);
        Collections.sort(employees, Employee.dateOfBirthComparator);
        Collections.sort(managers, Manager.lastNameComporator);
        Collections.sort(managers, Manager.dateOfBirthComparator);
    }

    public void add(){
        System.out.println("Enter last name, name, date of birth, phone number, manager name, separated by space");
        sort();
    }

    public void delete(){

    }

    public void save(){
        try(PrintWriter printWriter = new PrintWriter(pathName)){
            for (Employee employee: employees) {
                printWriter.println(employee.toString());
            }
            for (Manager manager: managers) {
                printWriter.println(manager.toString());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void find(String lost){
        for (Employee employee: employees) {
            if(employee.lastname == lost || employee.name == lost || employee.phoneNumber == lost){
                System.out.println(employee.toString());
            }
        }
        for (Manager manager: managers) {
            if(manager.lastname == lost || manager.name == lost || manager.phoneNumber == lost) {
                System.out.println(manager.toString());
            }
        }
    }

}
