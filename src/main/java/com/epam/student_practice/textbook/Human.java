/**
 * Abstract class containing general information of employees and managers includes comparators to compare class
 * instances by last name and date of birth
 */
package main.java.com.epam.student_practice.textbook;

import java.util.Comparator;
import java.util.Date;

abstract class Human{
    String lastName;
    String name;
    Date dateOfBirth;
    String phoneNumber;

    public Human(String lastName, String name, Date dateOfBirth, String phoneNumber){
        this.lastName = lastName;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

    public static Comparator<Human> lastNameComporator = new Comparator<Human>() {
        @Override
        public int compare(Human o1, Human o2) {
            return o1.lastName.compareTo(o2.lastName);
        }
    };

    public static Comparator<Human> dateOfBirthComparator = new Comparator<Human>() {
        @Override
        public int compare(Human o1, Human o2) {
            if(o1.dateOfBirth.before(o2.dateOfBirth)){
                return -1;
            }
            else
                if(o1.dateOfBirth.after(o2.dateOfBirth)){
                    return  1;
                }
                else
                    return 0;
        }
    };
}
