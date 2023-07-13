package ru.intensive.dz2.dz01;

public class ExampleForEmployee {

    private static final Employee[] employeeArray = new Employee[5];

    static {
        employeeArray[0] = new Employee( "Ivanov Aleksandr", "Programmer",  "petr@mailbox.com", "+79219212112", 60000, 29);
        employeeArray[1] = new Employee( "Yelisseyev Petr", "DevOps",  "petr@mailbox.com", "+79219212112", 60000, 42);
        employeeArray[2] = new Employee( "Petrov Alik", "Engineer",  "petr@mailbox.com", "+79219212112", 60000, 43);
        employeeArray[3] = new Employee( "Zunchenko Ed", "HR",  "petr@mailbox.com", "+79219212112", 60000, 29);
        employeeArray[4] = new Employee( "Petrushishin Ivan", "Director",  "petr@mailbox.com", "+79219212112", 60000, 29);
    }



    public static void main(String[] args) {
        for (Employee e : employeeArray) {
            if (e.getAge() > 40) {
                System.out.println(e);
            }
        }
    }
}