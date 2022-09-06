package pl.alski.cruddemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    //define the fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String Firstname;

    @Column(name = "last_name")
    private String LastName;

    @Column(name = "email")
    private String email;

    // define constructors
    public Employee(){
    }

    public Employee(String firstname, String lastName, String email) {
        Firstname = firstname;
        LastName = lastName;
        this.email = email;
    }

    //define getter/setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //define toString

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", Firstname='" + Firstname + '\'' +
                ", LastName='" + LastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
