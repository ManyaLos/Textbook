package main.java.com.epam.student_practice.textbook;

import java.util.Comparator;

abstract class Human{
    String lastname;
    String name;
    int dateOfBirth;
    String phoneNumber;

    public Human(String lastName, String name, int dateOfBirth, String phoneNumber){
        this.lastname = lastName;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    public static Comparator<Human> lastNameComporator = new Comparator<Human>() {
        @Override
        public int compare(Human o1, Human o2) {
            return o1.lastname.compareTo(o2.lastname);
        }
    };

    public static Comparator<Human> dateOfBirthComparator = new Comparator<Human>() {
        @Override
        public int compare(Human o1, Human o2) {
            return o1.dateOfBirth - o2.dateOfBirth;
        }
    };
}
