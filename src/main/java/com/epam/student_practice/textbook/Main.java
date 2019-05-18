package main.java.com.epam.student_practice.textbook;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Textbook textbook = new Textbook();

        try(Scanner scanner = new Scanner(System.in)) {
            while(scanner.hasNext()){
                switch (scanner.next()){
                    case "add": textbook.add();
                        break;
                    case "delete": textbook.delete();
                        break;
                    case "exit": textbook.save();
                        return;
                    default: textbook.find(scanner.next());
                        break;
                }
            }
        }
    }
}
