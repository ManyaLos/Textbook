package main.java.com.epam.student_practice.textbook;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Textbook textbook = new Textbook();

        try(Scanner scanner = new Scanner(System.in)) {
            while(scanner.hasNext()){
                String line = scanner.nextLine();
                switch (line){
                    case "add": System.out.println("Enter human type, last name, name, date of birth (format dd.mm.yyyy)," +
                            " phone number, manager name (for employee) or department name (for manager), separated by space");
                        String[] row = scanner.nextLine().split(" ");
                        textbook.add(row);
                        break;
                    case "delete": System.out.println("Enter phone number of the person, you want to delete");
                        String phoneNumber = scanner.nextLine();
                        textbook.delete(phoneNumber);
                        break;
                    case "find": System.out.println("Enter last name or name or phone number of person, you want to find");
                        String lost = scanner.nextLine();
                        textbook.find(lost);
                        break;
                    case "exit": textbook.save();
                        return;
                        default: System.out.println("Incorrect request. Available requests: add, delete, find, exit");
                }
            }
        }
    }
}
