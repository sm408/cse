/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package lab3;

/**
 *
 * Name: Shubham Maurya
 * Roll No.: 2010110615
 * Course: CSD213
 */


class Person {
    private String name;
    private String address;
    private String phoneNumber;
    private String emailAddress;

    public Person(String name, String address, String phoneNumber, String emailAddress) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public String getEmailAddress() {
//        return emailAddress;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public void setEmailAddress(String emailAddress) {
//        this.emailAddress = emailAddress;
//    }

    
    
    
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}

class Student extends Person {
    public static final String FRESHMAN = "Freshman";
    public static final String SOPHOMORE = "Sophomore";
    public static final String JUNIOR = "Junior";
    public static final String SENIOR = "Senior";
    
    

    private String status;

    public Student(String name, String address, String phoneNumber, String emailAddress, String status) {
        super(name, address, phoneNumber, emailAddress);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "status='" + status + '\'' +
                "} " + super.toString();
    }
}

class Employee extends Person {
    private String office;
    private double salary;
    private String dateHired;

    public Employee(String name, String address, String phoneNumber, String emailAddress, String office, double salary, String dateHired) {
        super(name, address, phoneNumber, emailAddress);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    public String getOffice() {
        return office;
    }

    public double getSalary() {
        return salary;
    }

    public String getDateHired() {
        return dateHired;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDateHired(String dateHired) {
        this.dateHired = dateHired;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "office='" + office + '\'' +
                ", salary=" + salary +
                ", dateHired='" + dateHired + '\'' +
                "} " + super.toString();
    }
}

class Faculty extends Employee {
    private String officeHours;
    private String rank;

    public Faculty(String name, String address, String phoneNumber, String emailAddress, String office, double salary, String dateHired, String officeHours, String rank) {
        super(name, address, phoneNumber, emailAddress, office, salary, dateHired);
        this.officeHours = officeHours;
        this.rank = rank;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public String getRank() {
        return rank;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "officeHours='" + officeHours + '\'' +
                ", rank='" + rank + '\'' +
                "} " + super.toString();
    }
}


class Staff extends Employee {
    private String title;

    public Staff(String name, String address, String phoneNumber, String emailAddress, String office, double salary, String dateHired, String title) {
        super(name, address, phoneNumber, emailAddress, office, salary, dateHired);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "title='" + title + '\'' +
                "} " + super.toString();
    }
}


public class TestPerson {
    public static void main(String[] args) {
        Person person = new Person("John", "123 Main St", "123-456-7890", "jone@something.com");

        Student student = new Student("Jane", "456 Main St", "123-456-7890", Student.FRESHMAN, "jane@something.com");
    
            Employee employee = new Employee("Joe", "789 Main St", "123-456-7890", "123", "some@something", 100000.00, "1/1/2019");
    
                Faculty faculty = new Faculty("Jill", "101 Main St", "123-456-7890", "123", "someone@something", 100000.00, "1/1/2019", "9-5", "Professor");
    
                    Staff staff = new Staff("Jack", "111 Main St", "123-456-7890", "123", "someone@something", 100000.00, "1/1/2019", "Janitor");
    
                        System.out.println(person);
                        System.out.println(student);
                        System.out.println(employee);
                        System.out.println(faculty);
                        System.out.println(staff);
    }
}
