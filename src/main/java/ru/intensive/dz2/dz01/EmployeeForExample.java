package ru.intensive.dz2.dz01;

public class EmployeeForExample {

    private static final Employee[] employeeArray = new Employee[5];

    static {
        employeeArray[0] = new Employee( "Savchenko Dmitrii", "DevOps",  "petr@mailbox.com", "+79219212112", 60000, 29);
        employeeArray[1] = new Employee( "Ignatov Petr", "DevOps",  "petr@mailbox.com", "+79219212112", 60000, 42);
        employeeArray[2] = new Employee( "Ignatov Petr", "DevOps",  "petr@mailbox.com", "+79219212112", 60000, 43);
        employeeArray[3] = new Employee( "Ignatov Petr", "DevOps",  "petr@mailbox.com", "+79219212112", 60000, 29);
        employeeArray[4] = new Employee( "Ignatov Petr", "DevOps",  "petr@mailbox.com", "+79219212112", 60000, 29);
    }



    public static void main(String[] args) {
        for (Employee e : employeeArray) {
            if (e.getAge() > 40) {
                System.out.println(e);
            }
        }
    }
}