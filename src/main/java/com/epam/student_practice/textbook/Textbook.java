/**
 * Class containing notebook operations: loading and saving data, adding, deleting and searching records
 */
package main.java.com.epam.student_practice.textbook;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Textbook {
    ArrayList<Employee> employees;
    ArrayList<Manager> managers;
    String pathName;

    public Textbook(){
        employees = new ArrayList<>();
        managers = new ArrayList<>();
        pathName = "C://Users//Manya//Documents//Textbook//src//main//resources//data.txt";

        load();
    }

    private void load(){
        try(Scanner scanner = new Scanner(new File(pathName))) {
            while (scanner.hasNext()) {
                String[] row = scanner.nextLine().split(" ");
                String[] date = row[3].split("\\.");
                Date dateOfBirth = new Date(Integer.parseInt(date[2]) -1900, Integer.parseInt(date[1]), Integer.parseInt(date[0]));
                if (row[0].equals("employee")) {
                    Employee employee = new Employee(row[1], row[2], dateOfBirth, row[4], row[5]);
                    employees.add(employee);
                }
                else {
                    Manager manager = new Manager(row[1], row[2], dateOfBirth, row[4], row[5]);
                    managers.add(manager);
                }
            }
        }
        catch(IOException e){
                e.printStackTrace();
        }
    }

    private void sort(){
        Collections.sort(employees, Employee.lastNameComporator);
        Collections.sort(employees, Employee.dateOfBirthComparator);
        Collections.sort(managers, Manager.lastNameComporator);
        Collections.sort(managers, Manager.dateOfBirthComparator);
    }

    /**
     * To add a new record to the textbook
     * @param line string containing the type of person (employee or manager), last name, first name,
     *             date of birth, phone number, manager name (for employee) or department name (for manager), separated by space
     */
    public void add(String[] line){
        try {
            String[] date = line[3].split("\\.");
            if (Integer.parseInt(date[2]) > 1939) {
                Date dateOfBirth = new Date(Integer.parseInt(date[2]) - 1900, Integer.parseInt(date[1]), Integer.parseInt(date[0]));
                if (line[0].equals("e") || line[0].equals("employee")) {
                    Employee employee = new Employee(line[1], line[2], dateOfBirth, line[4], line[5]);
                    employees.add(employee);
                    System.out.println("Done!");
                }
                else
                    if (line[0].equals("m") || line[0].equals("manager")) {
                        Manager manager = new Manager(line[1], line[2], dateOfBirth, line[4], line[5]);
                        managers.add(manager);
                        System.out.println("Done!");
                    }
                    else
                        System.out.println("Error: incorrect input");
            }
            else
                System.out.println("Error: incorrect data");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Error: incorrect data");
        }
    }

    /**
     * To delete record from the textbook by phone number
     */
    public void delete(String phoneNumber){
        if(employees.removeIf(employee -> employee.phoneNumber.equals(phoneNumber)) ||
                managers.removeIf(manager -> manager.phoneNumber.equals(phoneNumber))){
            System.out.println("Done!");
        }
        else
            System.out.println("Error: incorrect input");
    }

    /**
     * To sort and save data to file, the path to which is recorded in the global pathName
     */
    public void save(){
        sort();
        try(PrintWriter printWriter = new PrintWriter(pathName)){
            for (Employee employee: employees) {
                printWriter.println(employee.toString());
            }
            for (Manager manager: managers) {
                printWriter.println(manager.toString());
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * To find and display information about a person(s) by last name, name or phone number
     * @param lost string containing last name, name or phone number
     */
    public void find(String lost){
        sort();
        boolean flag = true;
        for (Employee employee: employees) {
            if(employee.lastName.equals(lost) || employee.name.equals(lost) || employee.phoneNumber.equals(lost)){
                System.out.println(employee.toString());
                flag = false;
            }
        }
        for (Manager manager: managers) {
            if(manager.lastName.equals(lost) || manager.name.equals(lost) || manager.phoneNumber.equals(lost)) {
                System.out.println(manager.toString());
                flag = false;
            }
        }
        if(flag){
            System.out.println("No matches found");
        }
    }
}
