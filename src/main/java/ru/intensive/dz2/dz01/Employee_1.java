package ru.intensive.dz2.dz01;

public class Employee_1 {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee_1(String fullName,String position,String email,String phone,int salary,int age){
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return "Employee_1{" +
                "fullName+'" + fullName + '\'' +
                "position+'" + position + '\'' +
                "email+" + email + '\'' +
                "phone+'" + phone + '\'' +
                "salary+" + salary +
                "age+" + age +
                "}";
    }
}

