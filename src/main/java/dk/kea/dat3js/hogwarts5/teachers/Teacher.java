package dk.kea.dat3js.hogwarts5.teachers;

import dk.kea.dat3js.hogwarts5.house.House;
import dk.kea.dat3js.hogwarts5.interfaces.PersonWithNames;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Teacher implements PersonWithNames {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    @ManyToOne
    private House house;
    private String teachingSubject;

    public Teacher() {
    }

    public Teacher(String fullName, House house, String teachingSubject) {
        this.setFullName(fullName);
        this.house = house;
        this.teachingSubject = teachingSubject;
    }

    public Teacher(String firstName, String lastName, House house, String teachingSubject) {
        this(firstName, null, lastName, house, teachingSubject);
    }

    public Teacher(String firstName, String middleName, String lastName, House house, String teachingSubject) {
        this.setFirstName(firstName);
        this.setMiddleName(middleName);
        this.setLastName(lastName);
        this.house = house;
        this.teachingSubject = teachingSubject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = (firstName!=null?capitalize(firstName) : null);
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = (middleName!=null?capitalize(middleName) : null);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = (lastName!=null?capitalize(lastName) : null);
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public String getTeachingSubject() {
        return teachingSubject;
    }

    public void setTeachingSubject(String teachingSubject) {
        this.teachingSubject = teachingSubject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher Teacher = (Teacher) o;
        return Objects.equals(getFirstName(), Teacher.getFirstName()) && Objects.equals(getMiddleName(), Teacher.getMiddleName()) && Objects.equals(getLastName(), Teacher.getLastName()) && Objects.equals(getHouse().getName(), Teacher.getHouse().getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getMiddleName(), getLastName(), getHouse().getName());
    }

}
